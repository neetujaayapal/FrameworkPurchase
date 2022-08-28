package com.naveenautomation.Utils;

import java.io.File;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.naveenautomation.base.TestBase;

public class Utils extends TestBase {
	
	public static final int PAGE_LOAD_WAIT=30;
	public static final int IMPLICIT_WAIT=10;

	public static void takeFailedTestScreenShot(String testCaseName) {
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		File screenShotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(screenShotFile,new File("./FailedScreenShot\\" + "_" + testCaseName + "_" + timeStamp + ".jpeg"));
		} catch (IOException e) {
			
			System.out.println("Unable to save or take screen shot of failed test " + testCaseName);
		}
	}
	
	public static String generateRandomEmail() {

		String email = RandomStringUtils.randomNumeric(3);

		String emailID = "Manvir" + email + "@gmail.com";

		return emailID;

	}

	public static String generateRandomPassword() {

		String randomStringForPassword = RandomStringUtils.randomNumeric(3);

		String password = "Manager@" + randomStringForPassword;

		return password;

	}
	
	public static void sleep(int seconds){
		
		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void click1(WebElement element,int sec){

	
		new WebDriverWait(driver, sec).until(ExpectedConditions.visibilityOf(element)).click();
	}
	
	
	
	public static void click2(WebDriver driver, int sec, By locator) {
		new WebDriverWait(driver, sec).until(ExpectedConditions.elementToBeClickable(locator)).click();
	}

	public static boolean isDisplayed(WebElement element) {
		return new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element)).isDisplayed();
	}
	
	public static void click3(WebDriver driver, int sec,By locator) {

		new WebDriverWait(driver, sec).until(ExpectedConditions.visibilityOfElementLocated(locator)).click();

	}
	
	public static void normalClick(WebElement element) {
		element.click();		
	}
	
	public static void normalSendKeys(WebElement element,String name) {
		element.sendKeys(name);		
	}
	
	public static void submit(WebElement element) {
		element.submit();		
	}

	
	
	public static void getTitleFromPage(String name, int sec) {
		new WebDriverWait(driver, sec).until(ExpectedConditions.titleContains(name));
	}
	
	
	public static void selectWithWait(WebDriver driver ,By locator, int time, String name,WebElement element) {

		new WebDriverWait(driver, time).until(ExpectedConditions.textToBePresentInElement(element, name));

		Select sc = new Select(driver.findElement(locator));

		try {
			sc.selectByVisibleText(name);
		}

		catch (Exception e) {

			sc.selectByValue(name);;
		}

	}
	
	

	public static void acceptAlert() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent()).accept();
	}

	public static void dismissAlert() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent()).dismiss();
	}

	public static void selectFromDropDown(WebElement element, String value) {
		waitForElementToBeSelectable(element);
		Select sc = new Select(element);

		try {
			sc.selectByValue(value);
		} catch (Exception e) {
			sc.selectByVisibleText(value);
		}

	}

	public static void switchToNewTab(WebElement element) {
		String parentHandle = driver.getWindowHandle();
		logger.info("Parent Window Handle is " + parentHandle);
		waitForElementToBeClickable(element);

		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String windowHandle : allWindowHandles) {
			if (!windowHandle.equals(parentHandle)) {
				driver.switchTo().window(windowHandle);
			}
		}

	}

	public static void sendKeys(WebElement element, String keysInput) {
		new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(element)).sendKeys(keysInput);
	}

	public static void waitForElementToBeSelectable(WebElement element) {
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementSelectionStateToBe(element, true));
	}

	public static void waitForElementToBeDisplayed(WebElement element) {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitForElementToBeClickable(WebElement element) {
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void javascriptClick(WebElement element) {
		jse.executeScript("arguments[0].click();", element);
	}

	public static void scrollIntoViewUsingJavascript(WebElement element) {
		jse.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public static void sendKeysUsingJavascript(WebElement element, String emailInput) {
		jse.executeScript("arguments[0].setAttribute('value', '"+emailInput+"')", element);
	}
}
