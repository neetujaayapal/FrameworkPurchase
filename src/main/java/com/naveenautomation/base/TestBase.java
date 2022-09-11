package com.naveenautomation.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import com.naveenautomation.Utils.Utils;
import com.naveenautomation.Utils.WebDriverEvents;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public Properties prop;
	public static Logger logger;
	public static EventFiringWebDriver e_driver;
	public static WebDriverEvents events;
	public static JavascriptExecutor jse;

	public TestBase() {
		prop = new Properties();
		FileInputStream file;
		try {
			file = new FileInputStream(
					"C:\\Users\\skpos\\git\\FrameworkPurchase\\src\\main\\java\\com\\naveenautomation\\configure\\config.properties");
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

	@BeforeClass
	public void loggerSetUp() {
		logger = Logger.getLogger(TestBase.class);
		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();

		logger.setLevel(Level.INFO);
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

		e_driver = new EventFiringWebDriver(driver);
		events = new WebDriverEvents();
		e_driver.register(events);

		driver = e_driver;

		driver.manage().window().maximize();
		driver.get(prop.getProperty("base_url"));
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Utils.PAGE_LOAD_WAIT, TimeUnit.SECONDS);

	}
	

	public String email() {
		return prop.getProperty("email");
	}

	public String password() {
		return prop.getProperty("password");
	}
	public String firstName() {
		return prop.getProperty("firstname");
	}
	public String lastName() {
		return prop.getProperty("lastname");
	}
	public String address() {
		return prop.getProperty("address");
	}
	public String place() {
		return prop.getProperty("place");
	}
	public String postalCode() {
		return prop.getProperty("postalcode");
	}
	public String newPassword() {
		return prop.getProperty("newpassword");
	}


	public void quitBrowser() {
		driver.quit();
	}
	
//	public void waitForDocumentCompleteState(int timeOutInSeconds) {
//		new WebDriverWait(driver, timeOutInSeconds).until((ExpectedCondition<Boolean>) v -> {
//			logger.info("Verifying page has loaded......");
//			jse = (JavascriptExecutor) webDriver;
//			String documentIsReady = jse.executeScript("return document.readyState").toString();
//			while (true) {
//				if (documentIsReady.equalsIgnoreCase("complete")) {
//					logger.info("Page has loaded completely......");
//					return true;
//				} else {
//					return false;
//				}
//			}
//		});
//	}
}
