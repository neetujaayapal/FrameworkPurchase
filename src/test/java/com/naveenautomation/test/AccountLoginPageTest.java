package com.naveenautomation.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.AccountLoginPage;

import com.naveenautomation.pages.NaveenHomePage;

public class AccountLoginPageTest extends TestBase {

	NaveenHomePage obj1;
	AccountLoginPage accLogin;

	@BeforeMethod
	public void startBrowser() {
		intialization();
		obj1 = new NaveenHomePage();
		obj1.clickMyAccountBtn();
		accLogin = obj1.clickLogButton();

	}

	@Test
	public void loginTest() {

		String title = accLogin.loginProcess("neetu2020@gmail.com", "1234").getTitle();
		Assert.assertEquals(title, "My Account", "Login title is not matching");
	}

	@AfterMethod
	public void quittingBrowser() {
		quitBrowser();
	}

}
