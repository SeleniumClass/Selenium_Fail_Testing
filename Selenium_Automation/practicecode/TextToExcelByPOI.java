package com.usa.ttech.practicecode;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class TextToExcelByPOI {

	
		 @SuppressWarnings("deprecation")
		    public static void main(String args[]) throws IOException {
		        ArrayList<ArrayList<String>> allRowAndColData = null;
		        ArrayList<String> oneRowData = null;
		        String fName = "C:\\Users\\sarow\\Desktop\\TTech Teaching\\text file.txt";
		        String currentLine;
		        FileInputStream fis = new FileInputStream(fName);
		        DataInputStream myInput = new DataInputStream(fis);
		        int i = 0;
		        allRowAndColData = new ArrayList<ArrayList<String>>();
		        while ((currentLine = myInput.readLine()) != null) {
		            oneRowData = new ArrayList<String>();
		            String oneRowArray[] = currentLine.split(";");
		            for (int j = 0; j < oneRowArray.length; j++) {
		                oneRowData.add(oneRowArray[j]);
		            }
		            allRowAndColData.add(oneRowData);
		            System.out.println();
		            i++;
		        }

		     try {
		         HSSFWorkbook workBook = new HSSFWorkbook();
		         HSSFSheet sheet = workBook.createSheet("sheet1");
		         for (int i1 = 0; i1 < allRowAndColData.size(); i1++) {
		           ArrayList<?> ardata = (ArrayList<?>) allRowAndColData.get(i1);
		           HSSFRow row = sheet.createRow((short) 0 + i1);
		           for (int k = 0; k < ardata.size(); k++) {
		                System.out.print(ardata.get(k));
		                HSSFCell cell = row.createCell((short) k);
		                cell.setCellValue(ardata.get(k).toString());
		           }
		           System.out.println();
		         }
		       FileOutputStream fileOutputStream =  new FileOutputStream("C:\\Users\\sarow\\eclipse-workspace\\Selenium_Automation_Student\\POI_text.xls");
		       workBook.write(fileOutputStream);
		       fileOutputStream.close();
		    } catch (Exception ex) {
		   }
		 }
		}

	


