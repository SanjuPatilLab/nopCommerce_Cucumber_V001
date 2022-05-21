package nopCommerce.Cucumber.pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {

	public WebDriver lDriver;
	
	public LoginPage(WebDriver rDriver){
		
		lDriver=rDriver;
		PageFactory.initElements(rDriver, this);
		
	}
	
	@FindBy(id="Email")
	@CacheLookup
	WebElement txt_Email;
	
	@FindBy(id="Password")
	@CacheLookup
	WebElement txt_Password;
	
	@FindBy(xpath="//button[@class='button-1 login-button']")
	@CacheLookup
	WebElement btn_Login;
	
	@FindBy(xpath = "//a[@href='/logout']")
	@CacheLookup
	WebElement lnk_Logout;
	
	public void setUserEmail(String userEmail) {
		
		txt_Email.clear();
		txt_Email.sendKeys(userEmail);
		
	}
	
	public void setPassword(String password) {
		txt_Password.clear();
		txt_Password.sendKeys(password);
	}
	
	public void loginSubmit() {
		
		btn_Login.click();
	}
	
	public void logout() {
		
		jsClick(lnk_Logout);
		
	}
	
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	
	public WebElement waitForEleClickable(WebElement ele) {
		
		WebDriverWait wait = new WebDriverWait(lDriver, Duration.ofSeconds(5));
		
		return wait.ignoring(NoSuchElementException.class).until(ExpectedConditions.elementToBeClickable(ele));
		
	}
	
	public void jsClick(WebElement element) {
		
		JavascriptExecutor js = (JavascriptExecutor)lDriver;
		
		js.executeScript("arguments[0].click();", element);
		
		
	}
	
}
