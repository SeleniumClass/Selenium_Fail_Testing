package com.usa.excelfactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Framework2 {
static String TestDataPath =  "./ApplTestData/Book1.xlsx";

private static FileInputStream fis;
private static XSSFWorkbook workbook;
private static XSSFSheet sheet;
private static XSSFRow row;

public static void loadExcel() throws IOException {
	
	System.out.println("......Loading Excel");
	fis= new FileInputStream(TestDataPath);

	workbook = new XSSFWorkbook(fis);
	sheet = workbook.getSheetAt(0);
	fis.close();

}




public static  Map<String, HashMap<String, String>> getDataMap() throws IOException {

		//Row HeaderRow = sheet.getRow(0);
		
		if(sheet==null) {
			loadExcel();
		}
		
		Map<String, HashMap<String, String>> superMap= new HashMap<String, HashMap<String, String>>();
		HashMap<String, String> mymap= new HashMap<String,String>();
		
		for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
		
			row=sheet.getRow(i);
			String keycell= row.getCell(0).getStringCellValue();
			
			int columnNumber= row.getLastCellNum();
			
			for (int j = 1; j < columnNumber; j++) {
				String value= row.getCell(j).getStringCellValue();
				mymap.put(keycell, value);
			}
			superMap.put("ExcelData", mymap);
			
		}
		return superMap;
		
		
}

public static String getValue(String key)throws IOException {
	
	Map<String, String> myvalue=getDataMap().get("ExcelData");
	String returnValue=myvalue.get(key);
	
	
	return returnValue;

}

public static void main(String[] args) throws Throwable {
	System.out.println(getValue("Case1"));
}
















}