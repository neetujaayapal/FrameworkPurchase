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
		acc = new AccountLoginPage();
		accPage = new MyAccountPage();
		che = new CheckOutPage();
		ph = new PhonesAndPDA();
		obj1.clickMyAccountBtn();
		obj1.clickLogButton();
		acc.loginProcess("neetu2020@gmail.com", "1234");
		accPage.clickAProduct();
		ph.addToCartBtnClick();
		ph.checkOutBtnClick();
		or = che.alltest("Neetu", "Jayapalan", "Mcmurchy", "Brampton", "L6X");
		// or = che.confirmOrderBtnClick();

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
