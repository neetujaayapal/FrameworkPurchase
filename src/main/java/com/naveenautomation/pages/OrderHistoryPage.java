package com.naveenautomation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Utils.Utils;
import com.naveenautomation.base.TestBase;

public class OrderHistoryPage extends TestBase {

	public OrderHistoryPage() {

		PageFactory.initElements(driver, this);
	}

	public String totalValue(String id) {
		return getCellFromTable(id, table.TOTAL).getText();
	}

	public String dateValue(String id) {
		return getCellFromTable(id, table.DATEADDED).getText();
	}

	public enum table {
		ORDERID("Order ID"), CUSTOMER("Customer"), NOOFPRODUCTS("No of Products"), STATUS("Status"), TOTAL("Total"),
		DATEADDED("Date Added");

		private String value;

		table(String value) {
			this.value = value;
		}

		public String getText() {
			return value;
		}
	}

	private WebElement getCellFromTable(String orderID, table column) {

		int columnIndex = getIndexForColumn(column);
		int orderIdColumnIndex = getIndexForColumn(table.ORDERID);

		if (columnIndex < 0) {
			return null;
		}

		List<WebElement> rows = driver
				.findElements(By.cssSelector("table[class='table table-bordered table-hover'] tbody tr"));
		Utils.sleep(5000);
		for (int i = 1; i < rows.size(); i++) {
			List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
			if (cells.size() < columnIndex || cells.size() < orderIdColumnIndex) {
				continue;
			}
			String[] devicesIds = cells.get(orderIdColumnIndex).getText().split("\n");
			for (int j = 0; j < devicesIds.length; j++) {
				if (devicesIds[j].equals(orderID)) {
					return cells.get(columnIndex);
				}
			}

		}
		System.out.println(String.format("Cant find row that contains Order Id =%s", orderID));
		return null;
	}

	private int getIndexForColumn(table column) {
		List<WebElement> headers = null;
		headers = driver.findElements(By.cssSelector("table[class='table table-bordered table-hover'] thead td"));

		for (WebElement header : headers) {
			if (column.getText().equals(header.getText())) {
				return headers.indexOf(header);
			}
		}
		return -1;
	}

}
