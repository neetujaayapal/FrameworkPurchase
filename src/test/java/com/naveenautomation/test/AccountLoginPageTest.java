//Updated by Surabhi
package com.naveenautomation.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.AccountLoginPage;

import com.naveenautomation.pages.NaveenHomePage;

public class AccountLoginPageTest extends TestBase {

	NaveenHomePage naveenHomePage;
	AccountLoginPage accLogin;

	@BeforeMethod
	public void startBrowser() {
		intialization();
		naveenHomePage = new NaveenHomePage();

	}

	@Test
	public void loginTest() {

		naveenHomePage.clickMyAccountBtn();

		accLogin = naveenHomePage.clickLogButton();
		String title = accLogin.loginProcess(email(), password()).getTitle();

		Assert.assertEquals(title, "My Account", "Login title is not matching");
	}

	@AfterMethod
	public void quittingBrowser() {
		quitBrowser();
	}

}
