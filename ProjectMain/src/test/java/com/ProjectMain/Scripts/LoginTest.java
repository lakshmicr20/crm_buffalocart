package com.ProjectMain.Scripts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ProjectMain.Constants.Constants;
import com.ProjectMain.Pages.LoginPage;
import com.ProjectMain.Utilities.ExcelRead;

public class LoginTest extends TestBase
{
	LoginPage objLogin;
  @Test(dataProvider= "validUserInvalidPass",priority=1)
  public void verifysigninValidEmailInvalidPassword(String email1,String password1) 
  {
	objLogin=new LoginPage(driver);
	objLogin.setEmail(email1);
	objLogin.setPassword(password1);
	objLogin.clickSignin();

	SoftAssert obj=new SoftAssert();
	obj.assertEquals(driver.getTitle(),Constants.LOGINTITLE1);
	obj.assertAll();
  }
  @Test(dataProvider= "InvalidUserValidPass",priority=2)
  public void verifysigninInvalidEmailValidPassword(String email1,String password1) 
  {
	  objLogin=new LoginPage(driver);
		objLogin.setEmail(email1);
		objLogin.setPassword(password1);
		objLogin.clickSignin();
		
		SoftAssert obj=new SoftAssert();
		obj.assertEquals(driver.getTitle(),Constants.LOGINTITLE1);
		obj.assertAll();
  }
  @Test(dataProvider= "InvalidUserInvalidPass",groups= {"Sanity Test"},priority=3)
  public void verifysigninInvalidEmailInvalidPassword(String email1,String password1) 
  {
	  objLogin=new LoginPage(driver);
		objLogin.setEmail(email1);
		objLogin.setPassword(password1);
		objLogin.clickSignin();
		SoftAssert obj=new SoftAssert();
		obj.assertEquals(driver.getTitle(),Constants.LOGINTITLE1);
		obj.assertAll();
  }
  
  
  @Test(dataProvider= "ValiduserValidPass",groups= {"Sanity Test"},priority=4)
  public void verifysigninValidEmailValidPassword(String email1,String password1) 
  {
	  objLogin=new LoginPage(driver);
		objLogin.setEmail(email1);
		objLogin.setPassword(password1);
		objLogin.clickSignin();	
		SoftAssert obj=new SoftAssert();
		obj.assertEquals(driver.getTitle(),Constants.DASHTITLE);
		obj.assertAll();
  }
   
  @DataProvider
  public Object[][] validUserInvalidPass() throws Exception
  {
		Object[][] data=ExcelRead.getDataFromExcel(Constants.LoginCases, "ValiduserInvalidpass");
		return data;
}
  @DataProvider
  public Object[][] InvalidUserValidPass() throws Exception
  {
		Object[][] data=ExcelRead.getDataFromExcel(Constants.LoginCases, "InvaliduserValidPass");
		return data;
  }
  @DataProvider
  public Object[][] InvalidUserInvalidPass() throws Exception
  {
		Object[][] data=ExcelRead.getDataFromExcel(Constants.LoginCases, "InvaliduserInvalidpass");
		return data;
  }
  @DataProvider
  public Object[][] BlankUser() throws Exception
  {
		Object[][] data=ExcelRead.getDataFromExcel(Constants.LoginCases, "Blank");
		return data;
  }
  @DataProvider
  public Object[][] ValiduserValidPass() throws Exception
  {
		Object[][] data=ExcelRead.getDataFromExcel(Constants.LoginCases, "ValiduserValidpass");
		return data;
  }
}
