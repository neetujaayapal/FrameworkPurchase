package com.naveenautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.naveenautomation.base.TestBase;

public class OrderPlacedPage extends TestBase{
	
	public OrderPlacedPage() {

		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css ="div#content h1")
	WebElement orderPlaced ;
	
	
	public String getTitleOrderPlaced() {
		
		explicitWait("Your order has been placed!", 30,By.cssSelector("div#content h1"));
		
		
		
		return orderPlaced.getText();
	}

	public boolean explicitWait(String name, int sec,By locator) {

		WebDriverWait wait = new WebDriverWait(driver, sec);

		return wait.until(ExpectedConditions.titleContains(name));
	}
}
