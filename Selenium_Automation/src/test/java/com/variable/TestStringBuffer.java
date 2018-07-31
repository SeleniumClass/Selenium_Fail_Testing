package com.variable;

public class TestStringBuffer {
	
	public static void main(String[] args) {
		
	
	StringBuffer sb = new StringBuffer("Hello");
	System.out.println(sb);
	//sb = new StringBuffer("World!");
	sb.append(" World!");
	System.out.println(sb); 

}
}