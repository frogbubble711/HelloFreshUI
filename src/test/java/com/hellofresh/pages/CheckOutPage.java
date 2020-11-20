package com.hellofresh.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.hellofresh.selenium.framework.BasePage;

public class CheckOutPage extends BasePage {

	public CheckOutPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.LINK_TEXT, using = "Women")
	private WebElement womenTitle;

	@FindBy(xpath = "//a[@title='Faded Short Sleeve T-shirts']/ancestor::li")
	private WebElement fadedShort;

	@FindBy(how = How.NAME, using = "Submit")
	private WebElement submitButton;

	@FindBy(xpath = "//*[@id='layer_cart']//a[@class and @title='Proceed to checkout']")
	private WebElement proceedCheckout;

	@FindBy(xpath = "//*[contains(@class,'cart_navigation')]/a[@title='Proceed to checkout']")
	private WebElement finalCheckout;

	@FindBy(how = How.NAME, using = "processAddress")
	private WebElement processAddress;

	@FindBy(how = How.ID, using = "uniform-cgv")
	private WebElement serviceTerms;

	@FindBy(how = How.NAME, using = "processCarrier")
	private WebElement shippingCheckout;

	@FindBy(how = How.CLASS_NAME, using = "bankwire")
	private WebElement bankPayment;

	@FindBy(xpath = "//*[@id='cart_navigation']/button")
	private WebElement orderConfirmation;

	@FindBy(xpath = "//li[@class='step_done step_done_last four']")
	private WebElement shippingSection;

	@FindBy(xpath = "//li[@id='step_end' and @class='step_current last']")
	private WebElement paymentSection;

	@FindBy(xpath = "//*[@class='cheque-indent']/strong")
	private WebElement confirmationText;

	public void clickOnWomenMenuItem() {
		waitForElementVisible(womenTitle);
		clickOn(womenTitle);

	}

	public void clickOnFadedShortSleeves() {
		clickOn(fadedShort);
		waitForPageLoaded();
	}

	public void clickOnSubmit() {
		waitForPageLoaded();
		waitForElementVisible(submitButton);
		clickOn(submitButton);
	}

	public void clickOnProceedCheckOut() {
		waitForPageLoaded();
		waitForElementVisible(proceedCheckout);
		clickOn(proceedCheckout);
	}

	public void clickOnFinalCheckOut() {
		waitForPageLoaded();
		waitForElementVisible(finalCheckout);
		clickOn(finalCheckout);
	}

	public void clickOnProcessAddress() {
		waitForElementVisible(processAddress);
		clickOn(processAddress);
	}

	public void clickOnTermsAndServices() {
		waitForPageLoaded();
		waitForElementVisible(serviceTerms);
		clickOn(serviceTerms);
	}

	public void clickOnShippingCheckout() {
		clickOn(shippingCheckout);
	}

	public void clickOnPaymentByBankWire() {
		waitForElementVisible(bankPayment);
		clickOn(bankPayment);
	}

	public void clickOnOrderConfirmation() {
		waitForElementVisible(orderConfirmation);
		clickOn(orderConfirmation);
		waitForElement(confirmationText);
	}

	public void assertShippingSection() {
		checkForElementDisplayed(shippingSection);
	}

	public void assertPaymentSection() {
		checkForElementDisplayed(paymentSection);
	}

	public void assertOrderConfirmationText(String text) {
		Assert.assertTrue(confirmationText.getText().contains(text));
	}

	public void assertCurrentURLText(String text) {
		Assert.assertTrue(driver.getCurrentUrl().contains(text));

	}
}
