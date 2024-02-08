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
public class Engine extends XPathBaseVisitor<List<Node>> {
	private RpEngine rpVisitor = new RpEngine();

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
		List<Node> res = rpVisitor.visit(ctx.rp());
        return res;
    }

    @Override
    public List<Node> visitDoubleAP(XPathParser.DoubleAPContext ctx) {
        Node resDoc = visit(ctx.doc()).get(0); 
        rpVisitor.setPNode(resDoc);
        return rpVisitor.visitDoubleSlash(ctx.rp());
    }
}
