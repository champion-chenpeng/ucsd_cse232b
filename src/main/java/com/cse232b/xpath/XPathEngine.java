package com.cse232b.xpath;

import com.cse232b.XMLProcessor;

import com.cse232b.antlr4.XPathBaseVisitor;
import com.cse232b.antlr4.XPathParser;
import org.w3c.dom.Node;

import java.util.List;
import java.util.LinkedList;
import java.util.LinkedHashSet;

/**
 * @author chenpeng + zhaohanqing
 * @version 1.0
 * @date 1/29/24 3:39 PM
 * @description
 */
public class XPathEngine extends XPathBaseVisitor<List<Node>> {
    public RpEngine rpEngine = new RpEngine();

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
        rpEngine.setPNode(resDoc);
		// remove repeat
        LinkedHashSet<Node> res = new LinkedHashSet<>(rpEngine.visit(ctx.rp()));
		return new LinkedList<Node>(res);
    }

    @Override
    public List<Node> visitDoubleAP(XPathParser.DoubleAPContext ctx) {
        Node resDoc = visit(ctx.doc()).get(0); 
        rpEngine.setPNode(resDoc);
		// remove repeat
        LinkedHashSet<Node> res = new LinkedHashSet<>(rpEngine.visitDoubleSlash(ctx.rp()));
		return new LinkedList<Node>(res);
    }
}
