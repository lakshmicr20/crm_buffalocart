package com.ProjectMain.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ProjectMain.Utilities.PageUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class TaskPage 
{
	WebDriver driver;
	PageUtilities objPage;
	@FindBy(xpath="//span[text()='Tasks']")
	WebElement tasks;
	@FindBy(xpath="//a[text()='List']")
	WebElement list1;
	@FindBy(xpath="//th[text()='Start date']")
	WebElement start;
	@FindBy(xpath="//a[text()='Kanban']")
	WebElement kanban;
	@FindBy(xpath="//div[text()=' To do ']")
	WebElement todo;
	@FindBy(xpath="//a[text()='Gantt']")
	WebElement gantt ;
	@FindBy(xpath="//h4[text()='Gantt']")
	WebElement gantt2;
	@FindBy(xpath="(//a[@title='Add task'])[2]")
	WebElement addtask ;
	@FindBy(xpath="(//input[@id='title'])[4]")
	WebElement addtitle ;
	@FindBy(xpath="//textarea[@id='description']")
	WebElement description1 ;
	@FindBy(xpath="//div[@id='s2id_project_id']")
	WebElement project;
	@FindBy(xpath="(//input[@type='text'])[14]")
	WebElement projecttext;
	@FindBy(xpath="//button[text()=' Save']")
	WebElement save;
	@FindBy(xpath="//button[@id='save-and-show-button']")
	WebElement show;
	@FindBy(xpath="//h4[@id='ajaxModalTitle']")
	WebElement tasktitle;
	@FindBy(xpath="(//button[@class='btn btn-default'])[3]")
	WebElement close;
	
	
	public TaskPage(WebDriver driver) 
	{
		this.driver=driver;
		objPage=new PageUtilities(driver);
		PageFactory.initElements(driver, this);
		
	}
	public void clickTask()
	{
		objPage.waitForElementTobeClickable(tasks, 60);
		tasks.click();
	}
	public void clickList()
	{
		objPage.waitForElementTobeVisible(list1, 60);
		list1.click();
	}
	public boolean checkSample()
	{
		objPage.waitForElementTobeVisible(start, 60);
		Boolean a=start.isDisplayed();
		return a;
	}
	public void clickKanban()
	{
		kanban.click();
	}
	public boolean checkKanban()
	{
		objPage.waitForElementTobeVisible(todo, 60);
		Boolean a=todo.isDisplayed();
		return a;
	}
	public void clickGantt()
	{
		objPage.waitForElementTobeClickable(gantt, 60);
		gantt.click();
	}
	public boolean checkgantt()
	{
		objPage.waitForElementTobeVisible(gantt2,60);
		Boolean a=gantt2.isDisplayed();
		return a;
	}
	public void addtask()
	{
		objPage.implicityWait();
		objPage.waitForElementTobeClickable(addtask, 60);
		addtask.click();
	}
	public void setTitle(String title)
	{
		addtitle.sendKeys(title);
	}
	public void setDescription(String description)
	{
		description1.sendKeys(description);
	}
	public void project() throws AWTException
	{
		objPage.waitForElementTobeClickable(project, 60);
		project.click();
		objPage.implicityWait();
		projecttext.sendKeys("CRM");
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	public void saveOnly()
	{
		objPage.waitForElementTobeClickable(save, 60);
		save.click();
		objPage.implicityWait();
	}
	public void saveShow()
	{
		objPage.waitForElementTobeClickable(show, 60);
		show.click();
	}
	public boolean checkSave()
	{
		objPage.waitForElementTobeVisible(tasktitle, 60);
		Boolean a=tasktitle.isDisplayed();
		return a;
	}
	public void close()
	{
		objPage.waitForElementTobeClickable(close, 60);
		close.click();
	}
	public boolean taskTitle()
	{
		Boolean b=tasktitle.isDisplayed();
		return b;
	}
	public void waitFor()
	{
		objPage.implicityWait();
	}

}
