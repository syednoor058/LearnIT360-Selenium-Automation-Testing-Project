package com.learnit360.utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

	public static FileInputStream fIStream;
	public static XSSFWorkbook workBook;
	public static XSSFSheet excelSheet;
	public static XSSFCell cell;
	public static XSSFRow row;
	
	
	public static int getRowCount (String fileName, String sheetName) {
		try {
			fIStream = new FileInputStream(fileName);
			workBook = new XSSFWorkbook(fIStream);
			excelSheet = workBook.getSheet(sheetName);
			int totalRows = excelSheet.getLastRowNum() + 1;
			workBook.close();
			return totalRows;
			}
		catch (Exception e){
			System.out.println("Error ocured at the time of counting rows: " + e.getMessage());
			return 0;
		}		
	}
	
	public static int getColumnCount (String fileName, String sheetName) {
		try {
			fIStream = new FileInputStream(fileName);
			workBook = new XSSFWorkbook(fIStream);
			excelSheet = workBook.getSheet(sheetName);
			int totalColumns = excelSheet.getRow(0).getLastCellNum();
			workBook.close();
			return totalColumns;
			}
		catch (Exception e){
			System.out.println("Error ocured at the time of counting columns: " + e.getMessage());
			return 0;
		}		
	}
	
	public static String getCellValue (String fileName, String sheetName, int rowNum, int colNum) {
		try {
			fIStream = new FileInputStream(fileName);
			workBook = new XSSFWorkbook(fIStream);
			excelSheet = workBook.getSheet(sheetName);
			cell = excelSheet.getRow(rowNum).getCell(colNum);
			workBook.close();
			return cell.getStringCellValue();
		}
		catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public static int getNumericCellValue (String fileName, String sheetName, int rowNum, int colNum) {
		try {
			fIStream = new FileInputStream(fileName);
			workBook = new XSSFWorkbook(fIStream);
			excelSheet = workBook.getSheet(sheetName);
			cell = excelSheet.getRow(rowNum).getCell(colNum);
			workBook.close();
			return (int) cell.getNumericCellValue();
		}
		catch (Exception e) {
			return 0;
		}
	}
	
	
	public String getStringData(int sheetIndex,int row,int column)
	{
		return workBook.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
	}
	
	public String getStringData(String sheetName,int row,int column)
	{
		return workBook.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
	}
	
	public double getNumericData(String sheetName,int row,int column)
	{
		return workBook.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
	}
}
