package com.hellofresh.challenge;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import com.hellofresh.selenium.framework.BaseTest;
import com.hellofresh.selenium.framework.DataProviders;
import com.hellofresh.selenium.framework.GlobalConstant;
import com.hellofresh.selenium.framework.Utilities;

public class LogIn extends BaseTest {
	
	@Factory(dataProvider = "Config", dataProviderClass = DataProviders.class)
	public LogIn(String browser) {
		super(browser);
	}
	

	@Test
	public void logInTest() throws Exception {

		String exsistingUserEmail = Utilities.readApplicationFile("ExistingUserEmail");
		String exsistingUserPassword = Utilities.readApplicationFile("ExistingUserPassword");
	
		reportLog("click on signIn button");
		signInPage.clickOnSignIn();

		reportLog("input user email");
		logInPage.inputEmailAddress(exsistingUserEmail);
		
		reportLog("input password");
		logInPage.inputPassword(exsistingUserPassword);
		
		reportLog ("click to login to the application");
		logInPage.clickOnLogIn();
		
		reportLog("assert page heading");
		signInPage.assertPageHeading(GlobalConstant.PAGE_HEADING);
		
		reportLog("assert user name");
		signInPage.assertUserName(GlobalConstant.FULLNAME);
		
		reportLog("assert account information");
		signInPage.assertAccountInformation(GlobalConstant.ACCOUNT_INFORMATION);
		
		reportLog("assert logOut button is displayed on page");
		signInPage.assertLogOutButtonDisplayed();
		
		reportLog("assert current URL text");
		signInPage.assertCurrentURLText(GlobalConstant.URL_TEXT);
	}

}
