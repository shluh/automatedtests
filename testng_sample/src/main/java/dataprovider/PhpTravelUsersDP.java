package dataprovider;

import org.testng.annotations.DataProvider;

public class PhpTravelUsersDP {
	@DataProvider(name = "AllowedUsers")
	public static Object[][] allowedUsers() {
	    return new Object[][] {
	        {"Johny Smith", "user@phptravels.com", "demouser"},
	    };
	}
	
	@DataProvider(name = "DeniedUsers")
	public static Object[][] deniedUsers() {
	    return new Object[][] {
	        {"user@phptravels.com", "Demouser"},
	        {"user@phptravels.com", "demouser_"},
	        {"user@phptravels.com.br", "demouser"},
	        {"another_user@phptravels.com", "Demouser"}
	    };
	}

}
