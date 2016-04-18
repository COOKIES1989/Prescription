/**
 * 
 */
package org.lee.prescription.web.test;

import static org.junit.Assert.*;

import java.text.MessageFormat;

import org.junit.Test;

/**
 * @ClassName TestCase
 * @Description TODO
 * @Date 2015年9月6日 下午8:34:01
 * @author LIJW
 *
 */
public class TestCase {
	
	
	@Test
	public void testName_01() throws Exception {
		String s = MessageFormat.format("aaaa{0}a{1}a", "b","c");
		System.out.println(s);
	}
	

}
