@smoke @TS_1023
Feature: Login function validation

Description: User able to login in to application with valid user name and password

Scenario: Successful Login with Valid Credentials

	Given User able to open any browser 
	And  Put URL and go to login page
	When User able to click my account
	And Validate as its login page
	And User able to take screen Shot of login page
	And User able to use valid <user_name>
	|user_name			|
	|studentttech@gmail.com|
	And User able to put valid <password>
	|password|
	|student123 |
	
	And User able to click submit button
	Then User able to validate Login status
	And User able to take screen Shot of home page
	And close the browser

	# created a feature file but not develop stepdef yet= dry run
	
	