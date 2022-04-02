package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InvoicePage {
	private WebDriver webDriver;
	private WebDriverWait wait;
	private final By invoiceTablesHeader = By.cssSelector("#invoiceTable tbody tbody");
	private final By invoiceTablesHotelAndPayments = By.cssSelector("#invoiceTable tbody tbody tbody");
	private final By invoicePage = By.id("content");

	public InvoicePage(WebDriver webDriver) {
		this.webDriver = webDriver;
		this.wait = new WebDriverWait(webDriver, 30);
	}

	public List<WebElement> InvoiceHeaderTables() {
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(invoiceTablesHeader));
	}

	public List<WebElement> InvoiceHotelAndPaymentsTables() {
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(invoiceTablesHotelAndPayments));
	}

	public List<WebElement> InvoiceRows() {
		return InvoiceHeaderTables().get(0).findElements(By.tagName("div"));
	}

	public List<WebElement> CustomerDetailsRows() {
		return InvoiceHeaderTables().get(1).findElements(By.tagName("div"));
	}

	public List<WebElement> InvoiceHotelRows() {
		return InvoiceHotelAndPaymentsTables().get(0).findElements(By.tagName("tr"));
	}

	public List<WebElement> HotelNameContent() {
		return InvoiceHotelRows().get(0).findElements(By.tagName("td"));
	}

	public List<WebElement> RoomContent() {
		return InvoiceHotelRows().get(2).findElements(By.tagName("td"));
	}

	public List<WebElement> CheckInContent() {
		return InvoiceHotelRows().get(3).findElements(By.tagName("td"));
	}

	public List<WebElement> CheckOutContent() {
		return InvoiceHotelRows().get(4).findElements(By.tagName("td"));
	}

	public List<WebElement> TotalStayContent() {
		return InvoiceHotelRows().get(5).findElements(By.tagName("td"));
	}

	public List<WebElement> InvoicePaymentsRows() {
		return InvoiceHotelAndPaymentsTables().get(1).findElements(By.tagName("tr"));
	}

	public List<WebElement> PaymentsContent() {
		return InvoicePaymentsRows().get(0).findElements(By.tagName("td"));
	}

	public List<String> GetInvoiceContent() {
		ArrayList<String> invoice = new ArrayList<String>();
		for (WebElement str : InvoiceRows()) {
			invoice.add(str.getText());
		}
		return invoice;
	}

	public List<String> GetCustomerDetailsContent() {
		ArrayList<String> customerDetails = new ArrayList<String>();
		for (WebElement str : CustomerDetailsRows()) {
			customerDetails.add(str.getText());
		}
		return customerDetails;
	}

	public List<String> GetHotelNameContent() {
		ArrayList<String> hotelName = new ArrayList<String>();
		for (WebElement str : HotelNameContent()) {
			hotelName.add(str.getText());
		}
		return hotelName;
	}

	public List<String> GetRoomContent() {
		ArrayList<String> room = new ArrayList<String>();
		for (WebElement str : RoomContent()) {
			room.add(str.getText());
		}
		return room;
	}

	public List<String> GetCheckInContent() {
		ArrayList<String> checkin = new ArrayList<String>();
		for (WebElement str : CheckInContent()) {
			checkin.add(str.getText());
		}
		return checkin;
	}

	public List<String> GetCheckOutContent() {
		ArrayList<String> checkout = new ArrayList<String>();
		for (WebElement str : CheckOutContent()) {
			checkout.add(str.getText());
		}
		return checkout;
	}

	public List<String> GetTotalStayContent() {
		ArrayList<String> totalStay = new ArrayList<String>();
		for (WebElement str : TotalStayContent()) {
			totalStay.add(str.getText());
		}
		return totalStay;
	}

	public List<String> GetPaymentsContent() {
		ArrayList<String> payment = new ArrayList<String>();
		for (WebElement str : PaymentsContent()) {
			payment.add(str.getText());
		}
		return payment;
	}

	public void PageInvoiceReady() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(invoicePage));
	}

}
