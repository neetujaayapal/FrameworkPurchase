package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Utils.Utils;
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



	public MyAccountPage loginProcess(String email, String password) {

		Utils.sendKeys(emailInputField, email);
		Utils.sendKeys(passwordInputField, password);
		Utils.normalClick(loginBtn);

		return new MyAccountPage();
	}

}
