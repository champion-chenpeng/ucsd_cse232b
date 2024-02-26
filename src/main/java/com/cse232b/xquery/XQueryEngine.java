package com.cse232b.xquery;

import com.cse232b.XMLProcessor;
import com.cse232b.antlr4.XPathParser.ApContext;
import com.cse232b.antlr4.XPathParser.RpContext;

import com.cse232b.antlr4.XQueryBaseVisitor;
import com.cse232b.antlr4.XQueryParser;
import com.cse232b.xpath.XPathEngine;
import org.antlr.v4.runtime.misc.Interval;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;


 /**
  * @author Peng Chen, Hanqing Zhao
  * @version 1.0
  * @date 02/23/2024
  * @description
  */
public class XQueryEngine extends XQueryBaseVisitor<List<Node>>{
    private final Document tmpDoc;
	private final XPathEngine xpathEngine = new XPathEngine();

    private Map<String, List<Node>> contextMap = new HashMap<>();
	
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
	public List<Node> visitFLWR(XQueryParser.FLWRContext ctx) {
		ClauseEngine clauseEngine = new ClauseEngine(this);
		return clauseEngine.visit(ctx);
	}

    @Override
    public List<Node> visitApXQ(XQueryParser.ApXQContext ctx) {
        setContextMap(contextMap);
		int a = ctx.start.getStartIndex(), b = ctx.stop.getStopIndex();
		Interval interval = new Interval(a, b);
		String apText = ctx.start.getInputStream().getText(interval);
        InputStream is = new ByteArrayInputStream(apText.getBytes());
		ApContext ap = XMLProcessor.parseXPathAp(is);
        return xpathEngine.visit(ap);
    }

    @Override
    public List<Node> visitLetXQ(XQueryParser.LetXQContext ctx) {
        // prepare vars
		ClauseEngine clauseEngine = new ClauseEngine(this);
        clauseEngine.visit(ctx.letClause());
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

}
