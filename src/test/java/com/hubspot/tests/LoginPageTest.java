package com.hubspot.tests;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hubspot.base.BasePage;
import com.hubspot.pages.LoginPage;
import com.hubspot.util.Constants;
@Listeners(com.hubspot.listeners.TestAllureListener.class)
public class LoginPageTest {
	// THIS WORKS GOOD
	Logger log = Logger.getLogger("LoginPageTest");
WebDriver driver;
Properties prop ;
BasePage basePage;
LoginPage loginPage;

@BeforeMethod
public void setUp(){
	basePage = new BasePage();
	log.info("Browser is launching...");
	prop = basePage.initialize_properties();
	driver = basePage.initialize_driver(prop);
	loginPage = new LoginPage(driver);
}
@Test(priority =2,description="Login test using correct username and  correct password")
public void loginTest1(){
	log.info("loginTest1 is starting....");
	loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	log.info("loginTest1 is ending.....");
}

@Test(priority =3,description="Login test using incorrect username and correct password")
public void loginTest2(){
	loginPage.doLogin(prop.getProperty("incorrectuser"),prop.getProperty("password"));
}

@Test(priority =4,description="Login test using incorrect username and  incrorrect password")
public void loginTest3(){
	loginPage.doLogin(prop.getProperty("incorrectuser"),prop.getProperty("incorrectpass"));
}
@Test(priority =1, enabled = true,description="Get title from HubSpot Login page")
public void getTitle(){
	String title = loginPage.getPageTitle();
	System.out.println(title);
	Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE,"title is in-correct");
}

@AfterMethod
public void tearDown(){
	basePage.quitBrowser();
}
}
