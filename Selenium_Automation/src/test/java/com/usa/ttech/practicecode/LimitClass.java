package com.usa.ttech.practicecode;

public class LimitClass {

    private static LimitClass limInstance;
    public static int objCount=0;

    private LimitClass(){
    	System.out.println("Singleton(): Private constructor invoked");
        objCount++;
    }

    public static synchronized LimitClass getLimInstance(){
    	
        if(objCount<1 ){
            limInstance = new LimitClass();
            
        }
        else {
        	limInstance = null;
        }
        return limInstance;
    }
}