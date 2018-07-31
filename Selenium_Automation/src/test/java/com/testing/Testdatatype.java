package com.testing;

import org.omg.CORBA.INTERNAL;

public class Testdatatype {

	public static void main(String[] args) {
	
	String salary ="5000";
	int mysalary=Integer.parseInt(salary);
	int tuansalary= mysalary/2;
	System.out.println(tuansalary);
	
	
	
	String a ="5000.66";
	double s =Double.parseDouble(a);
	double f= s/2;
	System.out.println(f);
	}


}
