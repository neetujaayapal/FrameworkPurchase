package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Utils.Utils;
import com.naveenautomation.base.TestBase;

public class OrderPlacedPage extends TestBase {

	public OrderPlacedPage() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div#content h1")
	WebElement orderPlaced;

	public String getTitleOrderPlaced() {

		Utils.getTitleFromPage("Your order has been placed!", 30);

		return orderPlaced.getText();
	}

}
