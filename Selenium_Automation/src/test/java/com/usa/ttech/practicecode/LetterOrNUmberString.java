package com.usa.ttech.practicecode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LetterOrNUmberString {

	public static void main(String[] args) {
		String input="sarower123";
		 String expression = "^[a-zA-Z]*$";
		   
		
	        Pattern pattern = Pattern.compile(expression);
	        Matcher matcher = pattern.matcher(input);
	        if(matcher.matches())
	        {
	              System.out.println("String contains only words");
	        }
	        else
	        {
	        	System.out.println("String contains  number also");
	        }
		    

	}

}
