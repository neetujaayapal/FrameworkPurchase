package com.naveenautomation.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.NaveenHomePage;

public class NaveenHomePageTest extends TestBase {

	NaveenHomePage obj1;

	@BeforeMethod
	public void startBrowser() {
		intialization();
		obj1 = new NaveenHomePage();

	}

	@Test(priority = 1)
	public void myAccountButtonTest() {

		obj1.clickMyAccountBtn();

	}

	@Test(priority = 2)
	public void loginButtonTest() {

		myAccountButtonTest();

		obj1.clickLogButton();
	}

	@AfterMethod
	public void quittingBrowser() {
		quitBrowser();
	}
}
