package com.variable;

public class TestStringBuilder {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("Hello");
		sb.append(" World!");
		System.out.println(sb.toString()); //Hello World!

	}

}
