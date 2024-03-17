package com.cse232b;

import com.cse232b.JoinEditorVisitor;
import com.cse232b.antlr4.XQueryLexer;
import com.cse232b.antlr4.XQueryParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.*;

/**
 * @author Hanqing Zhao, Peng Chen
 * @version 1.0
 * @date 3/14/2024
 * @description
 */
public class XQueryEditor {
    static String rewriteToJoinXquery(String originFilePath, InputStream inputStreamToParse) {
        String res = exeJoinWrite(inputStreamToParse);
        if( JoinEditorVisitor.NO_CHANGE_MARK.equals(res)) {
            File oriFile = new File(originFilePath);
            return readToString(oriFile);
        }
        return res;
    }
    private static String readToString(File file) {
        long fileLength = file.length();
        byte[] fileContent = new byte[(int) fileLength];
        try {
            FileInputStream in = new FileInputStream(file);
            in.read(fileContent);
            in.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new String(fileContent);
    }

    static String exeJoinWrite(InputStream inputStream) {
        try {
            CharStream cs = CharStreams.fromStream(inputStream);
            XQueryLexer lexer = new XQueryLexer(cs);
            CommonTokenStream tks = new CommonTokenStream(lexer);
            XQueryParser parser = new XQueryParser(tks);
            parser.removeErrorListeners();
            JoinEditorVisitor visitor = new JoinEditorVisitor();
            String res = visitor.visit(parser.xq());
            return res;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
