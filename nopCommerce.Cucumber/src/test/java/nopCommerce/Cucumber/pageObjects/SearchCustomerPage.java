package nopCommerce.Cucumber.pageObjects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class SearchCustomerPage {

	public WebDriver sDriver;
	WaitHelper waitHelper;
	
	public SearchCustomerPage(WebDriver rDriver) {
		
		sDriver = rDriver;
		PageFactory.initElements(sDriver, this);
		
		waitHelper = new WaitHelper(sDriver);
		
	}
	
	@FindBy(how=How.ID,using="SearchEmail")
	@CacheLookup
	WebElement email_txt;
	
	@FindBy(how=How.ID,using="search-customers")
	@CacheLookup
	WebElement search_btn;
	
	@FindBy(how=How.XPATH,using="//table[@id='customers-grid']")
	@CacheLookup 
	WebElement table;
	 
	@FindBy(how=How.XPATH,using="//table[@id='customers-grid']//tbody/tr")
	@CacheLookup
	List<WebElement> table_row;
	
	@FindBy(how=How.XPATH,using="//table[@id='customers-grid']//tbody/tr/td")
	@CacheLookup
	List<WebElement> table_col;
	
	
	public void setEmail(String email) {
		
		
		waitHelper.WaitForElement(email_txt, 30);
		email_txt.clear();
		email_txt.sendKeys(email);
		
	}
	
	public void searchCustomer() {
		
		search_btn.click();
	}
	
	public int getNoOfRows() {
		
		return table_row.size();
		
	}
	
	public int getNoOfCols() {
		
		return table_col.size();
		
	}
	
	public boolean searchCustomerByEmail(String email) {
		
		boolean flag=false;
		
		for(int i= 1; i<=getNoOfRows();i++) {
			
			String emailId = table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[2]")).getText();
			System.out.println(emailId);
			if(emailId.equals(email)) {
				
				flag =true;
				
			}
			
		}
		
		return flag;
	}
	
}
