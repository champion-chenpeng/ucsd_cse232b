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
    /**
	 * Test whether the pipeline runs well
     */
    @Test
	public void SingleQueryTest() {
		try (
			InputStream testXPathInStream = AppTest.class.getClassLoader().getResourceAsStream("XPath0.txt");
			OutputStream testXPathOutStream = new FileOutputStream("XPath0_result.xml");
		) {
			List<Node> rawResult = XPathEvaluator.evaluateXPath(testXPathInStream);
			XMLProcessor.generateResultXMLThenOutput(rawResult, testXPathOutStream, true);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Test
	public void ContentCompareTest() {
		try (
			InputStream ResultInStream = new FileInputStream("XPath0_result.xml");
			InputStream RefInStream = new FileInputStream("XPath0_result_standard.xml");
		) {
			assert(IOUtils.contentEquals(RefInStream, ResultInStream));	
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
