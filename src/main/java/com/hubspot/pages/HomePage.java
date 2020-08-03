package com.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.hubspot.base.BasePage;
import com.hubspot.util.Constants;
import com.hubspot.util.ElementUtil;

public class HomePage extends BasePage{
	WebDriver driver;
	ElementUtil elementUtil;
	
	// Locators
	//*[@id='account-menu']/span
	By header = By.xpath("//h1[@class='private-header__heading private-header__heading--solo']");
	By accountName = By.xpath("//div[@class='navAccount-accountName' and text()='Silicone Labs ']");
	By contactMainTab = By.id("nav-primary-contacts-branch");
	By contactcChildTab = By.id("nav-secondary-contacts");

	//Constructor
	public HomePage(WebDriver driver){
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
public String getHomePageTitle(){
	 return elementUtil.waitForGetPageTitle(Constants.HOME_PAGE_TITLE);
	//return driver.getTitle();
}
public String getHomePageHeader(){
	return elementUtil.doGetText(header);
	//return driver.findElement(header).getText();
}
public String verifyLoggedInAccountName(){
	driver.findElement(By.id("account-menu")).click();
	//return elementUtil.doGetText(accountName);
	return driver.findElement(accountName).getText();
}
private void clickOnContacts(){
	elementUtil.doClick(contactMainTab);
	elementUtil.doClick(contactcChildTab);
}
public ContactsPage gotoContactsPage(){
	clickOnContacts();
	
	return new ContactsPage(driver);
}
}
