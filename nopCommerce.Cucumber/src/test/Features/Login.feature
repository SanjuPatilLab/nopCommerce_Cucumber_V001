Feature: Login
  
  Scenario: Successful Login with valid Credentials
    Given User Launch Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on the Log out link
    Then Page Title should be "Your store. Login"
    

  
	Scenario Outline: Login Data driven
		Given User Launch Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "<email>" and Password as "<password>"
    And Click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on the Log out link
    Then Page Title should be "Your store. Login"
    
    
    Examples:
    |email|password|
    |admin@yourstore.com|admin|
    |admin@yourstore.com|admin_01|
	