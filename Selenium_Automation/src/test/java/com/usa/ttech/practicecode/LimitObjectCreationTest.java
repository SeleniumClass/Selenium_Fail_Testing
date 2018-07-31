package com.usa.ttech.practicecode;

public class LimitObjectCreationTest {

    public static void main(String[] args) {

    	LimitClass obj1= LimitClass.getLimInstance();
        LimitClass obj2 = LimitClass.getLimInstance();
        LimitClass obj3 = LimitClass.getLimInstance();
        LimitClass obj4 = LimitClass.getLimInstance();
        LimitClass obj5 = LimitClass.getLimInstance();
        LimitClass obj6 = LimitClass.getLimInstance();

        System.out.println(obj1);
        System.out.println(obj2);

        System.out.println(obj3);
        System.out.println(obj4);
        System.out.println(obj5);
        System.out.println(obj6);
      }
}
