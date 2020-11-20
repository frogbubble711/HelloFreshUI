Repo URL: https://github.com/sayedshabihyder/HelloFreshUI

Added UI test cases in above location.

1. src/test/java: This location contains four packages:

  a) com.hellofresh.challenge: location of all the test scripts.
  
  b) com.hellofresh.pages: Contains seperate page for different functionalities in the application.Pages contains locators (located by using pageFactory (@FindBy)) and method specific to that page.
  
  c) com.hellofresh.report: This package is the container of Extent report files used to generate extent report for the test scripts.You can see extent report "ExtentReport.html" file in "target\surefire-reports" folder.
  
  d) com.hellofresh.selenium.framework: This package contains following java files:
  
    1) BasePage: Contains all the common methods used in framework.
	
	2) BaseTest: Is used to configure test annotations (@Befor and @After),for extent report setting and screenshot facility for failed step in test script.
	
	3)DataProvider: Is used to provide the browser information.
	
	4)GlobalConstant: Is created to store all constant values used in project.
	
	5) Utilities: This contains method like generating random string, reading application file etc.
	
2. src/test/resources: This source folder contains following folders:
   
   a) test_suite: Folder contains suite.xml file.
   
   b) TestData: Contains test.properties file to read application URL, credentials,browser etc.
   
   c) webdriver: Contains drivers exe file (chrome,IE and firefox), to run script on required browser make value true.
   
  Note: Initial test file WebTest.java is not deleted.For checking failed script screenshit please check "screenshots" folder.
