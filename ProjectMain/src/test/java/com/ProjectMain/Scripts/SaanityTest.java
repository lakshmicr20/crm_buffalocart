package com.ProjectMain.Scripts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ProjectMain.Constants.Constants;
import com.ProjectMain.Pages.LoginPage;
import com.ProjectMain.Pages.NotesPage;
import com.ProjectMain.Utilities.ExcelRead;

public class SaanityTest extends TestBase
{
	NotesPage objNote;
	LoginPage objLogin;
	@Test(dataProvider= "ValiduserValidPass",priority=1)
	  public void verifysigninValidEmailValidPassword(String email1,String password1) 
	  {
		  objLogin=new LoginPage(driver);
		  objLogin.toClear();
			objLogin.setEmail(email1);
			objLogin.setPassword(password1);
			objLogin.clickSignin();	
			SoftAssert obj=new SoftAssert();
			obj.assertEquals(driver.getTitle(),Constants.DASHTITLE);
			obj.assertAll();
	  }
	  @Test(priority=2)
	  public void checkNote() 
	  {
		  objNote=new NotesPage(driver);
		  objNote.clickNote();
		  Boolean b=objNote.checkNote();
		  SoftAssert obj1= new SoftAssert();
		  obj1.assertTrue(b);
		  obj1.assertAll();
	  } 
	  @Test(priority=3)
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
	  @DataProvider
	  public Object[][] ValiduserValidPass() throws Exception
	  {
			Object[][] data=ExcelRead.getDataFromExcel(Constants.LoginCases, "ValiduserValidpass");
			return data;
	  }
}
