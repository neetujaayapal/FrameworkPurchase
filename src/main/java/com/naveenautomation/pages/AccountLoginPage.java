package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class AccountLoginPage extends TestBase {

	public AccountLoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#input-email")
	WebElement emailInputField;

	@FindBy(css = "#input-password")
	WebElement passwordInputField;

	@FindBy(css = "input.btn.btn-primary")
	WebElement loginBtn;

	public void enterEmail(String email) {
		emailInputField.sendKeys(email);
	}

	public void enterPassword(String password) {
		passwordInputField.sendKeys(password);
	}

	public MyAccountPage clickLoginBtn() {
		loginBtn.click();
		return new MyAccountPage();
	}

	public MyAccountPage loginProcess(String email, String password) {

		enterEmail(email);
		enterPassword(password);
		return clickLoginBtn();
	}

}
