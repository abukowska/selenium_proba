package com.tests.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public static void readExcel() {

		Workbook workbook = null;
		try {
			String filePath = "src//main//resources//Z1.xlsx";
			File file = new File(filePath);
			FileInputStream inputStream = new FileInputStream(file);

			if (filePath.endsWith(".xlsx")) {
				workbook = new XSSFWorkbook(inputStream);
			}
			inputStream.close();
		} catch (FileNotFoundException fnf) {
			fnf.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		Sheet sheet = workbook.getSheet("Arkusz1");

		Iterator<Row> rowIter = sheet.iterator();
		
		ArrayList<String> lista = new ArrayList<>();

		while (rowIter.hasNext()) {
			String k = null;
			Row row = rowIter.next();
			for (int j = 1; j < 4; j++) {
				if (row.getCell(1) == null) break;
				if (row.getCell(j) == null) continue;
				
				k = null;
				
				if (j == 3) {
					DataFormatter dataFormatter = new DataFormatter();
					String cellStringValue = dataFormatter.formatCellValue(row.getCell(j));
					k = cellStringValue;
					System.out.print(cellStringValue);
				} else {
					k = row.getCell(j).getStringCellValue();
					System.out.print(k + " | ");
				}
			}
			
			if (row.getCell(1) != null) {
				lista.add(k);
			}
			
			System.out.println();
		}
		
		for (String element : lista) {
			System.out.println("***" + element);
		}
	}

	public static void main(String[] args) {
		readExcel();
	}

}
