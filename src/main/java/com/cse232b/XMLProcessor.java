package com.cse232b;

import com.cse232b.antlr4.XPathLexer;
import com.cse232b.antlr4.XPathParser;
import com.cse232b.antlr4.XPathParser.ApContext;
import com.cse232b.antlr4.XPathParser.RpContext;
import com.cse232b.antlr4.XQueryLexer;
import com.cse232b.antlr4.XQueryParser;
import com.cse232b.antlr4.XQueryParser.XqContext;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
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

        if (!rawResult.isEmpty()) {
            // Import the first node from the rawResult list into the new Document
            Node importedNode = outputDoc.importNode(rawResult.get(0), true);

            // Append the importedNode directly to the outputDoc, making it the root element
            outputDoc.appendChild(importedNode);
        }

        return outputDoc;
    }

    public static void writeXMLDoc(Document outputDoc, OutputStream oStream) throws TransformerException {
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{https://xml.apache.org/xslt}indent-amount", "2");
        //transformer.setOutputProperty(OutputKeys.ENCODING, "US-ASCII");
        transformer.transform(new DOMSource(outputDoc),new StreamResult(oStream));
    }

    private static XPathParser parseXPath(InputStream xPathStream) {
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
        return parser;
    }
    public static ApContext parseXPathAp(InputStream xPathStream) {
        XPathParser parser = parseXPath(xPathStream);
        return parser.ap();
    }
    public static RpContext parseXPathRp(InputStream xPathStream) {
        XPathParser parser = parseXPath(xPathStream);
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
        assert parser != null;
        return parser.xq();
    }
}
