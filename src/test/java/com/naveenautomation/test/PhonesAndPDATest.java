package com.naveenautomation.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.AccountLoginPage;
import com.naveenautomation.pages.MyAccountPage;
import com.naveenautomation.pages.NaveenHomePage;
import com.naveenautomation.pages.PhonesAndPDA;

public class PhonesAndPDATest extends TestBase {

	NaveenHomePage obj1;
	AccountLoginPage acc;
	MyAccountPage accPage;
	PhonesAndPDA ph;

	@BeforeMethod
	public void startBrowser() {
		intialization();
		obj1 = new NaveenHomePage();
		acc = new AccountLoginPage();
		accPage = new MyAccountPage();
		obj1.clickMyAccountBtn();
		obj1.clickLogButton();
		accPage = acc.loginProcess("neetu2020@gmail.com", "1234");

		ph = accPage.clickAProduct();

	}

	@Test
	public void addToCartClickTest() {

		ph.addToCartBtnClick();

	}

	@Test
	public void checkOutClickTest() {

		ph.checkOutBtnClick();

	}

	@AfterMethod
	public void quittingBrowser() {
		quitBrowser();
	}
}
