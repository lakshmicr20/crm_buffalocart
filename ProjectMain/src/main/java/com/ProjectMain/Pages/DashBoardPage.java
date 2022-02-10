package com.ProjectMain.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ProjectMain.Utilities.PageUtilities;
import com.ProjectMain.Utilities.WaitUtilities;

public class DashBoardPage 
{
	WaitUtilities objWait;
	WebDriver driver;
	@FindBy(xpath="//span[text()='Dashboard']")
	WebElement dashboard ;
	@FindBy(xpath="//span[text()='My open tasks']")
	WebElement opentask;
	@FindBy(xpath="//span[text()='Events today']")
	WebElement events ;
	@FindBy(xpath="//span[text()='New posts']")
	WebElement newpost;
	@FindBy(xpath="//textarea[@id='post_description']")
	WebElement textarea;
	@FindBy(xpath="//button[@type='submit']")
	WebElement post;
	@FindBy(xpath="//a[@id='timecard-clock-out']")
	WebElement clockout;
	@FindBy(xpath="//div[text()='You are currently clocked out']")
	WebElement outmsg;
	@FindBy(xpath="//button[@type='submit']")
	WebElement save;
	@FindBy(xpath="//a[@title='Clock In']")
	WebElement clockin;
	@FindBy(xpath="//a[@class=' nav-link dropdown-toggle']")
	WebElement tick ;
	@FindBy(xpath="//h1[text()= ' To do (Private)']")
	WebElement tickmsg ;
	
	
	public DashBoardPage(WebDriver driver)
	{
		this.driver=driver;
		objWait=new WaitUtilities(driver);
		PageFactory.initElements(driver, this);
	}
	 
	public void dashboard()
	{
		dashboard.click();
	}
	
	public void task()
	{
		opentask.click();
	}
	public void events()
	{
		events.click();
	}
    public void newpost()
    {
    	newpost.click();
    }
    public boolean checkTextarea()
    {
    	objWait.waitForElementTobeVisible(textarea, 60);
    	Boolean b=textarea.isDisplayed();
    	return b;
    }
    public void textarea(String text1)
    {
    	textarea.sendKeys(text1);
    	post.click();
    }
    public void clockOut()
    {
    	objWait.waitForElementTobeClickable(clockout, 90);
    	clockout.click();
    	
    }
    public void save()
    {
    	objWait.waitForElementTobeVisible(save, 60);
    	save.click();
    }
   public boolean outmsg() throws InterruptedException
   {
	   objWait.waitForElementTobeVisible(outmsg, 90);
	   Boolean b=outmsg.isDisplayed();
	   return b;
   }
   public boolean todoList() throws InterruptedException
   {
	   objWait.waitForElementTobeClickable(tick, 90);
	   tick.click();
	   Boolean p= tickmsg.isDisplayed();
	   return p;
	   
   }
   
    public void clockIn()
    {
    	objWait.waitForElementTobeClickable(clockin, 90);
    	clockin.click();
    	objWait.implicityWait();
    }
    
}
