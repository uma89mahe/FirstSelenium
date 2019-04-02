package homePageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class dressPageObjects extends BasePage {

	@FindBy(xpath = "//*[@class='block_content']//div[@class='layered_filter']//a[text()='S']")
	private WebElement size_s;

	@FindBy(xpath = "//*[@class='block_content']//div[@class='layered_filter']//a[text()='S']/span")
	private WebElement size_scount;

	@FindBy(xpath = "//*[@class='block_content']//div/div[2][@class='layered_filter']//a[text()='M']")
	private WebElement size_m;

	@FindBy(xpath = "//*[@class='block_content']//div/div[2][@class='layered_filter']//a[text()='M']/span")
	private WebElement size_mcount;

	@FindBy(xpath = "//*[@class='block_content']//div/div[2][@class='layered_filter']//a[text()='L']")
	private WebElement size_l;

	@FindBy(xpath = "//*[@class='block_content']//div/div[2][@class='layered_filter']//a[text()='L']/span")
	private WebElement size_lcount;

	@FindBy(xpath = "//*[@class='heading-counter']")
	private WebElement txtProductHeader;

	@FindBy(xpath = "//*[@class='product_list grid row']/li[1]//div[@class='right-block']//div[@class='button-container']/a/span")
	private WebElement addcart;

	@FindBy(xpath = "//*[@class='clearfix']/div//h2/i")
	private WebElement cartpopup;

	@FindBy(xpath = "//*[@class='clearfix']/div/span")
	private WebElement closepopup;

	@FindBy(xpath = "//*[@id='center_column']//*[@class='product-container']//div[3]")
	private WebElement product;

	@FindBy(xpath = "//*[@class='clearfix']/div/div/img")
	private WebElement pdtimg;

	@FindBy(id = "selectProductSort")
	private WebElement dropdown;

	@FindBy(xpath = "//*[@id='ul_layered_id_attribute_group_1']//*[@class='checker hover']")
	private WebElement checkboxSmall;

	@FindBy(xpath = "//*[@id='ul_layered_id_attribute_group_2']//*[@class='checker hover']")
	private WebElement checkboxMedium;

	@FindBy(xpath = "//*[@id='ul_layered_id_attribute_group_3']//*[@class='checker hover']")
	private WebElement checkboxlarge;

	@FindBys(@FindBy(xpath = "//*[@class='product_list grid row']/li"))
	private List<WebElement> productcount;

	@FindBy(xpath = "//*[@class='shopping_cart']/a/span")
	private WebElement cart;

	@FindBy(xpath = "//*[@class='product-container']//div[@class='right-block']//span[@class='price product-price']")
	private List<WebElement> pdtPrice;
	
	@FindBy(className="icon-th-list")
	private WebElement listview;
	
	@FindBy(className="discount")
	private List<WebElement> discount;
	
	@FindBys(@FindBy(xpath="//*[@class='content_price']//*[@class='old-price product-price']"))
	private List<WebElement> oldprice;
	
	@FindBys(@FindBy(xpath = "//*[@id='homefeatured']//*[@class='product-container']"))
	private List<WebElement> pdtList;

	public dressPageObjects() {
		PageFactory.initElements(driver, this);
	}

	public WebElement sizeSmall() {
		return size_s;

	}

	public WebElement sizeMedium() {
		return size_m;

	}

	public WebElement sizeLarge() {
		return size_l;

	}

	public int getProductNumberFromHeader() {

		/*
		 * String text = txtProductHeader.getText();
		 *  String [] arr = text.split(" ");
		 * String textNumber = arr[2]; 
		 * int number = Integer.parseInt(textNumber);
		 * return number;
		 */

		return Integer.parseInt(txtProductHeader.getText().split(" ")[2]);

	}

	public int getProductsCount() {
		return productcount.size();
	}

	public void checkboxSmall() {
		checkboxSmall.click();
	}

	public void checkboxMedium() {
		checkboxMedium.click();
	}

	public void checkboxlarge() {
		checkboxlarge.click();
	}

	public void selectProduct() {
		product.click();
	}

	public void addCart() {
		Actions ac = new Actions(driver);
		ac.moveToElement(product).build().perform();
		addcart.click();
	}

	public WebElement cartPopUp() {
		return pdtimg;
	}

	public void closePop() {
		closepopup.click();
	}

	public int verifyCart() {
		return Integer.parseInt(cart.getText());
	}

	public void orderByAscending() {
		selectFromDropDown(dropdown, "price:asc");
	}

	public ArrayList<Double> verifyProductPrice() {
		ArrayList<String> price = new ArrayList<String>();
		for (WebElement element : pdtPrice)
			price.add(element.getText().replace("$", ""));
		System.out.println(price);

		ArrayList<Double> priceValue = new ArrayList<Double>();
		for (String value : price)
			priceValue.add(Double.parseDouble(value));

		 return priceValue;
	}
	
	
	public WebElement listView() {
		return listview;
	}
	
	public List<WebElement> getProducts() {
		return pdtList;
	}
	
	public List<WebElement> discountPrice(){
		return discount;
	}
	public boolean discountProducts(WebElement Parent) {
		return elementFound(Parent.findElement(By.xpath(".//*[@class='discount']")));
	}
		
	public boolean oldPriceList(WebElement Parent) {
		return elementFound(Parent.findElement(By.xpath(".//*[@class='old-price product-price']")));
	}
		
	
		
	//	if((elementFound(discount))&& (discount.getText()== "Reduced price!")) {
		//	Assert.assertTrue(elementFound(oldprice) == true, "Discount price available");
		
		
		
	}
	
	
	
	
	


