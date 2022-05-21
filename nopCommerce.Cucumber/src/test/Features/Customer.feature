Feature: Customers
 

	Background: common steps 
		Given User Launch Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then User can view Dashboard
    When User click on customers Menu


  Scenario: Add a new Customer
    And Click on Add new button
    Then User can view Add new customer page
    When User enter customer info
    And Click on Save button
    Then User can view confirmation message "× The new customer has been added successfully."
  

  Scenario: Search Customer by EmailID
  	And Enter customer Email
    When Click on search button
    Then User should found Email in the Search table
    