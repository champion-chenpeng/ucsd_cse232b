package com.cse232b;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import org.w3c.dom.Node;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	private int NXPathCase = 10, NXQueryCase = 10;
    /**
	 * Test whether the pipeline runs well
     */
	private void query(String type) {
		try {
			for (int i = 1; i <= NXPathCase; i++) {
				System.out.println("Query " + type + " file %d".formatted(i));
				Main.main(new String[] { "src/test/resources/" + type + "/query/query%d.txt".formatted(i), "target/test-classes/" + type + "%d.xml".formatted(i) });
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private void contentCompare(String type) {
		try {
			for (int i = 1; i <= NXPathCase; i++) {
				System.out.println("Comparing " + type + " File %d".formatted(i));
				InputStream ResultInStream = new FileInputStream("target/test-classes/" + type + "%d.xml".formatted(i));
				InputStream RefInStream = new FileInputStream("src/test/resources/" + type + "/result/query%d.xml".formatted(i));
				assert(IOUtils.contentEquals(RefInStream, ResultInStream));	
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
		
    @Test
	public void XPathQueryTest() {
		query("xpath");
	}

	@Test
	public void XPathContentCompareTest() {
		contentCompare("xpath");
	}
    @Test
	public void XQueryTest() {
		query("xquery");
	}

	@Test
	public void XQueryContentCompareTest() {
		contentCompare("xquery");
	}
}
