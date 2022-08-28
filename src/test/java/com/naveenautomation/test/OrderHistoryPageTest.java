package com.naveenautomation.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.AccountLoginPage;
import com.naveenautomation.pages.MyAccountPage;
import com.naveenautomation.pages.NaveenHomePage;
import com.naveenautomation.pages.OrderHistoryPage;

public class OrderHistoryPageTest extends TestBase {

	NaveenHomePage naveenHomePage;
	AccountLoginPage accLoginPage;
	MyAccountPage myAccPagePage;
	OrderHistoryPage orderHistoryPage;

	@BeforeMethod
	public void startBrowserSession() {
		intialization();
		naveenHomePage = new NaveenHomePage();

	}

	@Test
	public void verifyTotalAndOrderDate() {

		
		naveenHomePage.clickMyAccountBtn();
		
		accLoginPage = naveenHomePage.clickLogButton();
		myAccPagePage = accLoginPage.loginProcess(email(), password());
		orderHistoryPage = myAccPagePage.orderHistoryClick();
		String total = orderHistoryPage.totalValue("#1565");
		Assert.assertEquals(total, "$105.00", "Amount does not match");
		System.out.println("The amount matches with ID");

		String date = orderHistoryPage.dateValue("#1565");
		Assert.assertEquals(date, "28/08/2022", "Date does not match");
		System.out.println("The date matches with ID");
	}

	@AfterMethod
	public void CloseBrowserSession() {
		quitBrowser();
	}

}
