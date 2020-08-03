package com.hubspot.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author marcelavinueza
 *
 */
public class BasePage {
	
	public WebDriver driver;
	public Properties prop;
	public static String flash;
	
	/**
	 * 
	 * @return
	 */
	public WebDriver initialize_driver(Properties prop){
	//String browser = "chrome";
		String browser = prop.getProperty("browser");
		String headles = prop.getProperty("headless");
		flash = prop.getProperty("elementflash");
		if (browser.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			if (headles.equals("yes")) {
				ChromeOptions co = new ChromeOptions();
				co.addArguments("--headless");
				driver = new ChromeDriver(co);
				
			}else{
				driver = new ChromeDriver();
			}	
		}else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			if (headles.equals("yes")) {
				FirefoxOptions fo = new FirefoxOptions();
				fo.addArguments("--headless");
				driver = new FirefoxDriver(fo);
			}else{
			driver = new FirefoxDriver();
			}	
			
		}
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		driver.get("https://app.hubspot.com/login");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		e.printStackTrace();
		}
		return driver;
		
	}
	/**
	 * 
	 * @return
	 */
	public Properties initialize_properties(){
		prop = new Properties();
		
		try {
		FileInputStream ip = new FileInputStream("/Users/marcelavinueza/Documents/workspace/TestNGFramework_2020/"
				+ "src/main/java/config/hubspot/config/config.properties");
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		return prop;
	}
	public void quitBrowser(){
		try {
			driver.quit();
		} catch (Exception e) {
			System.out.println("some exception occured while quitting the browser");
		}
	}
		public void closeBrowser(){
			try {
				driver.close();
			} catch (Exception e) {
				System.out.println("some exception occured while quitting the browser");
			}
		}
	}











