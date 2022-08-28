package com.naveenautomation.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.naveenautomation.Utils.ExcelUtils;
import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.NaveenHomePage;
import com.naveenautomation.pages.RegisterAccountPage;

public class RegisterAccountPageTest extends TestBase {

	NaveenHomePage naveenHomePage;
	RegisterAccountPage registerAccountPage;

	@BeforeMethod
	public void startBrowser() {
		intialization();
		naveenHomePage = new NaveenHomePage();

	}

	@Test(dataProvider = "Register")
	public void loginTest(String fname, String lname, String email, String tel, String pass, String cpass) {
		naveenHomePage.clickMyAccountBtn();
		registerAccountPage = naveenHomePage.clickRegButton();
		String text = registerAccountPage.allRegTest(fname, lname, email, tel, pass, cpass).getTextOfAccCreated();

		// Assert.assertEquals(text, "Your Account Has Been Created!", "text is not
		// matching");
	}

	@AfterMethod
	public void quittingBrowser() {
		quitBrowser();
	}

	@DataProvider(name = "Register")
	String[][] dataProviderToLogin() throws Exception {
		String filePath = "C:\\Users\\neetu\\Desktop\\Naveen.xlsx";
		int row = ExcelUtils.getRowsCount(filePath, "Sheet1");
		int col = ExcelUtils.getColumnCount(filePath, "Sheet1", row);

		String[][] registerdata = new String[row][col];
		for (int i = 1; i <= row; i++) {
			for (int j = 0; j < col; j++) {
				registerdata[i - 1][j] = ExcelUtils.getCellData(filePath, "Sheet1", i, j);
			}
		}

		return registerdata;

	}
}
