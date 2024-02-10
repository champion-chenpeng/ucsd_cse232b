package com.cse232b;

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
            throw new IllegalArgumentException("Input list rawResult cannot be empty.");
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

}
