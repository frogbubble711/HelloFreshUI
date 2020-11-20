package com.hellofresh.challenge;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import com.hellofresh.selenium.framework.BaseTest;
import com.hellofresh.selenium.framework.DataProviders;
import com.hellofresh.selenium.framework.GlobalConstant;

public class SignIn extends BaseTest {

	@Factory(dataProvider = "Config", dataProviderClass = DataProviders.class)
	public SignIn(String browser) {
		super(browser);
	}

	String email;

	@Test
	public void signInTest() throws InterruptedException {

		reportLog("click on signIn button");
		signInPage.clickOnSignIn();

		reportLog("create random email address");
		email = signInPage.generateEmailAddress();

		reportLog("enter email address");
		signInPage.inputEmail(email);

		reportLog("click on create an account");
		signInPage.clickOnCreateAccount();

		reportLog("click on title");
		signInPage.clickOnTitle();

		reportLog("input first name");
		signInPage.inputFirstName(GlobalConstant.NAME);

		reportLog("input last name");
		signInPage.inputLastName(GlobalConstant.SURNAME);

		reportLog("input password");
		signInPage.inputPassword(GlobalConstant.PASSWORD);

		reportLog("select days");
		signInPage.selectDays(GlobalConstant.DAYS);

		reportLog("select month");
		signInPage.selectMonth(GlobalConstant.MONTH);

		reportLog("select year");
		signInPage.selectYear(GlobalConstant.YEAR);

		reportLog("input company name");
		signInPage.inputCompanyName(GlobalConstant.COMPANY_NAME);

		reportLog("input address");
		signInPage.inputAddress(GlobalConstant.ADDRESS_ONE, GlobalConstant.ADDRESS_TWO);

		reportLog("input city");
		signInPage.inputCity(GlobalConstant.CITY);

		reportLog("select state");
		signInPage.selectState(GlobalConstant.STATE);

		reportLog("input postal code");
		signInPage.inputPostalCode(GlobalConstant.POSTALCODE);

		reportLog("input additional information");
		signInPage.inputAdditionalInformation(GlobalConstant.OTHER);

		reportLog("input home phone");
		signInPage.inputHomePhone(GlobalConstant.HOME_PHONE);

		reportLog("input mobile phone");
		signInPage.inputMobilePhone(GlobalConstant.MOBILE_PHONE);

		reportLog("input address alias");
		signInPage.inputAddressAlias(GlobalConstant.ALIAS);

		reportLog("click on register button");
		signInPage.clickOnRegister();

		reportLog("wait for heading");
		signInPage.waitForHeading();

		reportLog("assert that page heading is displayed");
		signInPage.assertPageHeading(GlobalConstant.PAGE_HEADING);

		reportLog("assert user name");
		signInPage.assertUserName(GlobalConstant.NAME + " " + GlobalConstant.SURNAME);

		reportLog("assert logOut button is displayed on page");
		signInPage.assertLogOutButtonDisplayed();

		reportLog("assert current URL text");
		signInPage.assertCurrentURLText(GlobalConstant.URL_TEXT);

	}

}
