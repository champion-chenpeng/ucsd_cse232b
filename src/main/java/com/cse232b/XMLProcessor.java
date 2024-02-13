package com.cse232b;

import com.cse232b.antlr4.XQueryLexer;
import com.cse232b.antlr4.XQueryParser;
import com.cse232b.antlr4.XQueryParser.XqContext;
import com.cse232b.antlr4.XPathLexer;
import com.cse232b.antlr4.XPathParser;
import com.cse232b.antlr4.XPathParser.ApContext;
import com.cse232b.antlr4.XPathParser.RpContext;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;


import org.w3c.dom.*;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chenpeng + zhaohanqing
 * @version 1.0
 * @date 1/29/24 3:39 PM
 * @description
 */
public class XMLProcessor {
    public static final String DEFAULT_DTD_FILE_NAME = "play.dtd";
    static DocumentBuilderFactory docBldFactory = DocumentBuilderFactory.newInstance();
    static TransformerFactory transformerFactory = TransformerFactory.newInstance();


    public static List<Node> parse(String xmlFileNameInXPath)
            throws ParserConfigurationException, IOException, SAXException {
        try (InputStream dataFileStream = XMLProcessor.class.getClassLoader().getResourceAsStream(xmlFileNameInXPath);
             InputStream dtdFileStream = XMLProcessor.class.getClassLoader().getResourceAsStream(DEFAULT_DTD_FILE_NAME)) {
            return loadXMLDataFileToDomNodes(dataFileStream, dtdFileStream);
        }
    }

    public static void serialize(List<Node> rawResult, OutputStream oStream)
            throws ParserConfigurationException, TransformerException {
        Document doc = generateResultXML(rawResult);
        writeXMLDoc(doc, oStream);
    }


    private static List<Node> loadXMLDataFileToDomNodes(InputStream xmlDataFileStream,InputStream dtdStream)
            throws ParserConfigurationException, IOException, SAXException {
        List<Node> res = new LinkedList<>();
        //docBldFactory.setIgnoringElementContentWhitespace(true);
        DocumentBuilder bd = docBldFactory.newDocumentBuilder();
        bd.setEntityResolver((publicId, systemId) ->{
            if (systemId.contains(".dtd")) {
                return new InputSource(dtdStream);
            } else {
                return null;
            }
        });
        Document d = bd.parse(xmlDataFileStream);
        d.getDocumentElement().normalize();
        res.add(d);
        return res;
    }


    public static Document generateResultXML(List<Node> rawResult) throws ParserConfigurationException {
        DocumentBuilder bd = docBldFactory.newDocumentBuilder();
        Document outputDoc = bd.newDocument();
        if (rawResult.isEmpty()) {
			return outputDoc;
        }

        Element resultEle = outputDoc.createElement("RESULT");
        outputDoc.appendChild(resultEle);

        for (Node old : rawResult) {
            try {
                Node newNode = outputDoc.importNode(old, true);
                resultEle.appendChild(newNode);
            } catch (DOMException e) {
                if (e.code != DOMException.NOT_SUPPORTED_ERR) {
                    throw e;
                }
                // Handle the case when the node cannot be imported (optional).
            }
        }

        return outputDoc;
    }

    public static void writeXMLDoc(Document outputDoc, OutputStream oStream) throws TransformerException {
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{https://xml.apache.org/xslt}indent-amount", "2");
        transformer.transform(new DOMSource(outputDoc),new StreamResult(oStream));
    }

    public static ApContext parseXPathAp(InputStream xPathStream) {
		XPathParser parser = null;
		try {
        CharStream cs = CharStreams.fromStream(xPathStream);
        XPathLexer lexer = new XPathLexer(cs);
        CommonTokenStream tks = new CommonTokenStream(lexer);
        parser = new XPathParser(tks);
        parser.removeErrorListeners();
		} catch (Exception e) {
            System.err.println("XPath parse terminated with error: " + e.getMessage());
		}
		return parser.ap();
    }

    public static RpContext parseXPathRp(InputStream xPathStream) {
		XPathParser parser = null;
		try {
        CharStream cs = CharStreams.fromStream(xPathStream);
        XPathLexer lexer = new XPathLexer(cs);
        CommonTokenStream tks = new CommonTokenStream(lexer);
        parser = new XPathParser(tks);
        parser.removeErrorListeners();
		} catch (Exception e) {
            System.err.println("XPath parse terminated with error: " + e.getMessage());
		}
		return parser.rp();
    }

    public static XqContext parseXQuery(InputStream xQueryStream) {
		XQueryParser parser = null;
		try {
        CharStream cs = CharStreams.fromStream(xQueryStream);
        XQueryLexer lexer = new XQueryLexer(cs);
        CommonTokenStream tks = new CommonTokenStream(lexer);
        parser = new XQueryParser(tks);
        parser.removeErrorListeners();
		} catch (Exception e) {
            System.err.println("XQuery parse terminated with error: " + e.getMessage());
		}
		return parser.xq();
    }
}
