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
	
	@FindBy(css = "div#content ul:nth-of-type(1) li:nth-of-type(2) a")
	WebElement changePassword;
	@FindBy(css ="div.alert.alert-success.alert-dismissible")
	WebElement successMessage;
	
	@FindBy(css = "div#content ul:nth-of-type(2) li:nth-of-type(1) a")
	WebElement orderHistory;
	
	

	public ChangePassword passwordClick() {

		changePassword.click();

		return new ChangePassword();
	}
	
	public OrderHistoryPage orderHistoryClick() {
		orderHistory.click();
		return new OrderHistoryPage();
	}
	
	
	
	
	
	
	public PhonesAndPDA clickAProduct() {

		productSelected.click();

		return new PhonesAndPDA();
	}

	public String getTitle() {
		return driver.getTitle();
	}
	
	public String getText() {
		return successMessage.getText();
	}

	


}
