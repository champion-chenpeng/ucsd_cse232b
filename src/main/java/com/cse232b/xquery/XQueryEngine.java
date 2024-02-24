package com.cse232b.xquery;

import com.cse232b.XMLProcessor;
import com.cse232b.antlr4.XPathParser.ApContext;
import com.cse232b.antlr4.XPathParser.RpContext;

import com.cse232b.antlr4.XQueryBaseVisitor;
import com.cse232b.antlr4.XQueryParser;
import com.cse232b.xpath.XPathEngine;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;


/**
 * @author rx_w@outlook.com
 * @version 1.0
 * @date 2/20/22 12:28 PM
 * @description
 */
public class XQueryEngine extends XQueryBaseVisitor<List<Node>>{
    private final Document tmpDoc;
	private final XPathEngine xpathEngine = new XPathEngine();

    private Map<String, List<Node>> contextMap = new HashMap<>();
    private List<Map<String, List<Node>>> forClausePerStates = new ArrayList<>();
	
// constructor
    public XQueryEngine(Document tmpDoc) {
        this.tmpDoc = tmpDoc;
    }

    void setContextMap(Map<String,List<Node>> c) {
        this.contextMap = new HashMap<>(c);
    }

	Map<String, List<Node> > getContextMap() {
		return this.contextMap;
	}

    private final List<Node> DEFAULT_COND_TRUE_LIST = new ArrayList<>(0);

    // TODO:need another getDescendents method here to parse #doubleSlashXQ. Get proper pNodes then call XPathEvaluator.

    // helper function to get all strict descendents of a node
    public LinkedList<Node> getStrictDescendents(Node node) {

        LinkedList<Node> res = new LinkedList<>(); // result

        NodeList childrenNodes = node.getChildNodes();
        for (int i = 0; i < childrenNodes.getLength(); i++) {
            Node curtChild = childrenNodes.item(i);
            res.add(curtChild); // add a child
            res.addAll(getStrictDescendents(curtChild));
        }
        return res;
    }

    // helper function to obtain the self-and-descendents set of all the input nodes
    public LinkedList<Node> getSelfAndDescendents(List<Node> nodes){

        LinkedList<Node> res = new LinkedList<>(nodes);

        // store all the strict descendents of nodes into tmp
        LinkedList<Node> tmp = new LinkedList<>();
        for (Node node : nodes) {
            tmp.addAll(getStrictDescendents(node));
        }

        // add all descendents of nodes to res while removing duplicates
        for (Node node : tmp) {
            if (!res.contains(node)) {
                res.add(node);
            }
        }

        return res;
    }


    private Node makeElem(String tag, List<Node> children) {
        Node r = tmpDoc.createElement(tag);
        for (Node n : children) {
            if (n != null) {
                Node newNode = this.tmpDoc.importNode(n,true);
                r.appendChild(newNode);
            }
        }
        return r;
    }

    @Override
    public List<Node> visitFLWR(XQueryParser.FLWRContext ctx) {
        List<Map<String, List<Node>>> oldStatesInForClause = this.forClausePerStates;
        visit(ctx.forClause()); //after this, varsInForClause is set. return is null
        List<Map<String, List<Node>>> currentCheckStates = this.forClausePerStates;
        // do not use current context, it is meaningless
        // update every per state with let
        XQueryParser.LetClauseContext letClauseCtx = ctx.letClause();
        if (letClauseCtx != null) {
            for (int i = 0; i < currentCheckStates.size(); i++) {
                Map<String, List<Node>> toUpdateContext = currentCheckStates.get(i);
                setContextMap(toUpdateContext);
                visit(ctx.letClause());
                currentCheckStates.set(i,this.contextMap);
            }
        }
        List<Node> res = new LinkedList<>();
        for(Map<String, List<Node>> state : currentCheckStates) {
            this.setContextMap(state);
            // if no where clause, then where clause returns always true.
            XQueryParser.WhereClauseContext whereCtx = ctx.whereClause();
            List<Node> nullIfFalseList = whereCtx != null ? visit(ctx.whereClause()) : new LinkedList<>();
            if (nullIfFalseList != null) {
                // where return true
                this.setContextMap(state);
                List<Node> onePermRes = visit(ctx.returnClause());
                res.addAll(onePermRes);
            }
        }
        this.forClausePerStates = oldStatesInForClause;
        return res;
    }

    @Override
    public List<Node> visitSingleSlashXQ(XQueryParser.SingleSlashXQContext ctx) {

        String rpText = ctx.rp().getText();
        InputStream i = new ByteArrayInputStream(rpText.getBytes());

		List<Node> res1 = visit(ctx.xq());
		LinkedList<Node> res2 = new LinkedList<>(); 
		RpContext rp = XMLProcessor.parseXPathRp(i);
		for (Node node : res1) {
			xpathEngine.rpEngine.setPNode(node);
			res2.addAll(xpathEngine.rpEngine.visit(rp));
		}
		return res2;
    }

    @Override
    public List<Node> visitTagXQ(XQueryParser.TagXQContext ctx) {
        String tag = ctx.startTag().tagName().ID().getText();
        LinkedList<Node> res = new LinkedList<>();

        setContextMap(contextMap);
        List<Node> nodeList = visit(ctx.xq());

        Node node = makeElem(tag, nodeList);
        res.add(node);

        return res;
    }

