package com.hellofresh.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.hellofresh.selenium.framework.BasePage;

public class LogInPage extends BasePage {

	public LogInPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.ID, using = "email")
	private WebElement email;

	@FindBy(how = How.ID, using = "passwd")
	private WebElement password;

	@FindBy(how = How.ID, using = "SubmitLogin")
	private WebElement signInButton;

	@FindBy(css = "h1")
	private WebElement heading;

	@FindBy(how = How.CLASS_NAME, using = "account")
	private WebElement account;

	@FindBy(how = How.CLASS_NAME, using = "info-account")
	private WebElement accountInformation;

	public void inputEmailAddress(String value) {
		waitForElement(email);
		email.clear();
		email.sendKeys(value);
	}

	public void inputPassword(String text) {
		waitForElement(password);
		password.clear();
		password.sendKeys(text);
	}

	public void clickOnLogIn(){
		waitAndClick(signInButton);
		waitForElement(accountInformation);
		waitForPageLoaded();
	}

}
