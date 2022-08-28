package com.naveenautomation.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.AccountLoginPage;
import com.naveenautomation.pages.MyAccountPage;
import com.naveenautomation.pages.NaveenHomePage;
import com.naveenautomation.pages.PhonesAndPDA;

public class PhonesAndPDATest extends TestBase {

	NaveenHomePage naveenHomePage;
	AccountLoginPage accountLoginPage;
	MyAccountPage myAccountPage;
	PhonesAndPDA phonesAndPDA;

	@BeforeMethod
	public void startBrowser() {
		intialization();
		naveenHomePage = new NaveenHomePage();

		
	}

	@Test
	public void addToCartClickTest() {
		naveenHomePage.clickMyAccountBtn();
		accountLoginPage = naveenHomePage.clickLogButton();
		myAccountPage = accountLoginPage.loginProcess(email(),password());

		phonesAndPDA = myAccountPage.clickAProduct();

		phonesAndPDA.addToCartBtnClick();

	}

	@Test
	public void checkOutClickTest() {
		naveenHomePage.clickMyAccountBtn();
		accountLoginPage = naveenHomePage.clickLogButton();
		myAccountPage = accountLoginPage.loginProcess(email(),password());

		phonesAndPDA = myAccountPage.clickAProduct();


		Assert.assertEquals(phonesAndPDA.checkOutBtnClick().getTitleOfCheckOutpage(), "Checkout", "Title not matching");

	}

	@AfterMethod
	public void quittingBrowser() {
		quitBrowser();
	}
}
