package com.naveenautomation.test;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.AccountLoginPage;
import com.naveenautomation.pages.CheckOutPage;
import com.naveenautomation.pages.MyAccountPage;
import com.naveenautomation.pages.NaveenHomePage;
import com.naveenautomation.pages.PhonesAndPDA;

public class CheckOutPageTest extends TestBase {

	NaveenHomePage naveenHomePage;
	AccountLoginPage accountLoginPage;
	MyAccountPage myAccountPage;
	PhonesAndPDA phonesAndPDA;
	CheckOutPage che;

	@BeforeMethod
	public void startBrowser() {
		intialization();
		naveenHomePage = new NaveenHomePage();

		
	}

	@Test(priority = 3)
	public void allButtonTest() {
		naveenHomePage.clickMyAccountBtn();
		accountLoginPage = naveenHomePage.clickLogButton();
		myAccountPage = accountLoginPage.loginProcess(email(),password());

		phonesAndPDA = myAccountPage.clickAProduct();
		phonesAndPDA.addToCartBtnClick();
		che = phonesAndPDA.checkOutBtnClick();


		String title = che.alltest(firstName(), lastName(), address(), place(), postalCode()).getTitleOrderPlaced();
		Assert.assertEquals(title, "Your order has been placed!", "Message not matching");
	}

	@AfterMethod
	public void quittingBrowser() {
		quitBrowser();
	}

}
