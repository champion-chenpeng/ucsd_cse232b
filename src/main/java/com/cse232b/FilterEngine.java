package com.cse232b;

import com.cse232b.antlr4.XPathBaseVisitor;
import com.cse232b.antlr4.XPathParser;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author chenpeng + zhaohanqing
 * @version 1.0
 * @date 1/29/24 3:39 PM
 * @description
 */
public class FilterEngine extends XPathBaseVisitor<Boolean> {

    private Node paramNode = null;
	private RpEngine engine = new RpEngine();

    // Attention: param nodes are set in a value-based way. Any callee can modify or return it exclusively.
    public void setPNode(Node origin){
		paramNode = origin;
    }

    @Override
    public Boolean visitRpFilter(XPathParser.RpFilterContext ctx) {
		engine.setPNode(paramNode);
        List<Node> res = engine.visit(ctx.rp());
        return res.size() > 0;
    }

    @Override
    public Boolean visitEqFilter(XPathParser.EqFilterContext ctx) {
		engine.setPNode(paramNode);
        List<Node> res1 = engine.visit(ctx.rp(0));
		engine.setPNode(paramNode);
        List<Node> res2 = engine.visit(ctx.rp(1));
        for (Node x : res1) {
			for (Node y: res2) {
    			if (x.isEqualNode(y)) {
        			return true;
    			}
			}
        }
        return false;
    }

    @Override
    public Boolean visitIsFilter(XPathParser.IsFilterContext ctx) {
		engine.setPNode(paramNode);
        List<Node> res1 = engine.visit(ctx.rp(0));
		engine.setPNode(paramNode);
        List<Node> res2 = engine.visit(ctx.rp(1));
        for (Node x : res1) {
            for (Node y: res2) {
                if (x.isSameNode(y)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Boolean visitStringFilter(XPathParser.StringFilterContext ctx) {
		engine.setPNode(paramNode);
        List<Node> res1 = engine.visit(ctx.rp());
		String stringConstant = ctx.stringConstant().ID().getText();
        for (Node x : res1) {
            if (x.getTextContent().equals(stringConstant)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean visitBracketFilter(XPathParser.BracketFilterContext ctx) {
        return visit(ctx.f());
    }

    @Override
    public Boolean visitAndFilter(XPathParser.AndFilterContext ctx) {
        return visit(ctx.f(0)) && visit(ctx.f(1));
    }

    @Override
    public Boolean visitOrFilter(XPathParser.OrFilterContext ctx) {
		return visit(ctx.f(0)) || visit(ctx.f(1));
    }

    @Override
    public Boolean visitNotFilter(XPathParser.NotFilterContext ctx) {
		return !visit(ctx.f());
    }
}
