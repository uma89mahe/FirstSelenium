package homePageTests;

import org.testng.annotations.Test;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class NewExcel {

	
	public void excelReading() throws IOException {
		File location = new File("C:\\Users\\u.dayalamurthy\\Documents\\Uma\\TestData.xlsx");
		FileInputStream reader = new FileInputStream(location);
		Workbook wb= new XSSFWorkbook(reader);
		Sheet sheet = wb.getSheet("Sheet2");
		
		for(int i=0;i<sheet.getPhysicalNumberOfRows();i++) {
			Row eachRow= sheet.getRow(i);
			for(int j=0;j<eachRow.getPhysicalNumberOfCells();j++) {
				Cell eachCell= eachRow.getCell(j);
				if(eachCell.getCellType()==0) {
					System.out.println(eachCell.getNumericCellValue());
					} else if (eachCell.getCellType()==1){
						System.out.println(eachCell.getStringCellValue());
					}
			}
		
		}
	
	
	if(sheet.getRow(8)==null) {
		sheet.createRow(8);
			}
	Cell currentCell = sheet.getRow(8).getCell(4);
	if(currentCell == null) {
		sheet.getRow(8).createCell(4).setCellValue("Successfull writing");
	}else {
		sheet.getRow(8).getCell(4).setCellValue("Successful Writing");
	}
	
	FileOutputStream out = new FileOutputStream ("C:\\\\Users\\\\u.dayalamurthy\\\\Documents\\\\Uma\\\\TestData.xlsx");
	wb.write(out);
	out.close();
	}

}
