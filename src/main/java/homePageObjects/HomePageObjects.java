package homePageObjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePageObjects extends BasePage {

	@FindBy(xpath = "//*[@id='block_top_menu']/ul/li[1]/a")
	private WebElement women;

	@FindBy(xpath = "//*[@id='block_top_menu']/ul/li[2]/a")
	private WebElement dresses;

	@FindBy(xpath = "//*[@id='block_top_menu']/ul/li[3]/a")
	private WebElement tshirts;

	@FindBy(xpath = "//*[@id='categories_block_left']/h2")
	private WebElement pageHeader;

	@FindBy(xpath = "//*[@class='row']//*[@id='layered_block_left']/p")
	private WebElement tshirtHeader;

	@FindBy(xpath = "//*[@id='newsletter_block_left']//input[@id='newsletter-input']")
	private WebElement newsletter;

	@FindBy(xpath = "//*[@id='columns']//p[@class='alert alert-success']")
	private WebElement subalert;

	@FindBy(xpath = "//*[@class='block_content']//button[@name='submitNewsletter']")
	private WebElement newsbutton;

	@FindBy(xpath = "//p[@class='alert alert-danger']")
	private WebElement danger;

	@FindBys(@FindBy(xpath = "//*[@id='homefeatured']//*[@class='product-container']"))
	private List<WebElement> allProducts;

	@FindBys(@FindBy(xpath = "//*[@id='homefeatured']//*[@class='right-block']//a/span[text()='Add to cart']"))
	private List<WebElement> AddtoCart;

	public HomePageObjects() {
		PageFactory.initElements(driver, this);
	}

	public WebElement women() {
		return women;
	}

	public WebElement dresses() {
		return dresses;
	}

	public WebElement tshirts() {
		return tshirts;
	}

	public String getPageHeader() {
		return getTxt(pageHeader);

	}

	public void clickWomenTab() {
		women.click();
	}

	public String getTshirtHeader() {
		return getTxt(tshirtHeader);
	}

	public void clickDressTab() {
		dresses.click();
	}

	public void clickTshirtTab() {
		tshirts.click();
	}

	public void newsletterSend() {
		pageScroll(newsletter);
		newsletter.sendKeys("umamaheswari@gmail.com");
	}

	public void clickNewsbutton() {
		newsbutton.click();
	}

	public void clickNewsletter() {
		newsletter.click();
	}

	public String getNewsAlert() {
		return getTxt(subalert);
	}

	public String getNewsdanger() {
		return getTxt(danger);
	}

	public void homeUrl() {
		driver.navigate().to("http://automationpractice.com/index.php");
	}

	public void mouseHover() {
		Actions ac = new Actions(driver);
		for (int i = 0; i < allProducts.size(); i++) {
			ac.moveToElement(allProducts.get(i)).build().perform();
			if (AddtoCart.get(i).isDisplayed()) {
				System.out.println("Add to Cart Displayed");
			}
		}
	}

	public void excelRead() throws IOException {
		File location = new File("C:\\Users\\u.dayalamurthy\\Documents\\Uma\\TestData.xlsx");
		FileInputStream reader = new FileInputStream(location);
		Workbook wb = new XSSFWorkbook(reader);
		Sheet sheet = wb.getSheet("Sheet1");

		/*
		 * for(int i=0;i<sheet.getPhysicalNumberOfRows();i++) { Row eachRow=
		 * sheet.getRow(i); for(int j=0;j<eachRow.getPhysicalNumberOfCells();j++) { Cell
		 * eachCell= eachRow.getCell(j);
		 * 
		 * 
		 * 
		 */
	}

	public void webtableReading() {

		List<WebElement> tablerows = driver.findElements(By.className("ui-grid-canvas"));

		for (int i = 0; i < tablerows.size(); i++) {
			WebElement row = tablerows.get(i);

			List<WebElement> cells = row.findElements(By.xpath(".//div"));

			for (int j = 0; j < cells.size(); j++) {
				String text = cells.get(j).getText();
				System.out.println(text);
			}
		}
	}

	public void toolsQAWebtable() {
		driver.get("https://www.toolsqa.com/automation-practice-table/");
		List<WebElement> table = driver.findElements(By.xpath("//table[@class = 'tsc_table_s13']//tr"));
		for (int i = 0; i < table.size(); i++) {
			WebElement row = table.get(i);

			List<WebElement> cells = row.findElements(By.xpath(".//td"));
			for (int j = 0; j < cells.size(); j++) {
				String text = cells.get(j).getText();
				// click the link in same row
				if (text.equals("Mecca")) {
					row.findElement(By.xpath("//td[6]")).click();
				}
				// printing cell address
				if (text.equals("Taipei")) {
					String rowindex = row.findElement(By.xpath(".//th")).getText();

					System.out.println(rowindex + " " + (j + 1));
				}
			}
		
			// count of string
			List<WebElement> count = driver.findElements(By.xpath("//table[@class = 'tsc_table_s13']//tr//td[text()= '2010']"));
			System.out.println("The size is: "+count.size());

		}

	}

}