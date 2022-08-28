package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class RegisterAccountPage extends TestBase {

	public RegisterAccountPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "fieldset#account>div:nth-of-type(2) input")
	WebElement firstName;
	@FindBy(css = "fieldset#account>div:nth-of-type(3) input")
	WebElement lastName;
	@FindBy(css = "fieldset#account>div:nth-of-type(4) input")
	WebElement email;
	@FindBy(css = "fieldset#account>div:nth-of-type(5) input")
	WebElement telephone;
	@FindBy(css = "div#content form fieldset:nth-of-type(2)>div:nth-of-type(1) input")
	WebElement password;
	@FindBy(css = "div#content form fieldset:nth-of-type(2)>div:nth-of-type(2) input")
	WebElement confirmPassword;
	@FindBy(css = "div.buttons input:nth-of-type(1)")
	WebElement agreeBtn;
	@FindBy(css = "div.buttons input:nth-of-type(2)")
	WebElement submitBtn;

	public void enterFirstName(String name) {
		firstName.sendKeys(name);
	}

	public void enterLastName(String name) {
		lastName.sendKeys(name);
	}

	public void enterEmail(String mail) {
		email.sendKeys(mail);
	}

	public void enterTelephone(String ph) {
		telephone.sendKeys(ph);
	}

	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}

	public void enterConfirmPass(String pass) {
		confirmPassword.sendKeys(pass);
	}

	public void clickAgree() {
		agreeBtn.click();
	}

	public YourAccountCreated clickSubmit() {
		submitBtn.submit();
		return new YourAccountCreated();
	}

	public YourAccountCreated allRegTest(String name, String lname, String email, String no, String pass,
			String cpass) {
		enterFirstName(name);
		enterLastName(lname);
		enterEmail(email);
		enterTelephone(no);
		enterPassword(pass);
		enterConfirmPass(cpass);
		clickAgree();
		clickSubmit();

		return new YourAccountCreated();
	}

}
