package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Utils.Utils;
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
	

	
	public String getTitleOfPassword() {
		return driver.getTitle();
	}
	
	public MyAccountPage totalPasswordBtn(String pass,String cpass) {
		
		Utils.normalSendKeys(password, pass);

		Utils.normalSendKeys(passwordConfirm, cpass);
		
		Utils.normalClick(continueBtn);

		return new MyAccountPage();
	}
}
