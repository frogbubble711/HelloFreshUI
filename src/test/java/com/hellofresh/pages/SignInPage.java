package com.hellofresh.pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.hellofresh.selenium.framework.BasePage;

public class SignInPage extends BasePage {

	public SignInPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.CLASS_NAME, using = "login")
	protected WebElement signIn;

	@FindBy(how = How.ID, using = "email_create")
	private WebElement emailAddress;

	@FindBy(how = How.ID, using = "SubmitCreate")
	private WebElement createAnAccount;

	@FindBy(how = How.ID, using = "id_gender2")
	private WebElement title;

	@FindBy(how = How.ID, using = "customer_firstname")
	private WebElement firstName;

	@FindBy(how = How.ID, using = "customer_lastname")
	private WebElement lastName;

	@FindBy(how = How.ID, using = "passwd")
	private WebElement password;

	@FindBy(how = How.ID, using = "days")
	private WebElement day;

	@FindBy(how = How.ID, using = "months")
	private WebElement month;

	@FindBy(how = How.ID, using = "years")
	private WebElement year;

	@FindBy(how = How.ID, using = "company")
	private WebElement company;

	@FindBy(how = How.ID, using = "address1")
	private WebElement address1;

	@FindBy(how = How.ID, using = "address2")
	private WebElement address2;

	@FindBy(how = How.ID, using = "city")
	private WebElement city;

	@FindBy(how = How.ID, using = "id_state")
	private WebElement state;

	@FindBy(how = How.ID, using = "postcode")
	private WebElement postalCode;

	@FindBy(how = How.ID, using = "other")
	private WebElement additionalInformation;

	@FindBy(how = How.ID, using = "phone")
	private WebElement homePhone;

	@FindBy(how = How.ID, using = "phone_mobile")
	private WebElement mobilePhone;

	@FindBy(how = How.ID, using = "alias")
	private WebElement addressAlias;

	@FindBy(how = How.ID, using = "submitAccount")
	private WebElement register;

	@FindBy(css = "h1")
	protected WebElement heading;

	@FindBy(how = How.CLASS_NAME, using = "account")
	protected WebElement account;

	@FindBy(how = How.CLASS_NAME, using = "info-account")
	protected WebElement accountInformation;

	@FindBy(how = How.CLASS_NAME, using = "logout")
	protected WebElement logoutButton;

	public void clickOnSignIn() {
		waitForElementVisible(signIn);
		clickOn(signIn);
	}

	public String generateEmailAddress() {
		return createEmail();
	}

	public void inputEmail(String text) {
		waitForElement(emailAddress);
		emailAddress.clear();
		emailAddress.sendKeys(text);
	}

	public void clickOnCreateAccount() {
		clickOn(createAnAccount);

	}

	public void clickOnTitle() {
		waitForElementVisible(title);
		clickOn(title);
	}

	public void inputFirstName(String text) {
		waitForElement(firstName);
		firstName.clear();
		firstName.sendKeys(text);
	}

	public void inputLastName(String text) {
		lastName.clear();
		lastName.sendKeys(text);
	}

	public void inputPassword(String text) {
		password.clear();
		password.sendKeys(text);
	}

	public void selectDays(String value) {
		selectByValue(day, value);
	}

	public void selectYear(String value) {
		selectByValue(year, value);
	}

	public void selectMonth(String value) {
		selectByValue(month, value);
	}

	public void inputCompanyName(String text) {
		waitForElement(company);
		company.clear();
		company.sendKeys(text);
	}

	public void inputAddress(String FirstAddress, String SecondAddress) {
		waitForElement(address1);
		address1.clear();
		address1.sendKeys(FirstAddress);
		waitForElement(address2);
		address2.clear();
		address2.sendKeys(FirstAddress);
	}

	public void inputCity(String value) {
		waitForElement(city);
		city.clear();
		city.sendKeys(value);
	}

	public void selectState(String text) {
		selectByVisibleText(state, text);
	}

	public void inputPostalCode(String value) {
		waitForElement(postalCode);
		postalCode.clear();
		postalCode.sendKeys(value);
	}

	public void inputAdditionalInformation(String text) {
		waitForElement(additionalInformation);
		additionalInformation.clear();
		additionalInformation.sendKeys(text);
	}

	public void inputHomePhone(String text) {
		waitForElement(homePhone);
		homePhone.clear();
		homePhone.sendKeys(text);
	}

	public void inputMobilePhone(String text) {
		waitForElement(mobilePhone);
		mobilePhone.clear();
		mobilePhone.sendKeys(text);
	}

	public void inputAddressAlias(String text) {
		waitForElement(addressAlias);
		addressAlias.clear();
		addressAlias.sendKeys(text);
	}

	public void clickOnRegister() {
		clickOn(register);
		waitForPageLoaded();

	}

	public void waitForHeading() {
		waitForElementVisible(heading);
	}

	public void assertPageHeading(String text) {
		waitForElementVisible(heading);
		assertEquals(heading.getText(), text);
	}

	public void assertUserName(String name) {
		waitForElementVisible(account);
		assertEquals(name, account.getText());
	}

	public void assertAccountInformation(String text) {
		Assert.assertTrue(accountInformation.getText().contains(text));
	}

	public void assertLogOutButtonDisplayed() {
		checkForElementDisplayed(logoutButton);

	}

	public void assertCurrentURLText(String text) {
		Assert.assertTrue(driver.getCurrentUrl().contains(text));

	}
}