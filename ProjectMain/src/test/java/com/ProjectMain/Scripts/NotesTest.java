package com.ProjectMain.Scripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ProjectMain.Pages.NotesPage;

public class NotesTest extends TestBase
{
	NotesPage objNote;
	
  @Test(priority=23)
  public void checkNote() 
  {
	  objNote=new NotesPage(driver);
	  objNote.clickNote();
	  Boolean b=objNote.checkNote();
	  SoftAssert obj1= new SoftAssert();
	  obj1.assertTrue(b);
	  obj1.assertAll();
  } 
  @Test(priority=24)
  public void checkAddNote()
  {
	  objNote=new NotesPage(driver);
	  objNote.clickAddNote();
	  Boolean b=objNote.checkAddNote();
	  SoftAssert obj1= new SoftAssert();
	  obj1.assertTrue(b);
	  obj1.assertAll();
	  objNote.closeEditWindow();
  }
  @Test(priority=25)
  public void checkSearch()
  {
	  objNote=new NotesPage(driver);
	  objNote.search();
	  Boolean b=objNote.checkSearch();
	  SoftAssert obj1= new SoftAssert();
	  obj1.assertTrue(b);
	  obj1.assertAll();
	  
  }
}
