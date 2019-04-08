package homePageTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import homePageObjects.BasePage;
import homePageObjects.HomePageObjects;
import homePageObjects.dressPageObjects;
import homePageObjects.pdtDetailsObject;


public class pdtDetailsTest {
	
	pdtDetailsObject pdtPage;
	HomePageObjects homePage;
	dressPageObjects dressPage;
	BasePage bp;

	public pdtDetailsTest() {
		pdtPage = new pdtDetailsObject();
		dressPage = new dressPageObjects();
		homePage = new HomePageObjects();
		bp = new BasePage();
	}

	
	@Test
	public void productDetails() {
		homePage.clickDressTab();
		dressPage.selectProduct();
	    String desc = pdtPage.getProductDescription();
	    Assert.assertTrue(desc.length() < 250); 	    
		}
	
	@Test
	public void SocialsiteDisplay() {
		Assert.assertTrue(pdtPage.elementFound(pdtPage.twitter()));
		Assert.assertTrue(pdtPage.elementFound(pdtPage.share()));
	}

	
	
}
