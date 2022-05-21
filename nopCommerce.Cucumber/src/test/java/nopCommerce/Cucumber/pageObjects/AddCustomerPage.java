package nopCommerce.Cucumber.pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {

	public WebDriver cDriver;
	
	public AddCustomerPage(WebDriver rDriver) {
		
		cDriver=rDriver;
		PageFactory.initElements(cDriver, this);
		
	}
	
	//DashBoard title
	By dashBoard_txt = By.xpath("//h1[contains(text(),'Dashboard')]");
	
	
	//Customer
	By customer_lnk = By.xpath("//p[contains(text(),'Customers')]/i");
	By customers_option = By.xpath("//a[@href='/Admin/Customer/List']/p[contains(text(),'Customers')]");
	By addCustomer_btn = By.xpath("//a[@href='/Admin/Customer/Create']");
	By customer_txt=By.xpath("//h1[contains(text(),'Customers')]");
	
	//Customer info
	
	By addCustomer_txt = By.xpath("//h1[contains(text(),'Add a new customer')]");
	By email_field = By.id("Email");
	By pwd_field = By.id("Password");
	By fname_field = By.id("FirstName");
	By lname_field = By.id("LastName");
	By male_chkBox = By.id("Gender_Male");
	By female_chkBox = By.id("Gender_Female");
	By dob_field = By.id("DateofBirth");
	By companyName_field = By.id("Company");
	By taxExmpt_chkBox = By.id("IsTaxExempt");
	By newsLetter_dropDown = By.xpath("//ul[@id='SelectedNewsletterSubscriptionStoreIds_taglist']/following-sibling::input");
	By customerRole_dropDown = By.id("SelectedCustomerRoleIds_taglist");
	By managerOfVendor_dropDown = By.id("VendorId");
	By active_chkBox = By.id("Active");
	By comment_txt = By.id("AdminComment");
	
	//Save
	
	By save_btn = By.xpath("//button[@name='save']");
	By saveContinue_btn = By.xpath("//button[@name='save-continue']");
	
	//Successful save alert
	By success_Alert = By.xpath("//div[@class='alert alert-success alert-dismissable']");
	
	public String dashBoardTitle() {
		return cDriver.findElement(dashBoard_txt).getText();
	}
	
	public void customerLink() {
		
		cDriver.findElement(customer_lnk).click();
		
	}
	
	public void customersOption() {
		cDriver.findElement(customers_option).click();
		
	}
	
	public String customerTitle() {
		
		return cDriver.findElement(customer_txt).getText();
	}
	
	public void addCustomer() {
		
		cDriver.findElement(addCustomer_btn).click();
		
	}
	

	public String addCustomerTitle() {
		
		return cDriver.findElement(addCustomer_txt).getText();
	}
	
	public void enterEmail(String email) {
		
		cDriver.findElement(email_field).sendKeys(email);
		
	}
	
	public void enterPassword(String password) {
		
		cDriver.findElement(pwd_field).sendKeys(password);		
	}
	
	public void enterFirstName(String fname) {
		
		cDriver.findElement(fname_field).sendKeys(fname);
	}
		
	public void enterLastName(String lname) {
		
		cDriver.findElement(lname_field).sendKeys(lname);
	}
	
	public void genderCheck(String gender) {
		
		if(gender.equalsIgnoreCase("Male")) {
			
			cDriver.findElement(male_chkBox).click();
		}else if(gender.equalsIgnoreCase("Female")) {
			cDriver.findElement(female_chkBox).click();
			
		}else {
			
			cDriver.findElement(male_chkBox).click();
		}
		
	}
	
	public void enterDOB(String dob) {
		
		jsClick(cDriver.findElement(dob_field));
	    jsSendKeys(cDriver.findElement(dob_field), dob);
	}
	
	public void enterCompanyName(String companyName) {
		
		cDriver.findElement(companyName_field).sendKeys(companyName);
	}
	
	public void selectTaxExcemption(String taxExcempt) {
		
		if(taxExcempt.equalsIgnoreCase("Yes")) {
			cDriver.findElement(taxExmpt_chkBox).click();
			
		}
		
	}
	
	public void enterNewsLetter(String newsLetter) throws InterruptedException {
		
		//jsClick(cDriver.findElement(newsLetter_dropDown));
		jsSendKeys(cDriver.findElement(newsLetter_dropDown), newsLetter);
		
				
		
	}
	
	public void enterCustomerRole(String customerRole) {
		
		cDriver.findElement(customerRole_dropDown).sendKeys(customerRole);
		
	}
	
	public void selectVendorManager(String vendorManager) {
		
		Select manager = new Select(cDriver.findElement(managerOfVendor_dropDown));
		
		manager.selectByVisibleText(vendorManager);
		
	}
	
	public void addComment(String comment) {
		
		cDriver.findElement(comment_txt).sendKeys(comment);
		
	}
	
	public void saveCustomer() {
		cDriver.findElement(save_btn).click();
	}
	
	public String successfulSave() {
		
		return cDriver.findElement(success_Alert).getText();
		
	}
	
	
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	public void jsClick(WebElement element) {
		
		JavascriptExecutor js = (JavascriptExecutor)cDriver;
		
		js.executeScript("arguments[0].click();", element);
		
		
	}
	
	public void jsSendKeys(WebElement dob,String value) {
		
		JavascriptExecutor js = (JavascriptExecutor)cDriver;
		
		js.executeScript("arguments[0].value='"+value+"';",dob);
		
	}
	
}
