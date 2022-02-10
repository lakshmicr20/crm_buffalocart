package com.ProjectMain.Scripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ProjectMain.Constants.Constants;
import com.ProjectMain.Pages.TeamPage;

public class TeamTest extends TestBase
{
	TeamPage objTeam;
  @Test(priority=26)
  public void checkTeamMembers() 
  {
	  objTeam=new TeamPage(driver);
	  objTeam.clickTeam();
	  objTeam.clickTeamMembers();  
	  Boolean b=objTeam.checkTeamMembers();
	  SoftAssert obj1= new SoftAssert();
	  obj1.assertTrue(b);
	  obj1.assertAll();
  }
  @Test(priority=27)
  public void sendInvite()
  {
	  objTeam=new TeamPage(driver);
	  objTeam.clickSend();
	  Boolean b=objTeam.checkInviteText();
	  SoftAssert obj1= new SoftAssert();
	  obj1.assertTrue(b);
	  obj1.assertAll();
	  objTeam.closeSend();
  }
  @Test(priority=28)
  public void checkLeave()
  {
	  objTeam=new TeamPage(driver);
	  objTeam.clickTeam();
	  objTeam.clickLeave();
	  Boolean b=objTeam.checkLeave();
	  SoftAssert obj1= new SoftAssert();
	  obj1.assertTrue(b);
	  obj1.assertAll();
	
  }
  
}
