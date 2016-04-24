/**
 * 
 */
package org.lee.prescription.web.test;

import static org.junit.Assert.*;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	public void testName_03() throws Exception {
		int max = Math.max((int) (61/.75f) + 1, 16);
		System.out.println(max);
	}
	
	
	
//	@Test
	public void testName_02() throws Exception {
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0 ; i <5 ; i++){
			list.add(i);
		}
		list.add(2);
		list.add(2);
		list.add(4);
		Set<Integer> set = new HashSet<Integer>(list);
		
		
		boolean add = set.add(3);
		System.out.println(add);
		
		for (Integer integer : set) {
			System.out.println(integer);
		}
		
	}
	
	
	
	
	
//	@Test
	public void testName_01() throws Exception {
		String s = MessageFormat.format("aaaa{0}a{1}a", "b","c");
		System.out.println(s);
	}
	

}





























