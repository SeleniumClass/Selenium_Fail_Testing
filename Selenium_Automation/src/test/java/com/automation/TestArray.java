package com.automation;

import java.util.ArrayList;

public class TestArray {

	public static void main(String[] args) {
		ArrayList<String> arrlistobj = new ArrayList<String>();
        arrlistobj.add("Alive is awesome");
        arrlistobj.add("Love yourself");
        arrlistobj.add("hi");
      System.out.println(arrlistobj+"First list value");
        arrlistobj.clear();
        System.out.println(arrlistobj+"Last list value");

	}

}
