package com.hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.hubspot.base.BasePage;
import com.hubspot.util.ElementUtilPF;

public class LoginPagePF  extends BasePage{
	
	WebDriver driver;
	ElementUtilPF elementUtilPF;
	
	//Page factory concept --> @FindBy
	
	@FindBy(how = How.ID, using = "username")
	@CacheLookup
	WebElement emailId;
	
	@FindBy(how = How.ID, using = "password")
	WebElement password;

	@FindBy(how = How.ID, using = "loginBtn")
	WebElement loginbutton;
	
	public LoginPagePF(WebDriver driver){
		this.driver =driver;
		PageFactory.initElements(driver, this);
		elementUtilPF = new ElementUtilPF(driver);
	}
	public void doLogin(String username,String pwd){
		elementUtilPF.waitForElementPresent(emailId);
		emailId.sendKeys(username);
		password.sendKeys(pwd);
		loginbutton.click();
	}
}













