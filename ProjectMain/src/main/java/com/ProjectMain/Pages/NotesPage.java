package com.ProjectMain.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ProjectMain.Utilities.PageUtilities;
import com.ProjectMain.Utilities.WaitUtilities;

public class NotesPage 
{
	WebDriver driver;
	WaitUtilities objWait;
	PageUtilities objPage;
	@FindBy(xpath="//span[text()='Notes']")
	WebElement notes ;
	@FindBy(xpath="//h1[text()=' Notes (Private)']")
	WebElement checknote;
	@FindBy(xpath="(//a[@title='Add note'])[2]")
	WebElement addnote;
	@FindBy(xpath="//h4[@id='ajaxModalTitle']")
	WebElement checkAddNote;
	@FindBy(xpath="(//button[@class='btn-close'])[1]")
	WebElement closeAddNote;
	@FindBy(xpath="//input[@type='search']")
	WebElement search;
	@FindBy(xpath="//a[@title='Note']")
	WebElement checksearch;
	

	public NotesPage(WebDriver driver) 
	{
		this.driver=driver;
		objWait=new WaitUtilities(driver);
		objPage=new PageUtilities(driver);
		PageFactory.initElements(driver, this);
		
	}
	public void clickNote()
	{
		notes.click();
	}
	public boolean checkNote()
	{
		objWait.waitForElementTobeVisible(checknote, 60);
		Boolean s=checknote.isDisplayed();
		return s;
	}
	public void clickAddNote()
	{
		addnote.click();
	}
	public boolean checkAddNote()
	{
		objWait.waitForElementTobeVisible(checkAddNote, 60);
		Boolean s=checkAddNote.isDisplayed();
		return s;
	}
	public void closeEditWindow()
	{
		closeAddNote.click();
	}
	public void search()
	{
		search.sendKeys("to do");
		objPage.hitenter(search);		
	}
	public boolean checkSearch()
	{
		objWait.waitForElementTobeVisible(checksearch, 60);
		Boolean b=checksearch.isDisplayed();
		return b;
	}
	public void waitNote()
	{
		objWait.waitForElementTobeVisible(search, 60);
	}
}
