package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class MyAccountPage extends TestBase {

	public MyAccountPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "ul.nav.navbar-nav li:nth-of-type(6) a")
	WebElement productSelected;

	public PhonesAndPDA clickAProduct() {
		productSelected.click();

		return new PhonesAndPDA();
	}

	public String getTitle() {
		return driver.getTitle();
	}

}
