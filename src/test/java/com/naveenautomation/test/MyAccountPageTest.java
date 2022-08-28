package com.naveenautomation.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.AccountLoginPage;
import com.naveenautomation.pages.MyAccountPage;
import com.naveenautomation.pages.NaveenHomePage;

public class MyAccountPageTest extends TestBase {

	NaveenHomePage naveenHomePage;
	AccountLoginPage accountLoginPage;
	MyAccountPage accPage;

	@BeforeMethod
	public void startBrowser() {
		intialization();
		naveenHomePage = new NaveenHomePage();
		
	}

	@Test
	public void productListPageCheckTest() {
		naveenHomePage.clickMyAccountBtn();
		accountLoginPage = naveenHomePage.clickLogButton();
	
		accPage = accountLoginPage.loginProcess(email(), password());
	

		String titleOfProductPage = accPage.clickAProduct().getTitleOfPhonesAndPads();
		Assert.assertEquals(titleOfProductPage, "Phones & PDAs", "Product List page title is not matching");
		
	}
	
	@Test
	public void passWordClickTest() {
		naveenHomePage.clickMyAccountBtn();
		accountLoginPage = naveenHomePage.clickLogButton();
	
		accPage = accountLoginPage.loginProcess(email(), password());
	
		String title = accPage.passwordClick().getTitleOfPassword();
		Assert.assertEquals(title, "Change Password","Title not matching");
		
	}

	@AfterMethod
	public void quittingBrowser() {
		quitBrowser();
	}
}
