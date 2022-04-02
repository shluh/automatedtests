package utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenshots {
	
	static String evidenciasPath = "evidencias/screenshot/";
	
	
	public static void takeScreenshot(WebDriver webdriver, String nomeEvidencia) throws Exception {
		TakesScreenshot screenShot =((TakesScreenshot)webdriver);
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		
		File SrcFile = screenShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(evidenciasPath+nomeEvidencia+"("+timeStamp+").png");
		
		FileUtils.copyFile(SrcFile, DestFile);
	}

}
