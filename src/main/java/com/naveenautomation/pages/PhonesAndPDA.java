package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class PhonesAndPDA extends TestBase {

	public PhonesAndPDA() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css="div#content>div:nth-of-type(2)>div:nth-of-type(2) div.button-group span")
	WebElement addToCartElement;
	
	@FindBy(css="ul.list-inline>li:nth-of-type(5) span")
	WebElement checkOutButton;
	
	
	public void addToCartBtnClick() {
		
		addToCartElement.click();
	}

	public CheckOutPage checkOutBtnClick() {
		checkOutButton.click();
		return new CheckOutPage();
	}
	
	public String getTitleOfPhonesAndPads() {

		return driver.getTitle();
	}

}
