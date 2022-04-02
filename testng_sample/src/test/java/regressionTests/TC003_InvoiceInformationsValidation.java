package regressionTests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import dataprovider.PhpTravelInvoiceContentDP;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.PHPTEnviornments;
import workFlows.InvoiceWorkFlows;
import workFlows.LoginWorkFlows;
import workFlows.MyAccountWorkFlows;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TC003_InvoiceInformationsValidation {
	WebDriver driver;
	private LoginWorkFlows loginWorkFlows;
	private InvoiceWorkFlows invoiceWorkFlows;
	private MyAccountWorkFlows myAccountWorkFlows;

	@Test(dataProvider = "invoiceData", dataProviderClass = PhpTravelInvoiceContentDP.class)
	public void InvoiceInformations(String userEmail, String userSenha, String hotelName, String invoiceDate,
			String dueDate, String invoiceNumber, String bookingCode, String customerDetailsName,
			String customerDetailsAdress, String customerDetailsFone, String room, String checkIn, String checkOut,
			String totalStayDay, String totalStayCost, String depositNow, String taxEVAT, String totalAmount) {

		driver.get(PHPTEnviornments.HOM);
		loginWorkFlows.LoginValidationWithValidCredencials(customerDetailsName, userEmail, userSenha, "Login");
		myAccountWorkFlows.SelectAndGoToFirstInvoicePage();
		invoiceWorkFlows.PageInvoiceReady();

		assertTrue(invoiceWorkFlows.GetHotelName().equals(hotelName));
		assertTrue(invoiceWorkFlows.GetInvoiceDate().equals(invoiceDate));
		assertTrue(invoiceWorkFlows.GetDueDate().equals(dueDate));
		assertTrue(invoiceWorkFlows.GetInvoiceNumber().equals(invoiceNumber));
		assertTrue(invoiceWorkFlows.GetBookingCode().equals(bookingCode));
		assertTrue(invoiceWorkFlows.GetCustomerDetailsName().equals(customerDetailsName));
		assertTrue(invoiceWorkFlows.GetCustomerDetailsAdress().equals(customerDetailsAdress));
		assertTrue(invoiceWorkFlows.GetCustomerDetailsNumber().equals(customerDetailsFone));
		assertTrue(invoiceWorkFlows.GetRoom().equals(room));
		assertTrue(invoiceWorkFlows.GetCheckIn().equals(checkIn));
		assertTrue(invoiceWorkFlows.GetCheckOut().equals(checkOut));
		assertTrue(invoiceWorkFlows.GetTotalStayDay().equals(totalStayDay));
		assertTrue(invoiceWorkFlows.GetTotalStay().equals(totalStayCost));
		assertTrue(invoiceWorkFlows.GetDepositNow().equals(depositNow));
		assertTrue(invoiceWorkFlows.GetTaxEVAT().equals(taxEVAT));
		assertTrue(invoiceWorkFlows.GetTotalAmount().equals(totalAmount));

	}

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		loginWorkFlows = new LoginWorkFlows(driver);
		invoiceWorkFlows = new InvoiceWorkFlows(driver);
		myAccountWorkFlows = new MyAccountWorkFlows(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
