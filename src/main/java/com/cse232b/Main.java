package com.cse232b;


import com.cse232b.xquery.XQueryEngine;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main
{

    public static void main( String[] args )
    {
        if(args.length != 2){
            System.out.printf("wrong args number: expect 2 received %d \n", args.length);
            System.out.println("usage java -jar CSE-232B-M1.jar one_xquery_query.txt result.xml");
        }
		List<Node> rawEvaluateRes = xQueryEvaluate(args[0]);
        if(rawEvaluateRes == null){
            System.err.println("XQuery evaluation failed. No result file generated.");
            return;
        }
        System.out.println("XQuery evaluation finished, writing result file...");
        writeResultToFile(rawEvaluateRes, args[1]);
    }

    private static List<Node> xQueryEvaluate(String xQueryFilePath) {
        List<Node> rawEvaluateRes = null;
        try(
            InputStream xQueryIStream = Files.newInputStream(Paths.get(xQueryFilePath))
        ) {
            rawEvaluateRes = evaluateXQuery(xQueryIStream);
        } catch (IOException e) {
            System.err.println("open xQuery file failed: " + e.getMessage());
        } catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		}
		return rawEvaluateRes;
    }

    private static List<Node> evaluateXQuery(InputStream xQueryStream) throws Exception {
        DocumentBuilderFactory docBldFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder bd = docBldFactory.newDocumentBuilder();
        XQueryEngine visitor = new XQueryEngine(bd.newDocument());
        return visitor.visit(XMLProcessor.parseXQuery(xQueryStream));
    }


    private static void writeResultToFile(List<Node> rawRes, String fileName) {
        try(
            OutputStream resultXMLOStream = Files.newOutputStream(Paths.get(fileName))
        ) {
            XMLProcessor.serialize(rawRes, resultXMLOStream);
        }  catch (IOException e) {
            System.err.println("open result file failed: " + e.getMessage());
        } catch (ParserConfigurationException | TransformerException e){
            System.err.println("generating XML or transforming failed:" + e.getMessage());
        }
        catch (Exception e){
            System.err.println("runtime exception while generating/writing result:" + e.getMessage());
        }
    }
}
