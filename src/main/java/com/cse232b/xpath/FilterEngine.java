package com.cse232b.xpath;

import com.cse232b.antlr4.XPathBaseVisitor;
import com.cse232b.antlr4.XPathParser;
import com.cse232b.xpath.RpEngine;
import org.w3c.dom.Node;

import java.util.List;

/**
 * @author chenpeng + zhaohanqing
 * @version 1.0
 * @date 1/29/24 3:39 PM
 * @description
 */
public class FilterEngine extends XPathBaseVisitor<Boolean> {

    private Node paramNode = null;
	private final RpEngine engine = new RpEngine();

    // Attention: param nodes are set in a value-based way. Any callee can modify or return it exclusively.
    public void setPNode(Node origin){
		paramNode = origin;
    }

    @Override
    public Boolean visitRpFilter(XPathParser.RpFilterContext ctx) {
		engine.setPNode(paramNode);
        List<Node> res = engine.visit(ctx.rp());
        return !res.isEmpty();
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
		String stringConstant = ctx.stringCondition().StringConstant().getText();
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
