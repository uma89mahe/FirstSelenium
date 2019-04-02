package homePageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pdtDetailsObject extends BasePage{
	
	@FindBy (xpath="//*[@class='primary_block row']//*[@class='icon-twitter']")
	private WebElement twitter;
	

	@FindBy (xpath="//*[@class='primary_block row']//*[@class='icon-facebook']")
	private WebElement share;
	
	
	@FindBy (xpath="//*[@class='primary_block row']//*[@id='short_description_block']//p")
	private WebElement pdtdescription;
	
	public pdtDetailsObject() {
		PageFactory.initElements(driver, this);

	}
	
	public String getProductDescription() {
		return getTxt(pdtdescription);
		
	}
		
	public WebElement twitter() {
		return twitter;
	}
	
	public WebElement share() {
		return share;
	}
	
}
