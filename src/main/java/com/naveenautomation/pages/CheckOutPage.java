package com.naveenautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.naveenautomation.Utils.Utils;
import com.naveenautomation.base.TestBase;

public class CheckOutPage extends TestBase {

	public CheckOutPage() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div#content>div>div:nth-of-type(2)>div:nth-of-type(2) form>div:nth-of-type(3) input")
	
	WebElement newAddressBtn;
	@FindBy(css = "#input-payment-firstname")
	WebElement firstNameBtn;
	@FindBy(css = "#input-payment-lastname")
	WebElement lastNameBtn;
	@FindBy(css = "#input-payment-address-1")
	WebElement address;
	@FindBy(css = "#input-payment-city")
	WebElement city;
	@FindBy(css = "#input-payment-postcode")
	WebElement postalCode;
	@FindBy(css = "#input-payment-country")
	WebElement country;
	@FindBy(css = "#input-payment-zone")
	WebElement province;
	@FindBy(css = "div.buttons.clearfix input")
	WebElement billingDetailBtn;
	@FindBy(css = "input#button-shipping-address")
	WebElement deliveryDetailBtn;
	@FindBy(css = "input#button-shipping-method")
	WebElement deliveryMethodBtn;
	@FindBy(css = "div.panel-group>div:nth-of-type(5)>div:nth-of-type(2)>div>div.buttons div.pull-right input:nth-of-type(1)")
	WebElement paymentMethodAgreeBtn;
	@FindBy(css = "div.panel-group>div:nth-of-type(5)>div:nth-of-type(2)>div>div.buttons div.pull-right input:nth-of-type(2)")
	WebElement paymentMethodBtn;
	@FindBy(css = "div#collapse-checkout-confirm div.panel-body>div:nth-of-type(2) input")
	WebElement confirmOrderBtn;

	public void selectCountry() {

		select(country).selectByVisibleText("Canada");
	}

	public void selectProvince() {

		Utils.selectWithWait(driver, By.cssSelector("#input-payment-zone"), 50, "Ontario",
				driver.findElement(By.cssSelector("#input-payment-zone")));

	}

	public OrderPlacedPage alltest(String f, String l, String a, String c, String p) {
		Utils.sleep(5000);
		Utils.normalClick(newAddressBtn);
		Utils.sendKeys(firstNameBtn, f);

		Utils.sendKeys(lastNameBtn, l);

		Utils.sendKeys(address, a);

		Utils.sendKeys(city, c);

		Utils.sendKeys(postalCode, p);

		selectCountry();

		selectProvince();

		Utils.normalClick(billingDetailBtn);

		Utils.click3(driver, 10, By.cssSelector("input#button-shipping-address"));

		Utils.click3(driver, 10, By.cssSelector("input#button-shipping-method"));

		Utils.click3(driver, 10, By.cssSelector(
				"div.panel-group>div:nth-of-type(5)>div:nth-of-type(2)>div>div.buttons div.pull-right input:nth-of-type(1)"));

		Utils.normalClick(paymentMethodBtn);
		Utils.click3(driver, 10,
				By.cssSelector("div#collapse-checkout-confirm div.panel-body>div:nth-of-type(2) input"));

		return new OrderPlacedPage();

	}

	public Select select(WebElement element) {

		Select sc = new Select(element);

		return sc;
	}

	public String getTitleOfCheckOutpage() {

		return driver.getTitle();
	}

}
