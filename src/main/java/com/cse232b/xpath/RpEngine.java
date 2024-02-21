package com.cse232b.xpath;

import com.cse232b.antlr4.XPathBaseVisitor;
import com.cse232b.antlr4.XPathParser;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chenpeng + zhaohanqing
 * @version 1.0
 * @date 1/29/24 3:39 PM
 * @description
 */
public class RpEngine extends XPathBaseVisitor<List<Node>> {
    private Node paramNode = null;

    // Attention: param nodes are set in a value-based way. Any callee can modify or return it exclusively.
    public void setPNode(Node origin){
        paramNode = origin;
    }

    // helper function to get all strict descendents of a node
    public LinkedList<Node> getDescendents(Node node) {
        LinkedList<Node> res = new LinkedList<>(); // result
        NodeList childrenNodes = node.getChildNodes();
        for (int i = 0; i < childrenNodes.getLength(); i++) {
            Node curtChild = childrenNodes.item(i);
            res.add(curtChild); // add a child
            res.addAll(getDescendents(curtChild));
        }
        return res;
    }

    public List<Node> visitDoubleSlash(XPathParser.RpContext ctx) {
        LinkedList<Node> des = new LinkedList<>();
        LinkedList<Node> res = new LinkedList<>();
        des.add(paramNode);
        des.addAll(getDescendents(paramNode));
        for (Node node : des) {
        	setPNode(node);
        	res.addAll(visit(ctx));
        }
        return res;
    }

    @Override
    public List<Node> visitTagRP(XPathParser.TagRPContext ctx) {
        LinkedList<Node> res = new LinkedList<>();
        String targetTagName = ctx.tagName().ID().getText();
        NodeList children = paramNode.getChildNodes();
        // iterate the children to find the nodes with the right tag
        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);
            if (child.getNodeType() == Node.ELEMENT_NODE && child.getNodeName().equals(targetTagName)){
                res.add(child);
            }
        }
        return res;
    }

    @Override
    public List<Node> visitChildrenRP(XPathParser.ChildrenRPContext ctx) {
        LinkedList<Node> res = new LinkedList<>();
        NodeList children = paramNode.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);
            res.add(child);
        }
        return res;
    }

    @Override
    public List<Node> visitSelfRP(XPathParser.SelfRPContext ctx) {
		LinkedList<Node> res = new LinkedList<>();
		res.add(paramNode);
        return res;
    }

    @Override
    public List<Node> visitParentRP(XPathParser.ParentRPContext ctx) {
        LinkedList<Node> res = new LinkedList<>();
        Node parentNode = paramNode.getParentNode();
		res.add(parentNode);
		// may need to check validation of xpath when query parent for root node
    	return res;
    }

    @Override
    public List<Node> visitTextRP(XPathParser.TextRPContext ctx) {
        LinkedList<Node> res = new LinkedList<>();
        NodeList children = paramNode.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);
            if (child.getNodeType() == Node.TEXT_NODE) {  // get all TextNode
                res.add(child);
            }
        }
        return res;
    }

    // not sure about this one
    @Override
    public List<Node> visitAttrRP(XPathParser.AttrRPContext ctx) {
        LinkedList<Node> res = new LinkedList<>();
        if(paramNode.getNodeType() == Node.ELEMENT_NODE && paramNode.getAttributes().getLength() > 0) {
        	String targetAttrName = ctx.attrName().ID().getText();
			res.add(paramNode.getAttributes().getNamedItem(targetAttrName));
		}
        return res;
    }

    @Override
    public List<Node> visitBracketRP(XPathParser.BracketRPContext ctx) {
        return visit(ctx.rp());
    }

    @Override
    public List<Node> visitSingleSlashRP(XPathParser.SingleSlashRPContext ctx) {
        List<Node> res1 = visit(ctx.rp(0));
        LinkedList<Node> res2 = new LinkedList<>();
		for (Node node : res1) {
        	setPNode(node);
			res2.addAll(visit(ctx.rp(1)));
		}
        return res2;
    }

    @Override
    public List<Node> visitDoubleSlashRP(XPathParser.DoubleSlashRPContext ctx) {
        List<Node> res1 = visit(ctx.rp(0));
		LinkedList<Node> res2 = new LinkedList<>();
		for (Node node : res1) {
        	setPNode(node);
        	res2.addAll(visitDoubleSlash(ctx.rp(1)));
		}
        return new LinkedList<>(res2);
    }

    @Override
    public List<Node> visitFilterRP(XPathParser.FilterRPContext ctx) {
        List<Node> res = visit(ctx.rp());
		FilterEngine filterVisitor = new FilterEngine();
        return res.stream().filter(node -> {
					filterVisitor.setPNode(node);
					return filterVisitor.visit(ctx.f());
				}).collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    public List<Node> visitCommaRP(XPathParser.CommaRPContext ctx) {
        Node currentCtxPNode = paramNode;
        setPNode(currentCtxPNode);
        List<Node> res1 = visit(ctx.rp(0));
        setPNode(currentCtxPNode);                 // reset paramNode to original state
        List<Node> res2 = visit(ctx.rp(1));
        res1.addAll(res2);
        return res1;
   }
}
