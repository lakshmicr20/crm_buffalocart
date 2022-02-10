package com.ProjectMain.Scripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ProjectMain.Pages.TicketPage;

public class TicketTest extends TestBase
{
	TicketPage objTick;
  @Test(priority=29)
  public void checkTicket() 
  {
	  objTick=new TicketPage(driver);
	  objTick.clickTicket();
	  Boolean b=objTick.checkTicket();
	  SoftAssert obj1= new SoftAssert();
	  obj1.assertTrue(b);
	  obj1.assertAll();
  }
  @Test(priority=30)
  public void checkBatch() 
  {
	  objTick=new TicketPage(driver);
	  objTick.clickBatch();;
	  Boolean b=objTick.checkBatch();
	  SoftAssert obj1= new SoftAssert();
	  obj1.assertTrue(b);  
	  obj1.assertAll();
  }
  
  @Test(priority=31)
  public void checkAddTicket()
  {
	  objTick=new TicketPage(driver);
	  objTick.ticketTemplate();
	  objTick.addtemplate();
	  Boolean b=objTick.checkadd();
	  SoftAssert obj1= new SoftAssert();
	  obj1.assertTrue(b);
	  objTick.close();
	  obj1.assertAll();
  }
  
  
}
