@loginpage
Feature: Test the login and Register functions of Mercury Tours application
  
  @userlogin
  Scenario: To test the login functionlity 
  Given user is on the log in page
  When User enters valid user name in username field
  And User enters valid passoword
  When User clicks the login button
  Then login success message is displayed
 # When User enters the correct username
  #When user enters the correct passowrd
 # Then log in success message is displayed