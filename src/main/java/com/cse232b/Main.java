package com.cse232b;


import com.cse232b.rewrite.RewriterEngine;
import com.cse232b.xquery.XQueryEngine;
import org.w3c.dom.Node;

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
        final String EVALUATE_OPTION = "evaluate", REWRITE_OPTION = "rewrite";
        if(args.length != 3){
            System.out.printf("wrong args number: expect 3 received %d \n", args.length);
            System.out.println("usage java -jar target/CSE-232B-M1 [evaluate | rewrite] [input] [output]");
        }
        switch (args[0]) {
            case EVALUATE_OPTION:
                writeResultToFile(xQueryEvaluate(args[1]), args[2]);
                break;
            case REWRITE_OPTION:
                writeResultToFile(rewriteXquery(args[1]), args[2]);
                break;
            default:
                System.out.println("invalid option argument use [evaluate | rewrite]");
        }
    }

    private static List<Node> xQueryEvaluate(String xQueryFilePath) {
        try(
            InputStream xQueryStream = Files.newInputStream(Paths.get(xQueryFilePath))
        ) {
            XQueryEngine visitor = new XQueryEngine(DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument());
            return visitor.visit(IOProcessor.parseXQuery(xQueryStream));
        } catch (IOException e) {
            System.err.println("open xQuery file failed: " + e.getMessage());
        } catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		}
		return null;
    }
    
    private static String rewriteXquery(String originFilePath) {
        try (InputStream xQueryIStream = Files.newInputStream(Paths.get(originFilePath))) {
            RewriterEngine visitor = new RewriterEngine();
            String res = visitor.visit(IOProcessor.parseXQuery(xQueryIStream));
            if( RewriterEngine.NO_CHANGE_MARK.equals(res)) {
                File oriFile = new File(originFilePath);
                res = new String(Files.readAllBytes(oriFile.toPath()));
            }
            return res;
        } catch (IOException e) {
            System.err.println("open xQuery file failed: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private static void writeResultToFile(List<Node> rawRes, String fileName) {
        try(
            OutputStream resultXMLOStream = Files.newOutputStream(Paths.get(fileName))
        ) {
            IOProcessor.serializeNodesToXML(rawRes, resultXMLOStream);
        }  catch (IOException e) {
            System.err.println("open result file failed: " + e.getMessage());
        } catch (ParserConfigurationException | TransformerException e){
            System.err.println("generating XML or transforming failed:" + e.getMessage());
        }
        catch (Exception e){
            System.err.println("runtime exception while generating/writing result:" + e.getMessage());
        }
    }

    private static void writeResultToFile(String reWriteRes, String fileName) {
        try (PrintWriter out = new PrintWriter(fileName)) {
            out.println(reWriteRes);
        } catch (FileNotFoundException e) {
            System.err.println("rewrite to file not found!");
        }
    }
}
