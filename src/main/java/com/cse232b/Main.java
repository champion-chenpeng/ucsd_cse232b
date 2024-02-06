package com.cse232b;

import com.cse232b.antlr4.XPathLexer;
import com.cse232b.antlr4.XPathParser;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import org.w3c.dom.Node;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import java.io.*;
import java.util.List;

public class Main
{

    public static void main( String[] args )
    {
        if(args.length != 2){
            System.out.printf("wrong args number: expect 2 received %d \n", args.length);
            System.out.println("usage java -jar CSE-232B-M1.jar one_xpath_query.txt result.xml");
        }
		List<Node> rawEvaluateRes = xPathEvaluate(args[0]);
        if( rawEvaluateRes == null ){
            System.err.println("XPath evaluation failed. No result file generated.");
            return;
        }
        System.out.println("XPath evaluation finished, writing result file...");
        writeResultToFile(rawEvaluateRes, args[1], true);
    }

    private static List<Node> xPathEvaluate(String xPathFilePath) {
        List<Node> rawEvaluateRes = null;
        try(
                InputStream xPathIStream = new FileInputStream(xPathFilePath)
        ) {
             rawEvaluateRes = evaluateXPath(xPathIStream);
        } catch (IOException e) {
            System.err.println("open xPath file failed: " + e.getMessage());
        } catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		}
		return rawEvaluateRes;
    }

    private static List<Node> evaluateXPath(InputStream xPathStream) throws Exception {
        CharStream cs = CharStreams.fromStream(xPathStream);
        XPathLexer lexer = new XPathLexer(cs);
        CommonTokenStream tks = new CommonTokenStream(lexer);
        XPathParser parser = new XPathParser(tks);
        parser.removeErrorListeners();
        Engine visitor = new Engine();
        List<Node> res = visitor.visit(parser.ap());
        return res;
    }


    private static void writeResultToFile(List<Node> rawRes, String fileName, boolean addResEle) {
        try(
                OutputStream resultXMLOStream = new FileOutputStream(fileName)
        ) {
            XMLProcessor.serialize(rawRes, resultXMLOStream, addResEle);
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
