package com.cse232b;

import com.cse232b.JoinEditorVisitor;
import com.cse232b.antlr4.XQueryLexer;
import com.cse232b.antlr4.XQueryParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.*;
import java.nio.file.Files;

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
        try {
            // Read all bytes from the file and convert to String
            return new String(Files.readAllBytes(file.toPath()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static String exeJoinWrite(InputStream inputStream) {
        try {
            JoinEditorVisitor visitor = new JoinEditorVisitor();
            return visitor.visit(XMLProcessor.parseXQuery(inputStream));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
