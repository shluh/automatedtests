package dataprovider;

import org.testng.annotations.DataProvider;

public class PhpTravelInvoiceContentDP {
	
	@DataProvider(name = "invoiceData")
	public static Object[][] allowedUsers() {
		return new Object[][] { { 
			"user@phptravels.com","demouser",
			"Rendezvous Hotels", "10/09/2018", 
			"11/09/2018", "114", "4259", 
			"Johny Smith","R2, Avenue du Maroc ","123456",
			"Junior Suites", "10/09/2018", "11/09/2018",
			"1","$250",
			"USD$27.50","USD$25","USD$275"
			}, };
	}

}
