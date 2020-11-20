package com.hellofresh.challenge;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import com.hellofresh.selenium.framework.BaseTest;
import com.hellofresh.selenium.framework.DataProviders;
import com.hellofresh.selenium.framework.GlobalConstant;
import com.hellofresh.selenium.framework.Utilities;

public class Checkout extends BaseTest {

	@Factory(dataProvider = "Config", dataProviderClass = DataProviders.class)
	public Checkout(String browser) {
		super(browser);
	}

	@Test
	public void checkoutTest() throws Exception {

		String exsistingUserEmail = Utilities.readApplicationFile("ExistingUserEmail");
		String exsistingUserPassword = Utilities.readApplicationFile("ExistingUserPassword");

		reportLog("click on signIn button");
		signInPage.clickOnSignIn();

		reportLog("input user email");
		logInPage.inputEmailAddress(exsistingUserEmail);

		reportLog("input password");
		logInPage.inputPassword(exsistingUserPassword);

		reportLog("click to login to the application");
		logInPage.clickOnLogIn();

		reportLog("click on women menu item");
		checkOutPage.clickOnWomenMenuItem();

		reportLog("click on faded short sleeves");
		checkOutPage.clickOnFadedShortSleeves();

		reportLog("click on faded short sleeves again");
		checkOutPage.clickOnFadedShortSleeves();

		reportLog("click on Add Cart button");
		checkOutPage.clickOnSubmit();

		reportLog("click on proceed checkout");
		checkOutPage.clickOnProceedCheckOut();

		reportLog("click on final checkout");
		checkOutPage.clickOnFinalCheckOut();

		reportLog("click on process address to checkout");
		checkOutPage.clickOnProcessAddress();

		reportLog("click on terms and services checkbox");
		checkOutPage.clickOnTermsAndServices();

		reportLog("click on checkout button in shipping section");
		checkOutPage.clickOnShippingCheckout();

		reportLog("click on payment by bank wire");
		checkOutPage.clickOnPaymentByBankWire();

		reportLog("click on order confirmation button");
		checkOutPage.clickOnOrderConfirmation();

		reportLog("assert page heading");
		signInPage.assertPageHeading(GlobalConstant.ORDER_CONFIRMATION);

		reportLog("assert that shipping section is displayed");
		checkOutPage.assertShippingSection();

		reportLog("assert that payment section is displayed");
		checkOutPage.assertPaymentSection();

		reportLog("assert order confirmation text");
		checkOutPage.assertOrderConfirmationText(GlobalConstant.ORDER_CONFIRMATION_TEXT);

		reportLog("assert current Url text");
		checkOutPage.assertCurrentURLText(GlobalConstant.ORDER_CONFIRMATION_URL_TEXT);
	}

}
