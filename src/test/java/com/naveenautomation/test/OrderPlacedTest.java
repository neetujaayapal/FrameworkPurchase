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

	NaveenHomePage naveenHomePage;
	AccountLoginPage accountLoginPage;
	MyAccountPage myAccountPage;
	PhonesAndPDA phonesAndPDA;
	CheckOutPage checkOutPage;
	OrderPlacedPage orderPlacedPage;

	@BeforeMethod
	public void startBrowser() {
		intialization();
		naveenHomePage = new NaveenHomePage();
		

	}

	@Test
	public void orderPlacedTest() {
		naveenHomePage.clickMyAccountBtn();
		accountLoginPage = naveenHomePage.clickLogButton();

		myAccountPage = accountLoginPage.loginProcess(email(),password());

		phonesAndPDA = myAccountPage.clickAProduct();

		phonesAndPDA.addToCartBtnClick();
		checkOutPage = phonesAndPDA.checkOutBtnClick();

		orderPlacedPage = checkOutPage.alltest(firstName(), lastName(), address(), place(), postalCode());
		String title = orderPlacedPage.getTitleOrderPlaced();
		Assert.assertEquals(title, "Your order has been placed!", "message not matching");
	}

	@AfterMethod
	public void quittingBrowser() {
		quitBrowser();
	}

}
