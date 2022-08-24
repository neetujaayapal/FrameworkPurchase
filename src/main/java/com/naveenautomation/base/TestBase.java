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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
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

		driver.manage().timeouts().implicitlyWait(Utils.IMPLICIT_WAIT, TimeUnit.SECONDS);
	}

	public void quitBrowser() {
		driver.quit();
	}
}
