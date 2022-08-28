package com.naveenautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Utils.Utils;
import com.naveenautomation.base.TestBase;

public class PhonesAndPDA extends TestBase {

	public PhonesAndPDA() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div#content>div:nth-of-type(2)>div:nth-of-type(1) div.button-group span")
	WebElement addToCartElement;

	@FindBy(css = "ul.list-inline>li:nth-of-type(5) span")
	WebElement checkOutButton;

	public void addToCartBtnClick() {
		Utils.normalClick(addToCartElement);

	}

	public CheckOutPage checkOutBtnClick() {

		Utils.click2(driver, 20, By.cssSelector("ul.list-inline>li:nth-of-type(5) span"));

		return new CheckOutPage();
	}

	public String getTitleOfPhonesAndPads() {

		return driver.getTitle();
	}

}
