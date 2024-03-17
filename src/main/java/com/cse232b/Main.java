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
        if(args.length != 2){
            System.out.printf("wrong args number: expect 2 received %d \n", args.length);
            System.out.println("usage java -jar CSE-232B-M1.jar one_xquery_query.txt result.xml");
            System.out.println("usage java -jar [eval | edit] [filename]");
        }
        switch (args[0]) {
            case EVAL_OPTION:
                List<Node> rawEvaluateRes = xQueryEvaluate(args[0]);
                if(rawEvaluateRes == null){
                    System.err.println("XQuery evaluation failed. No result file generated.");
                    return;
                }
                System.out.println("XQuery evaluation finished, writing result file...");
                writeResultToFile(rawEvaluateRes, args[1]);
                break;
            case EDIT_OPTION:
                editXQueryToJoin(args[1]);
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

    private static void editXQueryToJoin(String xQueryFilePath) {
        String reWriteRes = "";
        try (InputStream xQueryIStream = new FileInputStream(xQueryFilePath)){
            reWriteRes = XQueryEditor.rewriteToJoinXquery(xQueryFilePath, xQueryIStream);
        }catch (IOException e) {
            System.err.println("open xQuery file failed: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("rewrite xquery failed : " + e.getMessage());
        }
        File file =new File("rewrite-" + xQueryFilePath);

        //if file doesnt exists, then create it
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

        //true = append file
        try (            FileWriter fileWriter = new FileWriter(file.getName());
                         BufferedWriter bufferWriter = new BufferedWriter(fileWriter)){
            bufferWriter.write(reWriteRes);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
