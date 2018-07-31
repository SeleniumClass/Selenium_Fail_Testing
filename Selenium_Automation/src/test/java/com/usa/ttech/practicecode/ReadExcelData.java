package com.usa.ttech.practicecode;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.usa.excelfactory.ExcelFactory;

public class ReadExcelData {

	static XSSFWorkbook workbook;
	
	public static void main(String[] args) throws Throwable {
		
		//String path="./Test Data/Login Data.xlsx";
		//File src = new File(path);
		
			FileInputStream fis =new FileInputStream("./Test Cases/Login Test Cases.xlsx");
			
			//Apache POI
			
			XSSFWorkbook workbook= new XSSFWorkbook(fis);
		
	
		XSSFSheet sheet= workbook.getSheetAt(1);
		
		sheet.getLastRowNum();
		sheet.getPhysicalNumberOfRows();
		

		ArrayList<String> columnValue= new ArrayList<String>();
		
		int RowCount= sheet.getLastRowNum();
		
		System.out.println(RowCount);

		for(int rowindex=0;rowindex<RowCount;rowindex++) {
			Row row=sheet.getRow(rowindex);
			
			if (row!=null) {
				
				int columnNuber=0;
				
		for(int colmindex=0;colmindex<RowCount;colmindex++) {	
			
			if(colmindex==columnNuber) {
				Cell cell=row.getCell(colmindex);
				if(cell!=null) {
					
					DataFormatter df= new DataFormatter();
					columnValue.add(df.formatCellValue(cell));

	               
				}
				
			}
		}
	

}

		}
		System.out.println(columnValue);
	}
}