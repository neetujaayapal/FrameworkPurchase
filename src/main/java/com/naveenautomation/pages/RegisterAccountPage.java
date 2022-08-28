package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Utils.Utils;
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



	public YourAccountCreated allRegTest(String name, String lname, String mail, String no, String pass,
			String cpass) {
		Utils.sendKeys(firstName, name);
		Utils.sendKeys(lastName, lname);
		Utils.sendKeys(email, mail);
		Utils.sendKeys(telephone, no);
		Utils.sendKeys(password, pass);
		Utils.sendKeys(confirmPassword, cpass);
		Utils.normalClick(agreeBtn);
		Utils.submit(submitBtn);

		return new YourAccountCreated();
	}

}
