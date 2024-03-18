package com.cse232b;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.Ignore;

import org.w3c.dom.Node;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	private final Map<String, Integer> nCase = Map.of(
			"xpath", 10,
			"xquery", 10,
			"rewrite", 4
	);

    /**
	 * Test whether the pipeline runs well
     */
	private void query(String type) {
		try {
			for (int i = 1; i <= nCase.get(type); i++) {
				System.out.println("Query " + type + " file %d".formatted(i));
				String inputFile = "src/test/resources/" + type + "/query/query%d.txt".formatted(i);
				String outputFile = "target/test-classes/" + type + "%d.xml".formatted(i);
				Main.main(new String[] {inputFile, outputFile});
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private void contentCompare(String type) {
		try {
			for (int i = 1; i <= nCase.get(type); i++) {
				System.out.println("Comparing " + type + " File %d".formatted(i));
				InputStream ResultInStream = new FileInputStream("target/test-classes/" + type + "%d.xml".formatted(i));
				InputStream RefInStream = new FileInputStream("src/test/resources/" + type + "/result/query%d.xml".formatted(i));
				assert(IOUtils.contentEquals(RefInStream, ResultInStream));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private void rewrite() {
		String type = "rewrite";
		try {
			for (int i = 1; i <= nCase.get(type); i++) {
				System.out.printf("Rewrite XQuery %d%n", i);
				String inputFile = "src/test/resources/" + type + "/query/query%d.txt".formatted(i);
				String outputFile = "target/test-classes/" + type + "%d.txt".formatted(i);
				Main.main(new String[] { "rewrite", inputFile, outputFile});
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private void joinQuery() {
		String type = "rewrite";
		try {
			for (int i = 1; i <= nCase.get(type); i++) {
				System.out.println("Query " + type + " file %d".formatted(i));
				String inputFile = "target/test-classes/" + type + "%d.txt".formatted(i);
				String outputFile = "target/test-classes/" + type + "%d.xml".formatted(i);
				Main.main(new String[] {"evaluate", inputFile, outputFile});
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	


		
    @Ignore
	public void XPathQueryTest() {
		query("xpath");
	}

	@Ignore
	public void XPathContentCompareTest() {
		contentCompare("xpath");
	}

	@Ignore
	public void XQueryQueryTest() {
		query("xquery");
	}

	@Ignore
	public void XQueryContentCompareTest() {
		contentCompare("xquery");
	}

    @Test
	public void XQueryReWriteTest() {
		// query("xquery");
		rewrite();
		joinQuery();
		contentCompare("rewrite");
	}
}
