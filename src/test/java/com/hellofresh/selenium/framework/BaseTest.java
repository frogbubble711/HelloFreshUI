package com.hellofresh.selenium.framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hellofresh.pages.CheckOutPage;
import com.hellofresh.pages.LogInPage;
import com.hellofresh.pages.SignInPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest {

	private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
	private static final String BREAK_LINE = "\n";

	public static ExtentTest test;
	public static ExtentReports extent;

	protected SignInPage signInPage;
	protected LogInPage logInPage;
	protected CheckOutPage checkOutPage;
	protected String browserType;
	protected String applicationUrl;
	private WebDriver driver;

	enum DriverType {
		Firefox, IE, Chrome
	}

	public BaseTest(String browser) {
		this.browserType = browser;
	}

	@BeforeSuite
	public void before() {
		extent = new ExtentReports("target/surefire-reports/ExtentReport.html", true);
	}

	@BeforeMethod
	public void setUp(Method method) throws Exception {

		if (browserType == null) {
			browserType = Utilities.readApplicationFile("Browser");
		}
		test = extent.startTest(method.getName(), this.getClass().getName());
		test.assignAuthor("HelloFresh");
		test.assignCategory(this.getClass().getSimpleName());
		this.applicationUrl = Utilities.readApplicationFile("URL");

		if (DriverType.Firefox.toString().toLowerCase().equals(browserType.toLowerCase())) {
			System.setProperty("webdriver.gecko.driver",
					Utilities.getPath() + "/src//test//resources//webdriver/geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (DriverType.IE.toString().toLowerCase().equals(browserType.toLowerCase())) {
			System.setProperty("webdriver.ie.driver",
					Utilities.getPath() + "/src/test/resources/webdrivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else if (DriverType.Chrome.toString().toLowerCase().equals(browserType.toLowerCase())) {
			System.setProperty("webdriver.chrome.driver",
					Utilities.getPath() + "/src/test/resources/webdrivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			throw new Exception("Please pass valid browser type value");
		}

		/* Delete cookies */
		driver.manage().deleteAllCookies();

		/* maximize the browser */
		getWebDriver().manage().window().maximize();

		/* open application URL */
		getWebDriver().navigate().to(applicationUrl);

		signInPage = PageFactory.initElements(driver, SignInPage.class);
		logInPage = PageFactory.initElements(driver, LogInPage.class);
		checkOutPage = PageFactory.initElements(driver, CheckOutPage.class);

	}

	@AfterMethod
	public void captureScreenShot(ITestResult result) throws IOException, InterruptedException {
		if (result.getStatus() == ITestResult.FAILURE) {
			captureScreenshot(result);
		}

		driver.quit();
		extent.endTest(test);

	}

	@AfterClass
	public void afterMainMethod() {
		driver.quit();
	}

	@AfterSuite
	public void tearDownSuite() {		
		extent.flush();
		extent.close();
	}

	/* Return WebDriver */
	public WebDriver getWebDriver() {
		return driver;
	}

	/* Report logs */
	public void reportLog(String message) {
		test.log(LogStatus.PASS, message);
		message = BREAK_LINE + message;
		logger.info("Message: " + message);
		Reporter.log(message);
	}

	/* capturing screenshot */
	public void captureScreenshot(ITestResult result) throws IOException, InterruptedException {
		try {
			String screenshotName = Utilities.getFileName(result.getName());
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String path = Utilities.getPath();
			String screen = path + "/screenshots/" + screenshotName + ".png";
			File screenshotLocation = new File(screen);
			FileUtils.copyFile(screenshot, screenshotLocation);
			Thread.sleep(2000);
			InputStream is = new FileInputStream(screenshotLocation);
			byte[] imageBytes = IOUtils.toByteArray(is);
			Thread.sleep(2000);
			String base64 = Base64.getEncoder().encodeToString(imageBytes);
			test.log(LogStatus.FAIL, result.getThrowable() + " \n Snapshot below: "
					+ test.addBase64ScreenShot("data:image/png;base64," + base64));
			Reporter.log(
					"<a href= '" + screen + "'target='_blank' ><img src='" + screen + "'>" + screenshotName + "</a>");
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

}
