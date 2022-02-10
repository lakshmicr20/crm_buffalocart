package com.ProjectMain.Scripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ProjectMain.Constants.Constants;
import com.ProjectMain.Pages.NavigationPage;

public class NavigationTest extends TestBase
{
	NavigationPage objNavi;
  @Test(priority=32)
  public void checkNavigate() 
  {
	  objNavi=new NavigationPage(driver);
	  objNavi.refreshPage();
	  objNavi.currentUrl();
	  objNavi.nextUrl();
	  objNavi.checkBackwards();
	  SoftAssert obj1= new SoftAssert();
	  obj1.assertEquals(objNavi.currentUrl(), Constants.Navigation);
	  obj1.assertAll();
	  
  }
}
