package com.naveenautomation.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public Properties prop;

	public TestBase() {
		prop = new Properties();
		FileInputStream file;
		try {
			file = new FileInputStream(
					"C:\\JavaProject\\FrameworkPurchase\\src\\main\\java\\com\\naveenautomation\\configure\\config.properties");
			try {
				prop.load(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void intialization() {

		String browserName = prop.getProperty("browser");

		switch (browserName) {
		case "chrome":
			driver = WebDriverManager.chromedriver().create();

			break;
		case "firefox":
			driver = WebDriverManager.firefoxdriver().create();
			break;
		case "edge":
			driver = WebDriverManager.edgedriver().create();
			break;

		default:
			System.out.println(("Warning!!!!Enter appropriate browser"));
			break;
		}

		driver.manage().window().maximize();
		driver.get(prop.getProperty("base_url"));
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Long.valueOf(prop.getProperty("base_time")), TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(Long.valueOf(prop.getProperty("base_time")), TimeUnit.SECONDS);
	}

	public void quitBrowser() {
		driver.quit();
	}
}
