package org.lee.prescription.web.test;

public class Test001 {
	
	private String param;
	

	public Test001() {
		System.out.println("Test001");
		setName("123");
	}

	
	public void setName(String name) {
		System.out.println("into super class setName method");
		this.param = name;
	}
	
	

}
