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
	//@FindBy(xpath="//input[@value='existing']")
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
	

	public void newAddressBtnClick() {
	//explicitWait1(driver, ,newAddressBtn);
//	Utils.click1(newAddressBtn, 60);
		//Utils.javascriptClick(newAddressBtn);
		
		newAddressBtn.click();
	}
	
	public void enterFirstName(String name) {
		firstNameBtn.sendKeys(name);
	}

	public void enterLastName(String nam) {
		lastNameBtn.sendKeys(nam);
	}

	public void enterAddress(String add) {
		address.sendKeys(add);
	}

	public void enterCity(String cit) {
		city.sendKeys(cit);
	}

	public void enterPostalCode(String po) {
		postalCode.sendKeys(po);
	}

	public void selectCountry() {

		select(country).selectByVisibleText("Canada");
	}

	public void selectProvince() {
		
	Utils.selectWithWait(driver,By.cssSelector("#input-payment-zone"), 50, "Ontario",driver.findElement(By.cssSelector("#input-payment-zone")));

		//select(province).selectByVisibleText("Ontario");
	}

	public void billingDetailBtnClick() {
		billingDetailBtn.click();
	}

	public void deliveryDetailBtnClick() {
		deliveryDetailBtn.click();
	}

	public void deliveryMethodBtnClick() {
		deliveryMethodBtn.click();
	}

	public void paymentAgreeBtnClick() {
		paymentMethodAgreeBtn.click();
	}

	public void paymentMethodBtnClick() {
		paymentMethodBtn.click();
	}

	public OrderPlacedPage confirmOrderBtnClick() {
		confirmOrderBtn.click();

		return new OrderPlacedPage();
	}


	public OrderPlacedPage alltest(String f, String l, String a, String c, String p) {
       Utils.sleep(5000);
		newAddressBtn.click();

		enterFirstName(f);

		enterLastName(l);

		enterAddress(a);

		enterCity(c);

		enterPostalCode(p);

		selectCountry();

		selectProvince();

		billingDetailBtnClick();

		Utils.click3(driver, 10, By.cssSelector("input#button-shipping-address"));
		
		deliveryDetailBtnClick();
		Utils.click3(driver, 10, By.cssSelector("input#button-shipping-method"));
		
		deliveryMethodBtnClick();
		Utils.click3(driver, 10, By.cssSelector("div.panel-group>div:nth-of-type(5)>div:nth-of-type(2)>div>div.buttons div.pull-right input:nth-of-type(1)"));
		
		paymentAgreeBtnClick();
		paymentMethodBtnClick();
		Utils.click3(driver, 10, By.cssSelector("div#collapse-checkout-confirm div.panel-body>div:nth-of-type(2) input"));

		return confirmOrderBtnClick();

	}

	public Select select(WebElement element) {

		Select sc = new Select(element);

		return sc;
	}

	public String getTitleOfCheckOutpage() {

		return driver.getTitle();
	}

	
	

	
	
	

}
