package com.usa.excelfactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Framework {
static String TestDataPath = "./Test Data/Login Data.xlsx";
public static HashMap<String, HashMap<String, String>> hm1 = new HashMap<>();
static String s3;


public static void ReadTestData() throws IOException {

		FileInputStream file = new FileInputStream(TestDataPath);

		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Row HeaderRow = sheet.getRow(0);
		
		
		for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row currentRow = sheet.getRow(i);
			HashMap<String, String> currentHash = new HashMap<String, String>();
			for (int j = 0; j < currentRow.getPhysicalNumberOfCells(); j++) {

				Cell currentCell1 = currentRow.getCell(0);
				switch (currentCell1.getCellType()) {
				case Cell.CELL_TYPE_STRING:
					s3 = currentCell1.getStringCellValue();
					///System.out.println(s3);
					break;
				case Cell.CELL_TYPE_NUMERIC:
					s3 = String.valueOf(currentCell1.getNumericCellValue());
					///System.out.println(s3);
					break;
				}

				Cell currentCell = currentRow.getCell(j);
				switch (currentCell.getCellType()) {
				case Cell.CELL_TYPE_STRING:
					currentHash.put(HeaderRow.getCell(j).getStringCellValue(),
							currentCell.getStringCellValue());
					break;
				case Cell.CELL_TYPE_NUMERIC:
					currentHash.put(HeaderRow.getCell(j).getStringCellValue(),
							 String.valueOf(currentCell.getNumericCellValue()));
					break;
				}

			}
			
			hm1.put(s3, currentHash);
			//System.out.println(currentHash.get("Case1"));
			//System.out.println(Framework.hm1.get("Case1").get("Description"));
			
		}
}

public static void main(String[] args) throws Throwable {
	
	Framework.ReadTestData();
	//Set<String> keys = Framework.hm1.keySet();
	//System.out.println("All keys are: " + keys);
	System.out.println("First test case: " + Framework.hm1.get("Case_01").get("UserName"));
	System.out.println("First test case: " + Framework.hm1.get("Case_01").get("Password"));
	// To get all key: value
	////for(String key: keys){
	 ///   System.out.println(key + ": " + Framework.hm1.get(key));
	////}
	//System.out.println(Framework.hm1.get("Case").get("Description"));
	
}



}