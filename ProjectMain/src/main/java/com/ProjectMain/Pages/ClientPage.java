package com.ProjectMain.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.ProjectMain.Utilities.PageUtilities;
import com.ProjectMain.Utilities.WaitUtilities;


public class ClientPage 
{
	WaitUtilities objWait;
	WebDriver driver;
	@FindBy(xpath="//span[text()='Clients']")
	WebElement client;
	@FindBy(xpath="//a[text()='Overview']")
	WebElement overview;
	@FindBy(xpath="//span[text()='Total clients']")
	WebElement totalclients;
	@FindBy(xpath="//a[@title='Add client']")
	WebElement addclient;
	@FindBy(xpath="//input[@id='company_name']")
	WebElement company;
	@FindBy(xpath="//textarea[@id='address']")
	WebElement address;
	@FindBy(xpath="//input[@id='city']")
	WebElement city;
	@FindBy(xpath="//button[@type='submit']")
	WebElement save;
	@FindBy(xpath="//a[text()='Contacts']")
	WebElement contacts;
	@FindBy(xpath="//a[text()='a a ']")
	WebElement cont1;
	@FindBy(xpath="//a[@title='Edit client']")
	WebElement edit;
	@FindBy(xpath="//h4[@id='ajaxModalTitle']")
	WebElement editCheck;
	@FindBy(xpath="(//button[@class='btn btn-default'])[1]")
	WebElement closeedit;
	@FindBy(xpath="//input[@type='search']")
	WebElement search;
	@FindBy(xpath="//a[text()='ABC PVT LTD']")
	WebElement searchresult;
	@FindBy(xpath="//a[text()='Clients']")
	WebElement client1;
	@FindBy(xpath="//a[@title='Import clients']")
	WebElement importClient;
	@FindBy(xpath="//h4[@id='ajaxModalTitle']")
	WebElement importClientTitle;
	@FindBy(xpath="//div[@id='file-upload-dropzone']")
	WebElement upload;
	@FindBy(xpath="(//button[@class='btn-close'])[1]")
	WebElement closeTab;
	
	public ClientPage(WebDriver driver) 
	{
		this.driver=driver;
		objWait=new WaitUtilities(driver);
		PageFactory.initElements(driver, this);
		
	}
	public void clientView()
	{
		
		client.click();
	}
     public void overview()
     {
    	 objWait.waitForElementTobeVisible(overview, 60);
    	overview.click();
     }
     public boolean checkTotal()
     {
    	 Boolean a=totalclients.isDisplayed();
    	 return a;   	 
     }
     
     public void addclient()
     {
    	 objWait.waitForElementTobeVisible(addclient, 60);
    	 addclient.click();
     }
     public void clientDetails()
     {
    	 objWait.waitForElementTobeVisible(company, 60);
    	 company.sendKeys("ABC PRIVATE LTD");
    	 address.sendKeys("ERNAKULAM,PIN 456789");
    	 city.sendKeys("COCHIN");
    	    	 
     }
     public void save() throws InterruptedException
     {
    	 objWait.waitForElementTobeClickable(save, 60);
    	 save.click();
    	
     }
     public boolean search()
     {
        search.sendKeys("ABC PVT LTD");
        Boolean b=searchresult.isDisplayed();
        return b;
     }
     
     public void contact()
     { 
    	 objWait.waitForElementTobeClickable(contacts, 60);
    	 contacts.click();
    	
     }
     public boolean checkContact()
     {
    	 objWait.waitForElementTobeVisible(cont1, 60);
    	 Boolean a=cont1.isDisplayed();
    	 return a;   	 
     }
     public boolean editClient()
     {
         edit.click();
         objWait.waitForElementTobeVisible(editCheck, 90);
         Boolean b=editCheck.isDisplayed();
         return b;        
     }
     public void closeEdit()
     {
    	 closeedit.click();
     }
     public void client1()
     {
    	 client1.click();
     }
     public void importClient()
     {
    	 importClient.click();
     }
     public boolean checkImport()
     {
    	 objWait.waitForElementTobeVisible(importClientTitle, 60);
    	 Boolean b=importClientTitle.isDisplayed();
    	 return b;
     }
     public void uploadFile()
     {
    	 
    	 upload.sendKeys("C:\\Users\\Sudheesh\\Desktop\\Capture.JPG");
     }
     public void closeImport()
     {
    	 objWait.waitForElementTobeVisible(upload, 60);
    	 closeTab.click();
     }
}
