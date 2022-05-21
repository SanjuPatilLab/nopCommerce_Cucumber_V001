package nopCommerce.Cucumber.pageObjects;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

public class BaseClass {

	public WebDriver baseDriver;
	
	public Properties configProp;
	
	public static String randomString() {
		
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		
		return generatedString1;
		
	}
	
	
	
}
