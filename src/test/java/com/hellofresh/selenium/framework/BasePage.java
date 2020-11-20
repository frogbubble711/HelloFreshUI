package com.hellofresh.selenium.framework;

import java.util.Date;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public abstract class BasePage {

	protected WebDriver driver;
	int timeout = 50;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public void waitForElement(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.elementToBeClickable(element));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void waitForPageLoaded() {

		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		Wait<WebDriver> wait = new WebDriverWait(driver, timeout);
		wait.until(expectation);
	}

	

	/**
	 * Wait for the element to be visible
	 * 
	 * @param element
	 */
	public void waitForElementVisible(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * check for the element to be displayed
	 * 
	 * @param element
	 */
	public void checkForElementDisplayed(WebElement element) {
		Assert.assertTrue(element.isDisplayed());
	}

	/**
	 * Providing inputs to the given location
	 * 
	 * @param element
	 * @param text
	 */
	public void inputText(WebElement element, String text) {
		waitForElement(element);
		element.clear();
		element.sendKeys(text);
	}

	/**
	 * Click on an element
	 * 
	 * @param element
	 */
	public void clickOn(WebElement element) {
		element.click();
	}

	public String createTimeStamp() {
		String timeStamp = String.valueOf(new Date().getTime());
		return timeStamp;
	}

	public String createEmail() {
		String timeStampToUse = createTimeStamp();
		String email = "hf_challenge_" + timeStampToUse + "@hf" + timeStampToUse.substring(6) + ".com";
		return email;
	}

	public void selectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public void selectByVisibleText(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

	/**
	 * Click action performed and then wait
	 * 
	 * @param element
	 */
	public void waitAndClick(WebElement element) {
		waitForElement(element);
		element.click();
	}

	public void assertElementText(String text) {
		Assert.assertTrue(driver.getCurrentUrl().contains(text));
	}

}
