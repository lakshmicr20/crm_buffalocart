package com.ProjectMain.Scripts;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Alert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ProjectMain.Constants.Constants;
import com.ProjectMain.Pages.DashBoardPage;
import com.ProjectMain.Utilities.ExcelRead;
import com.ProjectMain.Utilities.PageUtilities;


public class DashBoardTest extends TestBase
{
	DashBoardPage objDash;
	
  @Test(priority=5,groups= {"Sanity Test"})
  public void checkDash() 
  {
	  objDash=new DashBoardPage(driver);
	  SoftAssert obj1= new SoftAssert();
	  obj1.assertEquals(driver.getTitle(), Constants.DASHTITLE);
	  obj1.assertAll();
  }
  @Test(priority=6,groups= {"Sanity Test"})
  public void checkTask()
  {
	  objDash=new DashBoardPage(driver);
	  objDash.task();
	  SoftAssert obj1= new SoftAssert();
	  obj1.assertEquals(driver.getTitle(), Constants.TASKTITLE);
	  obj1.assertAll();	 
	  objDash.dashboard();
  }
  @Test(priority=7)
  public void checkEvents()
  {
	  objDash=new DashBoardPage(driver);
	 objDash.events();
	 SoftAssert obj1= new SoftAssert();
	  obj1.assertEquals(driver.getTitle(), Constants.EVENTTITLE);
	  obj1.assertAll();	 
	  objDash.dashboard();
  }
  @Test(dataProvider="addpost",priority=8)
  public void postAdd (String text1)
  {
	  objDash=new DashBoardPage(driver);
	  objDash.newpost();
	  boolean b=objDash.checkTextarea();
	  objDash.textarea(text1); 
	  objDash.dashboard();
	  SoftAssert obj1= new SoftAssert();
	  obj1.assertTrue(b);
	  obj1.assertAll();
  }
  @Test(priority=9)
  public void clockOut () throws InterruptedException 
  {
	  objDash=new DashBoardPage(driver);
	  objDash.clockOut();
	  objDash.save();
	  Boolean a=objDash.outmsg();
	  SoftAssert obj1= new SoftAssert();
	  obj1.assertTrue(a);
	  obj1.assertAll();  
	  
  }
  @Test(priority=10)
  public void clockin() throws InterruptedException
  {
	  objDash=new DashBoardPage(driver);
	  objDash.clockIn();
	  Boolean a=objDash.outmsg();
	  SoftAssert obj1= new SoftAssert();
	  obj1.assertTrue(a);
	  obj1.assertAll(); 
  }
  @Test(priority=11)
  public void checkProgress() throws InterruptedException
  {
	  objDash=new DashBoardPage(driver);
	  Boolean a=objDash.todoList();
	  SoftAssert obj1= new SoftAssert();
	  obj1.assertTrue(a);
	  obj1.assertAll();  
  }
		  
  @DataProvider
  public Object[][] addpost() throws InvalidFormatException, IOException, Exception 
  {
		Object[][] data=ExcelRead.getDataFromExcel(Constants.ADDNOTES, "Textarea");
		return data;
}
  
}
