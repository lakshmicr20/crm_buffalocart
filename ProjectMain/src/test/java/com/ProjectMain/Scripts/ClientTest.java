package com.ProjectMain.Scripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.ProjectMain.Pages.ClientPage;


public class ClientTest extends TestBase
{
	ClientPage objclient;
  @Test(priority=12)
  public void overviewCheck() throws InterruptedException 
  {
	  objclient=new ClientPage(driver);
	  objclient.clientView();
	  
	  objclient.overview();
	  Boolean b=objclient.checkTotal();
	  SoftAssert obj1= new SoftAssert();
	  obj1.assertTrue(b);
	  obj1.assertAll();
  }
  @Test(priority=13)
  public void editClient()
  {
	  objclient=new ClientPage(driver);
	  objclient.client1();
	  Boolean b=objclient.editClient();
	  objclient.closeEdit();
	  SoftAssert obj1= new SoftAssert();
	  obj1.assertTrue(b);
	  obj1.assertAll();
  }
  @Test(priority=14)
  public void checkImportClient()
  { 
	  objclient=new ClientPage(driver);
	  objclient.importClient();
	  Boolean b=objclient.checkImport();
	  
	  objclient.closeImport();
	  SoftAssert obj1= new SoftAssert();
	  obj1.assertTrue(b);
	  obj1.assertAll();
  }
}
