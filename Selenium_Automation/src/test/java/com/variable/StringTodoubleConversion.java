package com.variable;

public class StringTodoubleConversion {

	public static void main(String[] args) {
		String salary = "5000.56";
		//String halfsalry= salary/2;
		double salarynumber = Double.parseDouble(salary);
		System.out.println(salarynumber);
		double halfsalary = salarynumber / 2;
		System.out.println(halfsalary);

	}

}
