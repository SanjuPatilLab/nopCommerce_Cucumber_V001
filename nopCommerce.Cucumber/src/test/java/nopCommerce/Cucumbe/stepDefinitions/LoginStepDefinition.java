package nopCommerce.Cucumbe.stepDefinitions;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import nopCommerce.Cucumber.pageObjects.AddCustomerPage;
import nopCommerce.Cucumber.pageObjects.BaseClass;
import nopCommerce.Cucumber.pageObjects.LoginPage;
import nopCommerce.Cucumber.pageObjects.SearchCustomerPage;

public class LoginStepDefinition extends BaseClass {

	
	WebDriver driver;
	LoginPage lp;
	AddCustomerPage cp;
	SearchCustomerPage sp;
	
	@Before
	public void setup() throws IOException {
		
		//Reading config property file
		configProp = new Properties();
		FileInputStream configPropFile = new FileInputStream("config.properties");
		configProp.load(configPropFile);
		
		String browser = configProp.getProperty("browser");
		
		
		switch(browser) {
		
		case "Chrome": WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		break;
			
		case "Edge":WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			break;
			
		case "Firefox":WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			break;
			
			default :	WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			break;
			
		}
		
	}
	
	@Given("^User Launch Chrome browser$")
	public void user_Launch_Chrome_browser() throws Throwable {
		
		lp=new LoginPage(driver);
	}

	@When("^User opens URL \"([^\"]*)\"$")
	public void user_opens_URL(String urlLink) throws Throwable {
		driver.get(urlLink);
	}

	@And("^User enters Email as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
	public void user_enters_Email_as_and_Password_as(String email, String password) throws Throwable {
		lp.setUserEmail(email);
		lp.setPassword(password);
	}

	@And("^Click on Login$")
	public void click_on_Login() throws Throwable {
		lp.loginSubmit();
	}

	@Then("^Page Title should be \"([^\"]*)\"$")
	public void page_Title_should_be(String title) throws Throwable {
		if(driver.getPageSource().contains("Login was unsuccessful")) {
			
			driver.close();
			assertTrue("Login was unsuccessful", false);
			
		}else {
			
			assertEquals(title, driver.getTitle());
		}
	}

	@When("^User click on the Log out link$")
	public void user_click_on_the_Log_out_link() throws Throwable {
		
		lp.logout();
		
	}

	@After
	public void close_browser() throws Throwable {
		 driver.quit();
	}
	
	// Add Customers
	
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
	    
		cp = new AddCustomerPage(driver);
		
		assertEquals("Dashboard", cp.dashBoardTitle());
		
		
	}
	@When("User click on customers Menu")
	public void user_click_on_customers_menu() {
	    
		cp.customerLink();
		cp.customersOption();
		assertEquals("Customers",cp.customerTitle());
		
		
	}
	@And("Click on Add new button")
	public void click_on_add_new_button() {
	    
		cp.addCustomer();
		
		
	}
	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
		assertEquals("Add a new customer back to customer list", cp.addCustomerTitle());
	}
	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
	   
		String userName = randomString();
		String email = userName+"@yourstore.com";
		String pwd = userName;
		
		cp.enterEmail(email);
		cp.enterPassword(pwd);
		cp.enterFirstName("San");
		cp.enterLastName("Test");
		cp.genderCheck("Male");
		//cp.enterDOB("01/02/2012");
		cp.enterCompanyName("TestCompany");
		cp.selectTaxExcemption("Yes");
		cp.enterNewsLetter("Your store name");
		//cp.enterCustomerRole("Vendor");
		cp.selectVendorManager("Vendor 1");
		cp.addComment("Testing with San");
		
	}
	@And("Click on Save button")
	public void click_on_save_button() {
	    
		cp.saveCustomer();
		
	}
	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String message) {
	    
		String successMsgWithSpace = cp.successfulSave();
		
		String successMsg = successMsgWithSpace.replaceAll("\\s", " ");
		
		assertEquals(message, successMsg);
		
	}
	
	@And("Enter customer Email")
	public void enter_customer_email() {
	    sp = new SearchCustomerPage(driver);
	    
	    sp.setEmail("admin@yourStore.com");
	    
	}
	@When("Click on search button")
	public void click_on_search_button() {
	    sp.searchCustomer();
	}
	@Then("User should found Email in the Search table")
	public void user_should_found_email_in_the_search_table() throws Throwable {
	    
		
		assertTrue("Email Id Not Found", sp.searchCustomerByEmail("admin@yourStore.com"));
		
	}

	
}
