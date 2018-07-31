package com.usa.excelfactory;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFactory {
	//static String excelPath="./DataExtract.xlsx";
	static XSSFWorkbook workbook;

	
public static String getCellData (int sheetIndex,int row,int column,String path){
	File src = new File(path);
	try {
		FileInputStream fis =new FileInputStream(src);
		
		 workbook= new XSSFWorkbook(fis);
	} catch (Exception e) {
		System.out.println("Exception is"+ e.getMessage());
	}
		String data=workbook.getSheetAt(sheetIndex).getRow(row).getCell(column).toString();
		return data;
	}
	


public static ArrayList<String> columnValue(int sheetIndex,int columnNumber,String path) throws Throwable
    {
		
		File src = new File(path);
		try {
			FileInputStream fis =new FileInputStream(src);
			workbook= new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("Exception is"+ e.getMessage());
		}
	
		XSSFSheet sheet= workbook.getSheetAt(sheetIndex);

		ArrayList<String> columnValue= new ArrayList<String>();
		
		int RowCount= sheet.getLastRowNum();

		for(int rowindex=0;rowindex<RowCount;rowindex++) {
			Row row=sheet.getRow(rowindex);
			if (row!=null) {
		for(int colmindex=0;colmindex<RowCount;colmindex++) {	
			if(colmindex==columnNumber) {
				Cell cell=row.getCell(colmindex);
				if(cell!=null) {
					
					DataFormatter df= new DataFormatter();
					columnValue.add(df.formatCellValue(cell));

	               
				}
				
			}
		}
		
	}
	}
	
	
		return columnValue;	
		
	}

public static ArrayList<String> extractExcelContentByColumnIndex(int sheetIndex,int rowNumber,String path)
    {
        ArrayList<String> columnData=null;
       

        try
        {
 FileInputStream fis=new FileInputStream(path);
            Workbook wb=WorkbookFactory.create(fis);
            Sheet sh=wb.getSheetAt(0);
            Iterator<Row> rowIterator=sh.iterator();
            columnData=new ArrayList<>();

            while(rowIterator.hasNext())
            {

                Row row=rowIterator.next();
                Iterator<Cell> cellIterator=row.cellIterator();
                while(cellIterator.hasNext())
                {
                    Cell cell=cellIterator.next();


    if((row.getRowNum()>=rowNumber) && (row.getRowNum()<=sh.getPhysicalNumberOfRows()))
    {
    //  if(cell.getColumnIndex()==1);// column under watch

        //{
    	DataFormatter df= new DataFormatter();
    	columnData.add(df.formatCellValue(cell));
          //  columnData.add(cell.getStringCellValue());
           // Collections.sort(columnData);            
       }
    }
}

            fis.close();

}
catch(Exception e)
{
e.printStackTrace();

}

   
System.err.println("Column Value = "+columnData);
return columnData;

}	

public static ArrayList<String> wholeExcelValue(int sheetIndex,String path) throws Throwable
{
		ArrayList<String> excelValue= new ArrayList<String>();
		 try {
			 FileInputStream ExcelFileToRead = new FileInputStream(path);
	       
			 
			 
			 XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);


	        XSSFSheet sheet = wb.getSheetAt(sheetIndex);
	        XSSFRow row; 
	        XSSFCell cell;

	        Iterator rows = sheet.rowIterator();

	        while (rows.hasNext())
	        {
	            row=(XSSFRow) rows.next();
	            Iterator cells = row.cellIterator();
	            while (cells.hasNext())
	            {
	                cell=(XSSFCell) cells.next();
	                System.out.print(cell+"||");
	                DataFormatter df= new DataFormatter();
	                excelValue.add(df.formatCellValue(cell));
	                
	            }
	        } 
		 }catch (Exception e) {

	            throw (e);

	        }
		
		
	            System.out.println();
				return excelValue;
  
		 }
	
}
