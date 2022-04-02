package dataprovider;

import org.testng.annotations.DataProvider;

public class InvestimentoPoupancaDP {
	@DataProvider(name = "InvestimentoPoupanca")
	public static Object[][] poupanca() {
	    return new Object[][] {
	        {"paraVoce", 15000, 5000, 5, "Anos"},
	    };
	}
	
	@DataProvider(name = "ValorMinimo")
	public static Object[][] valorMinimo() {
	    return new Object[][] {
	        {"paraVoce", 5, 5},
	    };
	}

}
