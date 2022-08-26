package com.naveenautomation.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.AccountLoginPage;
import com.naveenautomation.pages.ChangePassword;
import com.naveenautomation.pages.MyAccountPage;
import com.naveenautomation.pages.NaveenHomePage;
import com.naveenautomation.pages.PhonesAndPDA;

public class ChangePasswordTest extends TestBase {

	NaveenHomePage naveenHomePage;
	AccountLoginPage accountLoginPage;
	MyAccountPage myAccountPage;

	ChangePassword changePassword;

	@BeforeMethod
	public void startBrowser() {
		intialization();
		naveenHomePage = new NaveenHomePage();

	}

	@Test
	public void changePasswordTest() {
		naveenHomePage.clickMyAccountBtn();
		accountLoginPage = naveenHomePage.clickLogButton();
		myAccountPage = accountLoginPage.loginProcess(email(), password());
		changePassword = myAccountPage.passwordClick();

		String title = changePassword.totalPasswordBtn(newPassword(), newPassword()).getText();
		Assert.assertEquals(title, "Success: Your password has been successfully updated.",
				"Login title is not matching");

	}

	@AfterMethod
	public void quittingBrowser() {
		quitBrowser();

	}
}
