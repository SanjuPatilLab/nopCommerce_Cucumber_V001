package utilities;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {

	public WebDriver utldriver;
	
	public WaitHelper(WebDriver driver) {
		
		this.utldriver=driver;
	}
	
	public void WaitForElement(WebElement element,long time) {
		
		WebDriverWait wait = new WebDriverWait(utldriver, Duration.ofSeconds(time));
		wait.ignoring(NoSuchElementException.class).until(ExpectedConditions.visibilityOf(element));
		
		
	}
	
	
	
	
}
