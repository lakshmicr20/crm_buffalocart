package com.ProjectMain.Scripts;

import java.awt.AWTException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ProjectMain.Constants.Constants;
import com.ProjectMain.Pages.ProjectPage;
import com.ProjectMain.Pages.TaskPage;
import com.ProjectMain.Utilities.ExcelRead;

public class ProjectTest extends TestBase 
{
 ProjectPage objProject;
  @Test(priority=20)
  public void checkProject() throws InterruptedException 
  {
	  
	  objProject=new ProjectPage(driver);
	  objProject.clickProject();
	  
	 Boolean b= objProject.checkProject();
	  SoftAssert obj1= new SoftAssert();
	  obj1.assertTrue(b);
	  obj1.assertAll();
  }
  @Test(dataProvider="titleDescription",priority=21)
  public void checkAddProject(String title,String description) throws InterruptedException, AWTException
  {
	  objProject=new ProjectPage(driver);
	  objProject.clickProject();
	 
		objProject.addProject();
		Boolean b=objProject.checkSave();
		  SoftAssert obj1= new SoftAssert();
		  obj1.assertTrue(b);
		  obj1.assertAll();	
		objProject.setTitle(title);
		
		objProject.setDescription(description);
		
		objProject.saveOnly();
		 
  }
  @Test(dataProvider="titleDescription",priority=22)
  public void checkSaveProject(String title,String description) throws InterruptedException, AWTException
  {
	  objProject=new ProjectPage(driver);
	   Thread.sleep(3000);
	  objProject.clickProject();
		objProject.addProject();
		objProject.setTitle(title);	
		objProject.setDescription(description);
		objProject.saveShow();	
		Boolean b=objProject.checkSave();
		  SoftAssert obj1= new SoftAssert();
		  obj1.assertTrue(b);
		  obj1.assertAll();	
		  objProject.close();
  }
  
  @DataProvider
  public Object[][] titleDescription() throws Exception
  {
		Object[][] data=ExcelRead.getDataFromExcel(Constants.ADDTASKS, "titledescription");
		return data;
}
  
}
