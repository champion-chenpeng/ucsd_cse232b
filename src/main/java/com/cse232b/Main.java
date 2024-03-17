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
        final String EVAL_OPTION = "eval";
        final String EDIT_OPTION = "edit";
        if(args.length != 3){
            System.out.printf("wrong args number: expect 3 received %d \n", args.length);
            System.out.println("usage java -jar target/CSE-232B-M1 [eval | edit] [input] [output]");
        }
        switch (args[0]) {
            case EVAL_OPTION:
                List<Node> rawEvaluateRes = xQueryEvaluate(args[1]);
                if(rawEvaluateRes == null){
                    System.err.println("XQuery evaluation failed. No result file generated.");
                    return;
                }
                System.out.println("XQuery evaluation finished, writing result file...");
                writeResultToFile(rawEvaluateRes, args[2]);
                break;
            case EDIT_OPTION:
                editXQueryToJoin(args[1], args[2]);
                break;
            default:
                System.out.println("invalid option argument use [eval | edit]");
        }
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

    private static void editXQueryToJoin(String xQueryFilePath, String outputPath) {
        String reWriteRes = "";
        try (InputStream xQueryIStream = Files.newInputStream(Paths.get(xQueryFilePath))){
            reWriteRes = XQueryEditor.rewriteToJoinXquery(xQueryFilePath, xQueryIStream);
        }catch (IOException e) {
            System.err.println("open xQuery file failed: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("rewrite xquery failed : " + e.getMessage());
        }

        try (PrintWriter out = new PrintWriter(outputPath)) {
            out.println(reWriteRes);
        } catch (FileNotFoundException e) {
            System.err.println("rewrite to file not found!");
        }
    }
}
