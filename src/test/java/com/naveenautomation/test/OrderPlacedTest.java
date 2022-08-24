package com.naveenautomation.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.AccountLoginPage;
import com.naveenautomation.pages.CheckOutPage;
import com.naveenautomation.pages.MyAccountPage;
import com.naveenautomation.pages.NaveenHomePage;
import com.naveenautomation.pages.OrderPlacedPage;
import com.naveenautomation.pages.PhonesAndPDA;

public class OrderPlacedTest extends TestBase {

	NaveenHomePage obj1;
	AccountLoginPage acc;
	MyAccountPage accPage;
	PhonesAndPDA ph;
	CheckOutPage che;
	OrderPlacedPage or;

	@BeforeMethod
	public void startBrowser() {
		intialization();
		obj1 = new NaveenHomePage();
		obj1.clickMyAccountBtn();
		acc = obj1.clickLogButton();

		accPage = acc.loginProcess("neetu2020@gmail.com", "1234");

		ph = accPage.clickAProduct();

		ph.addToCartBtnClick();
		che = ph.checkOutBtnClick();

		or = che.alltest("Neetu", "Jayapalan", "Mcmurchy", "Brampton", "L6X");

	}

	@Test
	public void orderPlacedTest() {

		String title = or.getTitleOrderPlaced();
		Assert.assertEquals(title, "Your order has been placed!", "message not matching");
	}

	@AfterMethod
	public void quittingBrowser() {
		quitBrowser();
	}

}
