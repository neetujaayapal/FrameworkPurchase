package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class ChangePassword  extends TestBase{
	
	public ChangePassword() {

		PageFactory.initElements(driver, this);
	}
	@FindBy(css = "#input-password")
	WebElement password;

	@FindBy(css = "#input-confirm")
	WebElement passwordConfirm;
	
	@FindBy(css = "div.buttons.clearfix>div:nth-of-type(2) input")
	WebElement continueBtn;
	
	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void enterConfirmPassword(String pass) {
		passwordConfirm.sendKeys(pass);
	}
	
	public MyAccountPage clickContinueBtn() {
		continueBtn.click();
		return new MyAccountPage();
	}
	
	public String getTitleOfPassword() {
		return driver.getTitle();
	}
	
	public MyAccountPage totalPasswordBtn(String pass,String cpass) {
		enterPassword(pass);
		enterConfirmPassword(cpass);
		continueBtn.click();
		return new MyAccountPage();
	}
}
