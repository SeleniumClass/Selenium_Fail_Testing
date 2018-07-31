package com.usa.ttech.practicecode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {

	public static void main(String[] args) {
		String inputString = "sarower";
		String validPattern = "[a-zA-z_0-9]";
		Pattern pattern = Pattern.compile(validPattern);
		Matcher matcher = pattern.matcher(inputString);
		System.out.print(matcher.find()); // should print true or false if input contain any letter
	}

}
