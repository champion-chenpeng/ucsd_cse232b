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
	private int Ncase = 6;
    /**
	 * Test whether the pipeline runs well
     */
    @Test
	public void SingleQueryTest() {
		try {
			for (int i = 0; i < Ncase; i++) {
				Main.main(new String[] { "src/test/resources/XPath%d.txt".formatted(i), "target/test-classes/XPath%d_result.xml".formatted(i) });
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Test
	public void ContentCompareTest() {
		try {
			for (int i = 0; i < Ncase; i++) {
				System.out.println("Compare File %d".formatted(i));
				InputStream ResultInStream = new FileInputStream("target/test-classes/XPath%d_result.xml".formatted(i));
				InputStream RefInStream = new FileInputStream("src/test/resources/XPath%d_result_standard.xml".formatted(i));
				assert(IOUtils.contentEquals(RefInStream, ResultInStream));	
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
