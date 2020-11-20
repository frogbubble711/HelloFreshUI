package com.hellofresh.selenium.framework;

public class GlobalConstant {
	
	// data for creating user account
	public static String NAME = "Firstname";
	public static String SURNAME = "Lastname";
	public static String PASSWORD = Utilities.randomString(7);
	public static String DAYS = "1";
	public static String YEAR = "2000";
	public static String MONTH = "1";
	public static String COMPANY_NAME = "Company";
	public static String ADDRESS_ONE = PASSWORD + "," + Utilities.randomNumber(3);
	public static String ADDRESS_TWO = Utilities.randomString(4);
	public static String CITY = PASSWORD;
	public static String STATE = "Colorado";
	public static String POSTALCODE = Utilities.randomNumber(5);
	public static String OTHER = PASSWORD;
	public static String HOME_PHONE = Utilities.randomNumber(11);
	public static String MOBILE_PHONE = Utilities.randomNumber(11);
	public static String ALIAS = Utilities.randomString(2);
	public static String PAGE_HEADING = "MY ACCOUNT";
	public static String URL_TEXT="controller=my-account";
	public static String FULLNAME = "Joe Black";
	public static String ACCOUNT_INFORMATION="Welcome to your account.";
	
	//order confirmation data
	public static String ORDER_CONFIRMATION="ORDER CONFIRMATION";
	public static String ORDER_CONFIRMATION_TEXT="Your order on My Store is complete.";
	public static String ORDER_CONFIRMATION_URL_TEXT="controller=order-confirmation";
	

}
