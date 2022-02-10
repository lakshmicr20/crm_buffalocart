package com.ProjectMain.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver driver;
	@FindBy(xpath="//input[@id='email']")
	WebElement email;
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	@FindBy(xpath="//button[text()='Sign in']")
	WebElement signin;
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void setEmail(String email1)
	{
		email.sendKeys(email1);
	}
	public void setPassword(String password1)
	{
		password.sendKeys(password1);
	}
	public void clickSignin()
	{
		signin.click();
	}
	public void toClear()
	{
		email.clear();
		password.clear();
	}
	
	public String getHomepageTitle()
	{
		String title=driver.getTitle();
		return title;
	}

	
}
