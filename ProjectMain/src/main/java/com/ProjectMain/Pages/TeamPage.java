package com.ProjectMain.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ProjectMain.Utilities.PageUtilities;

public class TeamPage 
{
	WebDriver driver;
	PageUtilities objPage;
	@FindBy(xpath="//span[text()='Team']")
	WebElement team;
	@FindBy(xpath="//span[text()='Team members']")
	WebElement teamMembers;
	@FindBy(xpath="//h1[text()='Team members']")
	WebElement checkTeamMembers;
	@FindBy(xpath="//a[@title='Send invitation']")
	WebElement sendInvite;
	@FindBy(xpath="//input[@name='email[]']")
	WebElement emailfield;
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement send;
	@FindBy(xpath="(//button[@class='btn-close'])[1]")
	WebElement closeSend;
	@FindBy(xpath="//h4[@id='ajaxModalTitle']")
	WebElement inviteText;
	@FindBy(xpath="//span[text()='Leave']")
	WebElement leave;
	@FindBy(xpath="//h1[text()='Leave']")
	WebElement leavesub;
	public TeamPage(WebDriver driver) 
	{
		this.driver=driver;
		objPage=new PageUtilities(driver);
		PageFactory.initElements(driver, this);
		
	}
     public void clickTeam()
     {
    	 team.click(); 	 
     }
     public void clickTeamMembers()
     {
    	 teamMembers.click();
     }
     public boolean checkTeamMembers()
     {
    	 objPage.waitForElementTobeClickable(checkTeamMembers, 60);
    	 Boolean b= checkTeamMembers.isDisplayed();
    	 return b;
     }
     public void clickSend()
     {
    	 objPage.waitForElementTobeVisible(sendInvite, 60);
    	 sendInvite.click();
     }
     public boolean checkInviteText()
     {
    	 objPage.waitForElementTobeVisible(inviteText, 60);
    	 Boolean b=inviteText.isDisplayed();
    	 return b;
     }
     public void checkInvite()
     {
    	 emailfield.sendKeys("xyz@gmail.com");  	
    	 send.click();
     }
     public String errorAlert()
     {
    	 String error=objPage.catchAlert();
    	 return error;
     }
     public void closeSend()
     {
    	 objPage.waitForElementTobeClickable(closeSend, 60);
    	 closeSend.click();
     }
     public void clickLeave()
     {
    	 leave.click();
     }
     public boolean checkLeave()
     {
    	 Boolean b=leavesub.isDisplayed();
    	 return b;
     }
     public void toWait()
     {
    	 objPage.waitForElementTobeVisible(team, 60);
     }
}
