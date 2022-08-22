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

	NaveenHomePage obj1;
	AccountLoginPage acc;
	MyAccountPage accPage;

	@BeforeMethod
	public void startBrowser() {
		intialization();
		obj1 = new NaveenHomePage();
		acc = new AccountLoginPage();
		obj1.clickMyAccountBtn();
		obj1.clickLogButton();
		accPage = acc.loginProcess("neetu2020@gmail.com", "1234");
		//accPage = acc.clickLoginBtn();
	}

	@Test
	public void productListPageCheckTest() {

		String titleOfProductPage = accPage.clickAProduct().getTitleOfPhonesAndPads();
		Assert.assertEquals(titleOfProductPage, "Phones & PDAs", "Product List page title is not matching");
	}

	@AfterMethod
	public void quittingBrowser() {
		quitBrowser();
	}
}
