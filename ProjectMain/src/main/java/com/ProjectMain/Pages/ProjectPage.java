package com.ProjectMain.Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ProjectMain.Utilities.PageUtilities;

public class ProjectPage
{
	WebDriver driver;
	PageUtilities objPage;
	@FindBy(xpath="//span[text()='Projects']")
	WebElement projects;
	@FindBy(xpath="//h1[text()='Projects']")
	WebElement title;
	@FindBy(xpath="//a[@title='Add project']")
	WebElement addproject;
	@FindBy(xpath="//input[@id='title']")
	WebElement addtitle;
	@FindBy(xpath="//span[@id='select2-chosen-6']")
	WebElement addclient;
	@FindBy(xpath="(//input[@class='select2-input'])[4]")
	WebElement clienttext;
	@FindBy(xpath="//textarea[@id='description']")
	WebElement description1;
	@FindBy(xpath="//button[@type='submit']")
	WebElement saveonly;
	@FindBy(xpath="//h4[@id='ajaxModalTitle']")
	WebElement projecttitle;
	@FindBy(xpath="//button[@id='save-and-continue-button']")
	WebElement savecont;
	@FindBy(xpath="(//button[@class='btn-close'])[1]")
	WebElement close;

	public ProjectPage(WebDriver driver) 
	{
		this.driver=driver;
		objPage=new PageUtilities(driver);
		PageFactory.initElements(driver, this);
		
	}
	public void waitFor()
	{
		objPage.implicityWait();
	}
	public void clickProject()
	{
		objPage.waitForElementTobeClickable(projects, 60);
		projects.click();
	}
	public boolean checkProject()
	{
		objPage.waitForElementTobeVisible(title, 60);
		Boolean a=title.isDisplayed();
		return a;
	}
	public void addProject()
	{
		objPage.waitForElementTobeClickable(addproject, 60);
		addproject.click();
	}
	public void setTitle(String title)
	{
		addtitle.sendKeys(title);
	}
	public void setDescription(String description)
	{
		description1.sendKeys(description);
	}
	public void client() throws AWTException
	{
		addclient.click();
		clienttext.sendKeys("ABC");
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	public void saveOnly()
	{
		objPage.waitForElementTobeClickable(saveonly, 60);
		saveonly.click();
	}
	public void saveShow()
	{
		objPage.waitForElementTobeClickable(savecont, 60);
		savecont.click();
    }
	public boolean checkSave()
	{
		objPage.waitForElementTobeVisible(projecttitle, 60);
		Boolean a=projecttitle.isDisplayed();
		return a;
	}
	public void close()
	{
		close.click();
	}
}
