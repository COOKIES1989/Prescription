package org.lee.prescription.web.test;

public class Test002 {
	
	
	public static boolean foo (char c){
		System.out.println(c);
		return true;
	}
	
	public static void main(String[] args) {
		int count = 0;
		for(foo('A');count <2;foo('B')){
			count ++;
			foo('D');
		}
	}
	

}
