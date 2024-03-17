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
	private int NXPathCase = 0, NXQueryCase = 2;
    /**
	 * Test whether the pipeline runs well
     */
    @Test
	public void XPathQueryTest() {
		try {
			for (int i = 0; i < NXPathCase; i++) {
				System.out.println("Query xpath file %d".formatted(i));
				Main.main(new String[] { "src/test/resources/xquery/xpath/XPath%d.txt".formatted(i), "target/test-classes/XPath%d_result.xml".formatted(i) });
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Test
	public void XPathContentCompareTest() {
		try {
			for (int i = 0; i < NXPathCase; i++) {
				System.out.println("Compare xpath File %d".formatted(i));
				InputStream ResultInStream = new FileInputStream("target/test-classes/XPath%d_result.xml".formatted(i));
				InputStream RefInStream = new FileInputStream("src/test/resources/xpath/XPath%d_result_standard.xml".formatted(i));
				assert(IOUtils.contentEquals(RefInStream, ResultInStream));	
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
    @Test
	public void XQueryTest() {
		try {
			for (int i = 0; i < NXQueryCase; i++) {
				System.out.println("Query xquery file %d".formatted(i));
				Main.main(new String[] { "src/test/resources/xquery/XQuery%d.txt".formatted(i), "target/test-classes/XQuery%d_result.xml".formatted(i) });
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Test
	public void XQueryContentCompareTest() {
		try {
			for (int i = 0; i < NXQueryCase; i++) {
				System.out.println("Compare File %d".formatted(i));
				InputStream ResultInStream = new FileInputStream("target/test-classes/XQuery%d_result.xml".formatted(i));
				InputStream RefInStream = new FileInputStream("src/test/resources/xquery/XQuery%d_result_standard.xml".formatted(i));
				assert(IOUtils.contentEquals(RefInStream, ResultInStream));	
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
