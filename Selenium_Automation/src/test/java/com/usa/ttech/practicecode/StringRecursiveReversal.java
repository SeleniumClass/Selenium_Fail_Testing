package com.usa.ttech.practicecode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class StringRecursiveReversal {
		
	 static ArrayList<String> level1 = null;
	 static ArrayList<String> rowList = null;
		public static void main(String[] args) throws Throwable {
			
			ArrayList<String> innerMembers = new ArrayList<String>();
		//	ArrayList<String> rowList = new ArrayList<String>();
		ArrayList<ArrayList<String>> parent_list = new ArrayList<ArrayList<String>>();
		String path="./DataExtract.xlsx";
		FileInputStream file= new FileInputStream(path);
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet= workbook.getSheetAt(0);

		int RowCount= sheet.getLastRowNum();
		System.out.println(RowCount);
		for(int i=0;i<RowCount;i++){
			//if(i==2) {
	        Row row = sheet.getRow(i);      
	        StringBuilder sb = new StringBuilder();

	        int lastColumn = row.getLastCellNum();
	        System.out.println(lastColumn);
	        for(int j=0; j<lastColumn;j++){
	            Cell cell = row.getCell(j);
	             switch (cell.getCellType()) {

	                 case Cell.CELL_TYPE_STRING:
	                     innerMembers.add(cell.getStringCellValue());
	                     sb.append(cell.getStringCellValue()+",");
	                   //  break;

	                 case Cell.CELL_TYPE_NUMERIC:
	                     cell.setCellType(Cell.CELL_TYPE_STRING);
	                     innerMembers.add(cell.getStringCellValue());
	                     sb.append(cell.getStringCellValue()+",");
	                   //  break;
	           //  }                              


	       System.out.println(innerMembers);
			rowList.addAll(innerMembers);
	        }
	       
			level1.add(sb.toString());
			System.out.println(level1);
	        parent_list.add(level1);

			}
		}
		System.out.println(parent_list);
		}
	}		
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		/*	
			int[] nums= {1,2,3,4,5,6,7,8,9,10};
		
		// Fill it with numbers using a for-loop
    	for (int i = 0; i < nums.length; i++) {
    	    nums[i] = i + 1;  // +1 since we want 1-100 and not 0-99

    	// Compute sum
    	int b = 0;
    	for (int n : nums)
    	    b += n;

}*/
	