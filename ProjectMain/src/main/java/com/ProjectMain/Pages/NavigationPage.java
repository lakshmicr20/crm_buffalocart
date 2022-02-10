package com.ProjectMain.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.ProjectMain.Utilities.PageUtilities;

public class NavigationPage 
{
	WebDriver driver;
	PageUtilities objPage;
	
	public NavigationPage(WebDriver driver)
	{
		this.driver=driver;
		objPage=new PageUtilities(driver);
		PageFactory.initElements(driver, this);
	}

	public String currentUrl()
	{
		driver.get("http://buffalocart.com/demo/crm/index.php/dashboard");
		String s=driver.getCurrentUrl();
		return s;
	}
	public String nextUrl()
	{
		driver.navigate().to("http://buffalocart.com/demo/crm/index.php/events");
		String p=driver.getCurrentUrl();
		return p;
	}
	public String checkBackwards()
	{
		driver.navigate().back();
		String q=driver.getCurrentUrl();
		return q;
	}
	public void refreshPage()
	{
		driver.navigate().refresh();
	}
	
}
