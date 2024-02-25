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
  * @author Peng Chen, Hanqing Zhao
  * @version 1.0
  * @date 02/23/2024
  * @description
  */
public class CondEngine extends XQueryBaseVisitor<Boolean> {
	private XQueryEngine xqueryEngine;
	public CondEngine(XQueryEngine xqueryEngine_) {
		this.xqueryEngine = xqueryEngine_;
	}

    @Override
    public Boolean visitEqCond(XQueryParser.EqCondContext ctx) {
        Map<String, List<Node>> currentCtxMap = xqueryEngine.getContextMap();

        xqueryEngine.setContextMap(currentCtxMap);
        List<Node> l = xqueryEngine.visit(ctx.xq(0));
        xqueryEngine.setContextMap(currentCtxMap);
        List<Node> r = xqueryEngine.visit(ctx.xq(1));

        for (Node ln: l) {
            for (Node rn: r) {
                if (ln.isEqualNode(rn)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Boolean visitIsCond(XQueryParser.IsCondContext ctx) {
        Map<String, List<Node>> currentCtxMap = xqueryEngine.getContextMap();

        xqueryEngine.setContextMap(currentCtxMap);
        List<Node> l = xqueryEngine.visit(ctx.xq(0));
        xqueryEngine.setContextMap(currentCtxMap);
        List<Node> r = xqueryEngine.visit(ctx.xq(1));

        for (Node ln: l) {
            for (Node rn: r) {
                if (ln.isSameNode(rn)) {
                    return true;
                }
            }
        }
        return false;
    }
// named
    @Override
    public Boolean visitEmptyCond(XQueryParser.EmptyCondContext ctx) {
        List<Node> res = xqueryEngine.visit(ctx.xq());
        if (res.size() != 0) return false;
		return true;
    }


    @Override
    public Boolean visitSatisfyCond(XQueryParser.SatisfyCondContext ctx) {
        return visitSomeVarXq(ctx, 0, xqueryEngine.getContextMap());   // call in a recursive way
    }

    public Boolean visitSomeVarXq(XQueryParser.SatisfyCondContext ctx, int curIndex, Map<String, List<Node>> curMap) {
        List<Node> res;
        Boolean finalRes;

        if (ctx.var().size() == curIndex) { // iteration reached the end
            xqueryEngine.setContextMap(curMap);
            return visit(ctx.cond());   // apply condition at the deepest context map
        }

        String var = ctx.var(curIndex).ID().getText() ;
        XQueryParser.XqContext xq = ctx.xq(curIndex);

        xqueryEngine.setContextMap(curMap);
        res = xqueryEngine.visit(xq);  // the query result of the index_th xq (corresponding to the index_th var)

        for (Node node : res) {
            Map<String, List<Node>> nextMap = new HashMap<>(curMap);
            LinkedList<Node> curNodeList = new LinkedList<>();
            curNodeList.add(node);
            nextMap.put(var, curNodeList);   // results in a deeper context map extended on the basis of the current context map

            finalRes = visitSomeVarXq(ctx, curIndex + 1, nextMap);
            if (finalRes) return finalRes;   // condition satisfied
        }

        return false;
    }

    @Override
    public Boolean visitBraceCond(XQueryParser.BraceCondContext ctx) {
        return visit(ctx.cond());
    }


// logic
    @Override
    public Boolean visitAndCond(XQueryParser.AndCondContext ctx) {
		return visit(ctx.cond(0)) && visit(ctx.cond(1));
    }

    @Override
    public Boolean visitOrCond(XQueryParser.OrCondContext ctx) {
		return visit(ctx.cond(0)) || visit(ctx.cond(1));
    }

    @Override
    public Boolean visitNotCond(XQueryParser.NotCondContext ctx) {
		return !visit(ctx.cond());
    }
}
