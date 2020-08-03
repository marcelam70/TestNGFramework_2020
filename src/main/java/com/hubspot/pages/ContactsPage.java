package com.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.hubspot.base.BasePage;
import com.hubspot.util.Constants;
import com.hubspot.util.ElementUtil;


public class ContactsPage extends BasePage {
	WebDriver driver;
	ElementUtil elementUtil;
	
	public ContactsPage(WebDriver driver){
		this.driver= driver;
		elementUtil = new ElementUtil(driver);
	}
	//Locators
	
	By createContactButton = By.xpath("//span[contains(text(),'Create contact')]");
	By email = By.xpath("//input[@name='textInput']");
	By firstName = By.xpath("//input[@data-field='firstname']");
	By lastName = By.xpath("//input[@data-field='lastname']");
	By jobTitle = By.xpath("//input[@data-field='jobtitle']");
    By createcontactFormBtn = By.xpath("//div[@class='private-layer']//li[1]");
 //   By createcontactFormBtn = By.xpath("//span[contains(text(),'Create contact')]");
   
	
public String getContactsPageTitle(){
	return elementUtil.waitForGetPageTitle(Constants.CONTACTS_PAGE_TILTE);
}
public void createNewContact(String emailId,String FN,String LN,String jobTitleVal) throws InterruptedException{
 elementUtil.doClick(createContactButton);
 Thread.sleep(2000);
 
 elementUtil.doSendKeys(email, emailId);
 Thread.sleep(2000);
 
 elementUtil.doSendKeys(firstName, FN);
 Thread.sleep(2000);
 
 elementUtil.doSendKeys(lastName, LN);
 Thread.sleep(2000);
 
 elementUtil.doSendKeys(jobTitle, jobTitleVal);
 Thread.sleep(2000);
 
 elementUtil.doClick(createcontactFormBtn);
 Thread.sleep(1000);
}
}