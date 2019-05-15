package homePageTests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import homePageObjects.BasePage;
import homePageObjects.ExcelObjects;
import homePageObjects.HomePageObjects;
import homePageObjects.dressPageObjects;


public class Exceltests extends BasePage{
	
	BasePage bp;
	dressPageObjects dressPage;
	HomePageObjects homePage;
	ExcelObjects excel;
	
	public Exceltests() {
		bp = new BasePage();
		dressPage = new dressPageObjects();
		homePage = new HomePageObjects();
		excel = new ExcelObjects();
		
	}

	@Test
	public void excelReading() throws IOException {
		File location = new File("C://Users//u.dayalamurthy//Documents//Uma//Selenium//TestData.xlsx");
		FileInputStream reader = new FileInputStream(location);
		Workbook wb = new XSSFWorkbook(reader);
		Sheet sheet = wb.getSheet("Sheet1");

		for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row eachRow = sheet.getRow(i);
			for (int j = 0; j < eachRow.getPhysicalNumberOfCells(); j++) {
				String text = eachRow.getCell(1).getStringCellValue();
				System.out.println(text);
				if (text.equals("Nokia")) {
					System.out.println("Read successful");
				}
				/*
				 * Cell eachCell = eachRow.getCell(j); if(eachCell.getCellType()==0) {
				 * System.out.println(eachCell.getNumericCellValue()); } else
				 * if(eachCell.getCellType()==1) {
				 * System.out.println(eachCell.getStringCellValue()); }
				 * 
				 */

				if (sheet.getRow(8) == null) {
					sheet.createRow(8);
				}
				Cell currentCell = sheet.getRow(8).getCell(4);
				if (currentCell == null) {
					sheet.getRow(8).createCell(4).setCellValue("Successfull writing");
				} else {
					sheet.getRow(8).getCell(4).setCellValue("Successful Writing");
				}

				FileOutputStream out = new FileOutputStream("C://Users//u.dayalamurthy//Documents//Uma//TestData.xlsx");
				wb.write(out);
				out.close();

			}

		}
		
		
		

	}

}
