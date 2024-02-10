package com.cse232b;

import com.cse232b.antlr4.XPathBaseVisitor;
import com.cse232b.antlr4.XPathParser;
import org.w3c.dom.Node;

import java.util.List;

/**
 * @author chenpeng + zhaohanqing
 * @version 1.0
 * @date 1/29/24 3:39 PM
 * @description
 */
public class Engine extends XPathBaseVisitor<List<Node>> {
	private final RpEngine rpVisitor = new RpEngine();

    @Override
    public List<Node> visitDoc(XPathParser.DocContext ctx) {
        try {
            return XMLProcessor.parse(ctx.fileName().FILENAME().getText());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Node> visitSingleAP(XPathParser.SingleAPContext ctx) {
        Node resDoc = visit(ctx.doc()).get(0);
        rpVisitor.setPNode(resDoc);
		return rpVisitor.visit(ctx.rp());
    }

    @Override
    public List<Node> visitDoubleAP(XPathParser.DoubleAPContext ctx) {
        Node resDoc = visit(ctx.doc()).get(0); 
        rpVisitor.setPNode(resDoc);
        return rpVisitor.visitDoubleSlash(ctx.rp());
    }
}
