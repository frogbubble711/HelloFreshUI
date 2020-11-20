package com.hellofresh.selenium.framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.Random;

public class Utilities {

	static String path = getPath();

	/**
	 * Get absolute path
	 * 
	 * @return
	 */
	public static String getPath() {
		String path = "";
		File file = new File("");
		String absolutePathOfFirstFile = file.getAbsolutePath();
		path = absolutePathOfFirstFile.replaceAll("\\\\", "/");
		return path;
	}

	// Read application file

	public static String readApplicationFile(String key) throws Exception {
		String value = "";
		try {
			Properties prop = new Properties();
			File src = new File(path + "/src/test/resources/TestData/test.properties");
			if (src.exists()) {
				prop.load(new FileInputStream(src));
				value = prop.getProperty(key);
			} else {
				throw new Exception("File not found");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		if (value == null) {
			throw new Exception("Key not found in properties file");

		}
		return value;

	}
	
	/**
	 * Get random string
	 * 
	 * @param len
	 * @return
	 */
	public static String randomString(int len) {
		String AB = "abcdefghijklnopqrstuvwxyz";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		return sb.toString();
	}
	
	/**
	 * Get random string
	 * 
	 * @param len
	 * @return
	 */
	public static String randomNumber(int len) {
		String AB = "0123456789";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		return sb.toString();
	}
	
	/**
	 * 
	 * @param file
	 * @return
	 */
	public static String getFileName(String file) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
		Calendar cal = Calendar.getInstance();
		String fileName = file + dateFormat.format(cal.getTime());
		return fileName;
	}
}
