package com.cse232b.xquery;

import com.cse232b.XMLProcessor;
import com.cse232b.antlr4.XQueryLexer;
import com.cse232b.antlr4.XQueryParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/** move to main.java
 *
 * @author Hanqing Zhao, Peng Chen
 * @version 1.0
 * @date 03/14/2024
 * @description
 */
public class XQueryEvaluator {
    public static List<Node> evaluateXQuery(InputStream xQueryIStream) throws IOException, ParserConfigurationException {
        CharStream cs = CharStreams.fromStream(xQueryIStream);
        XQueryLexer lexer = new XQueryLexer(cs);
        CommonTokenStream tks = new CommonTokenStream(lexer);
        XQueryParser parser = new XQueryParser(tks);
        parser.removeErrorListeners();
        DocumentBuilder bd = XMLProcessor.docBldFactory.newDocumentBuilder();
        XQueryEngine visitor = new XQueryEngine(bd.newDocument());
        List<Node> res = visitor.visit(parser.xq());
        if (res == null) {
            throw new RuntimeException("visitor failed to get result.");
        }
        return res;
    }

    public static List<Node> evaluateXQueryWithoutExceptionPrintErr(InputStream xQueryIStream) {
        List<Node> res = null;
        try {
            res = evaluateXQuery(xQueryIStream);
        } catch (Exception e) {
            System.err.println("XQuery evaluation terminated with error: " + e.getMessage());
        }
        return res;
    }

}