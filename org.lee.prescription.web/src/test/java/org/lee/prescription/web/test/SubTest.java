package org.lee.prescription.web.test;


public class SubTest extends Test001 {
	
	
	private String param = "abc";

	public SubTest() {
		
		System.out.println("subclass SubTest");
	}


	@Override
	public void setName(String name) {
		super.setName(name);
		this.param = name;
		System.out.println("sub class setName==="+name);
	}

	public void printName (){
		System.out.println("printName method ====="+param);
	}
	
	
	
	
	
	
	

}
