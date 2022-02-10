package com.ProjectMain.Scripts;

import java.awt.AWTException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ProjectMain.Constants.Constants;
import com.ProjectMain.Pages.TaskPage;
import com.ProjectMain.Utilities.ExcelRead;

public class TaskTest extends TestBase 
{
	TaskPage objTask;
  @Test(priority=15)
  public void checkList() throws InterruptedException 
  {
	objTask=new TaskPage(driver);
	objTask.clickTask();	
	objTask.clickList();
	Boolean b=objTask.checkSample();
	  SoftAssert obj1= new SoftAssert();
	  obj1.assertTrue(b);
	  obj1.assertAll();
	
  }
  @Test(priority=16)
  public void checkKanban() throws InterruptedException 
  {
	objTask=new TaskPage(driver);
	objTask.clickKanban();
	

	Boolean b=objTask.checkKanban();
	  SoftAssert obj1= new SoftAssert();
	  obj1.assertTrue(b);
	  obj1.assertAll();
	
  }
  @Test(priority=17)
  public void checkGantt() throws InterruptedException 
  {
	objTask=new TaskPage(driver);
	objTask.clickGantt();
	
	Boolean b=objTask.checkgantt();
	  SoftAssert obj1= new SoftAssert();
	  obj1.assertTrue(b);
	  obj1.assertAll();
	
  }
  @Test(dataProvider= "titleDescription",priority=18)
  public void checkAddTask(String title, String description) throws InterruptedException, AWTException 
  {
	objTask=new TaskPage(driver);
	objTask.clickTask();
	
	objTask.addtask();
	
	  
	objTask.setTitle(title);
	
	objTask.setDescription(description);
	
	objTask.project();
	
	objTask.saveOnly();
	Boolean b=objTask.taskTitle();
	 SoftAssert obj1= new SoftAssert();
	  obj1.assertTrue(b);
	obj1.assertAll();
	
  }
  @Test(dataProvider= "titleDescription",priority=19)
  public void checkSaveTask(String title, String description) throws AWTException, InterruptedException 
  {
	objTask=new TaskPage(driver);
	Thread.sleep(3000);
	objTask.addtask();
	objTask.setTitle(title);
	objTask.setDescription(description);
	objTask.project();
	objTask.saveShow();
	Boolean b=objTask.checkSave();
	  SoftAssert obj1= new SoftAssert();
	  obj1.assertTrue(b);
	  obj1.assertAll();	
	  
	  objTask.close();
  }
  
  @DataProvider
  public Object[][] titleDescription() throws Exception
  {
		Object[][] data=ExcelRead.getDataFromExcel(Constants.ADDTASKS, "titledescription");
		return data;
}
}
