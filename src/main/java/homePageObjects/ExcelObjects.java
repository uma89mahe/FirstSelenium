package homePageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ExcelObjects {
	BasePage bp;
	dressPageObjects dressPage;
	HomePageObjects homePage;
	ExcelObjects excel;
	
	public ExcelObjects() {
		bp = new BasePage();
		dressPage = new dressPageObjects();
		homePage = new HomePageObjects();
		excel = new ExcelObjects();
	}
	
	
	@FindBy(className ="ui-grid-canvas")
	private List<WebElement> tablerows;
	
	
	public void reusableExcel() throws IOException
	{
		bp.read2RowColData("C://Users//u.dayalamurthy//Documents//Uma//Selenium//TestData.xlsx", "Sheet1");
			
	}
	
	
	public void reusableWebTable() {
		bp.read3ColDataWebTable(tablerows);
		
	}

}
