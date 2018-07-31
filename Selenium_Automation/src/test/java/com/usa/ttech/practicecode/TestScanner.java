package com.usa.ttech.practicecode;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestScanner {

	public static void main(String[] args) {
		System.out.println("Enter input char");
	    Scanner sc = new Scanner(System.in);
	    String input = sc.next();
	    System.out.println("Output : ");
	    
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
	    
	    
	    
	/*    for (char alphabet = 'A'; alphabet <= 'Z'; alphabet++) {
	            if(!(input.toUpperCase().indexOf(alphabet) < 0)) 
	                System.out.print(alphabet + " ");

	}*/

}
}
