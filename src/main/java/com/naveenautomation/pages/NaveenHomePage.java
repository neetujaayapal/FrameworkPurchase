package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class NaveenHomePage extends TestBase {

	public NaveenHomePage() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "ul.list-inline li:nth-of-type(2)  a span:nth-of-type(1)")
	WebElement myAccountBtn;

	@FindBy(css = "ul.list-inline li:nth-of-type(2)  ul li:nth-of-type(2) a")
	WebElement loginBtn;

	@FindBy(css = "ul.list-inline li:nth-of-type(2)  ul li:nth-of-type(1) a")
	WebElement regBtn;

	public void clickMyAccountBtn() {
		myAccountBtn.click();
	}

	public AccountLoginPage clickLogButton() {
		loginBtn.click();
		return new AccountLoginPage();
	}

}
