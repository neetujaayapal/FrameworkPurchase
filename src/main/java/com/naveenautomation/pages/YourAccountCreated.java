package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class YourAccountCreated extends TestBase{
	
	public YourAccountCreated() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css = "div#content h1")
	WebElement accAlertText;
	
	public String getTextOfAccCreated() {
		return accAlertText.getText();
	}

}