    @Override
    public List<Node> visitApXQ(XQueryParser.ApXQContext ctx) {
        setContextMap(contextMap);
        String apText = ctx.getText();
        InputStream is = new ByteArrayInputStream(apText.getBytes());
		ApContext ap = XMLProcessor.parseXPathAp(is);
        return xpathEngine.visit(ap);
    }

    @Override
    public List<Node> visitLetXQ(XQueryParser.LetXQContext ctx) {
        // prepare vars
        visit(ctx.letClause());
        Map<String,List<Node>> currentContext = this.contextMap;
        setContextMap(currentContext);
        List<Node> res = visit(ctx.xq());
        return res;

    }

    @Override
    public List<Node> visitCommaXQ(XQueryParser.CommaXQContext ctx) {
        Map<String, List<Node>> currentCtxMap = contextMap;
        setContextMap(currentCtxMap);
        List<Node> res1 = visit(ctx.xq(0));
        setContextMap(currentCtxMap);
        List<Node> res2 = visit(ctx.xq(1));

        res1.addAll(res2);
        return res1;
    }

    @Override
    public List<Node> visitVarXQ(XQueryParser.VarXQContext ctx) {
        setContextMap(contextMap);
        // TODO: bugfix, get terminate node ID's text as key [fixed]
        // TODO: bugfix, change get method to getOrDefault method so as to avoid null return value [fixed]
        return this.contextMap.getOrDefault(ctx.var().ID().getText(), new LinkedList<Node>());
    }

    @Override
    public List<Node> visitScXQ(XQueryParser.ScXQContext ctx) {
        String str = ctx.StringConstant ().getText();
        // TODO: test whether this is necessary
        str = str.substring(1, str.length() - 1); // remove the left parenthesis and the right parenthesis

        LinkedList<Node> res = new LinkedList<>();
        res.add(this.tmpDoc.createTextNode(str));   // performs makeText()

        return res;
    }

    @Override
    public List<Node> visitBraceXQ(XQueryParser.BraceXQContext ctx) {
        setContextMap(contextMap);
        return visit(ctx.xq());
    }

    @Override
    public List<Node> visitDoubleSlashXQ(XQueryParser.DoubleSlashXQContext ctx) {

        String rpText = ctx.rp().getText();
        InputStream i = new ByteArrayInputStream(rpText.getBytes());

        List<Node> xqRes = getSelfAndDescendents(visit(ctx.xq()));  // get the proper context nodes for rp parsing
		LinkedList<Node> res2 = new LinkedList<>(); 
		RpContext rp = XMLProcessor.parseXPathRp(i);
		for (Node node : xqRes) {
			xpathEngine.rpEngine.setPNode(node);
			res2.addAll(xpathEngine.rpEngine.visit(rp));
		}
		return res2;
    }

    public void dfsForVarState(XQueryParser.ForClauseContext ctx,
                               int curIndex,
                               Map<String, List<Node>> curMap,
                               List<Map<String,List<Node>>> perStates) {
        List<Node> res;

        if(ctx.var().size() == curIndex) {
            perStates.add(curMap);
            return;
        }
        String var = ctx.var(curIndex).ID().getText();
        XQueryParser.XqContext xq = ctx.xq(curIndex);
        setContextMap(curMap);
        res = visit(xq);
        for (Node node : res) {
            Map<String, List<Node>> nextMap = new HashMap<>(curMap);
            LinkedList<Node> curNodeList = new LinkedList<>();
            curNodeList.add(node);
            nextMap.put(var, curNodeList);   // results in a deeper context map extended on the basis of the current context map

            dfsForVarState(ctx, curIndex + 1, nextMap, perStates);
        }

    }

    @Override
    public List<Node> visitForClause(XQueryParser.ForClauseContext ctx) {
        // for should generate all permutation state maps and then set perStates in this class for FLWR
        Map<String,List<Node>> currentContext = this.contextMap;
        List<Map<String, List<Node>>> targetPerStates = new ArrayList<>();
        // set for FLWR
       dfsForVarState(ctx, 0,currentContext,targetPerStates);
       this.forClausePerStates = targetPerStates;
       return null;
    }

    @Override
    public List<Node> visitLetClause(XQueryParser.LetClauseContext ctx) {
        Map<String, List<Node>> currentContext = this.contextMap;
        List<XQueryParser.VarContext> vars = ctx.var();
        int varCnt = vars.size();
        List<XQueryParser.XqContext> xqs = ctx.xq();
        for (int i = 0; i < varCnt; i++) {
            String varName = vars.get(i).ID().getText();
            setContextMap(currentContext);
            List<Node> xqResult = visit(xqs.get(i));
            currentContext.put(varName, xqResult);
        }
        setContextMap(currentContext);
        return null;
    }

    @Override
    public List<Node> visitWhereClause(XQueryParser.WhereClauseContext ctx) {
        // with given context, return the boolean result of cond
		CondEngine condEngine = new CondEngine();
		condEngine.xqueryEngine = this;
        return condEngine.visit(ctx.cond()) ? DEFAULT_COND_TRUE_LIST : null;
    }

    @Override
    public List<Node> visitReturnClause(XQueryParser.ReturnClauseContext ctx) {
        // with given context, evaluate xq. should use the same context with where clause.
        return visit(ctx.xq());
    }
}
