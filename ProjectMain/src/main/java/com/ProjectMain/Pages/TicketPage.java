package com.ProjectMain.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ProjectMain.Utilities.PageUtilities;

public class TicketPage 
{
	PageUtilities objPage;
	WebDriver driver;
	@FindBy(xpath="//span[text()='Tickets']")
	WebElement tickets;
	@FindBy(xpath="//h4[text()='Tickets']")
	WebElement checkTickets;
	@FindBy(xpath="(//a[text()=' Batch update'])[2]")
	WebElement batch;
	@FindBy(xpath="//th[@class='batch-update-header text-center']")
	WebElement batchTitle;
	@FindBy(xpath="//a[text()=' Cancel selection']")
	WebElement cancelBatch;
	@FindBy(xpath="//input[@type='radio']")
	List<WebElement> radio;
	@FindBy(xpath="//span[@class='badge bg-success large clickable']")
	WebElement status;
	@FindBy(xpath="//a[@title='Add template']")
	WebElement addtemplate;
	@FindBy(xpath="//h4[@id='ajaxModalTitle']")
	WebElement checkAddTemp ;
	@FindBy(xpath="(//button[@class='btn-close'])[1]")
	WebElement closeTemp;
	@FindBy(xpath="//a[text()='Ticket templates']")
	WebElement tempPage;
	
	public TicketPage(WebDriver driver) 
	{
		this.driver=driver;
		objPage=new PageUtilities(driver);
		PageFactory.initElements(driver, this);
		
	}
	public void clickTicket()
	{ 
		objPage.scroll(tickets);
		objPage.waitForElementTobeClickable(tickets, 60);
		tickets.click();
	}
	public boolean checkTicket()
	{
		objPage.waitForElementTobeVisible(checkTickets, 60);
		Boolean b=checkTickets.isDisplayed();
		return b;
	}
	public void clickBatch()
	{
		batch.click();
	}
	public boolean checkBatch()
	{
		objPage.waitForElementTobeVisible(batchTitle, 60);
		Boolean b=batchTitle.isDisplayed();
		return b;
	}
	public void cancelBatch()
	{
		cancelBatch.click();
	}
	public void statusClose()
	{	
		radio.get(1).click();
	}
	public boolean checkStatus()
	{
		objPage.waitForElementTobeVisible(status, 60);
		Boolean b=status.isDisplayed();
		return b;
	}
	public void addtemplate()
	{
		objPage.waitForElementTobeClickable(addtemplate, 60);
		addtemplate.click();		
	}

	public boolean checkadd()
	{
		objPage.waitForElementTobeVisible(checkAddTemp, 60);
		Boolean b= checkAddTemp.isDisplayed();
		return b;
	}
	public void ticketTemplate()
	{
		objPage.waitForElementTobeClickable(tempPage, 60);
		tempPage.click();
	}
	public void close()
	{
		closeTemp.click();
	}
}
