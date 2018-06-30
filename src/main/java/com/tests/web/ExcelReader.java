package com.tests.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public static void readExcel() {

		Workbook guru99Workbook = null;
		try {
			String filePath = "src//main//resources//Z1.xlsx";
		    File file = new File(filePath);
		    FileInputStream inputStream = new FileInputStream(file);
		    
		    String fileExtention = filePath.substring(filePath.indexOf("."));
		    
		    if (fileExtention.equals(".xlsx")) {
		    	guru99Workbook = new XSSFWorkbook(inputStream);
		    }
		    inputStream.close();
		    
		} catch (FileNotFoundException fnf) {
			fnf.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	    Sheet guru99Sheet = guru99Workbook.getSheet("Arkusz1");

	    Iterator<Row> rowIter = guru99Sheet.iterator();
	    
	    while(rowIter.hasNext()) {
	        Row row = rowIter.next();
	        for (int j = 1; j < 4; j++) {
	        	
	        	if(row.getCell(j) == null) continue;
	        	
	            if (j == 3) {
	            	DataFormatter dataFormatter = new DataFormatter();
	            	String cellStringValue = dataFormatter.formatCellValue(row.getCell(j));
	            	System.out.print(cellStringValue); 
	            } else {
	            	System.out.print(row.getCell(j).getStringCellValue() +" | ");
	            }
	        }
	        System.out.println();
	    }
	}
	
	public static void main(String[] args) {
		readExcel();
	}

}
