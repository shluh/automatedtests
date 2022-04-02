package workFlows;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import pageObjects.InvoicePage;

public class InvoiceWorkFlows {
	private WebDriver driver;
	private InvoicePage invoicePage;

	public InvoiceWorkFlows(WebDriver driver) {
		this.driver = driver;
		this.invoicePage = new InvoicePage(driver);
	}

	public String GetHotelName() {
		return invoicePage.GetHotelNameContent().get(0).trim();
	}

	public String GetInvoiceDate() {
		return invoicePage.GetInvoiceContent().get(0).trim().replace(":", "");
	}

	public String GetDueDate() {
		return invoicePage.GetInvoiceContent().get(1).trim().replace(":", "");
	}

	public String GetInvoiceNumber() {
		return invoicePage.GetInvoiceContent().get(3).trim().replace(":", "");
	}

	public String GetBookingCode() {
		return invoicePage.GetInvoiceContent().get(4).trim();
	}

	public String GetCustomerDetailsName() {
		return invoicePage.GetCustomerDetailsContent().get(1);
	}

	public String GetCustomerDetailsAdress() {
		return invoicePage.GetCustomerDetailsContent().get(2);
	}

	public String GetCustomerDetailsNumber() {
		return invoicePage.GetCustomerDetailsContent().get(3);
	}

	public String GetRoom() {
		return invoicePage.GetRoomContent().get(0).trim().replace("Room:", "");
	}

	public String GetCheckIn() {
		return invoicePage.GetCheckInContent().get(1).trim();
	}

	public String GetCheckOut() {
		return invoicePage.GetCheckOutContent().get(1).trim();
	}

	public String GetTotalStayDay() {
		return invoicePage.GetTotalStayContent().get(0).trim();
	}

	public String GetTotalStay() {
		return invoicePage.GetTotalStayContent().get(1).trim();
	}

	public String GetDepositNow() {
		return invoicePage.GetPaymentsContent().get(0).trim();
	}

	public String GetTaxEVAT() {
		return invoicePage.GetPaymentsContent().get(1).trim();
	}

	public String GetTotalAmount() {
		return invoicePage.GetPaymentsContent().get(2).trim();
	}

	public void PageInvoiceReady() {
		invoicePage.PageInvoiceReady();
	}

	public void assertEquals(boolean actual, boolean expected) {
		Assert.assertEquals(actual, expected);
	}

}
