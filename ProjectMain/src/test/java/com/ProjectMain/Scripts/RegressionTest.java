package com.ProjectMain.Scripts;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.ProjectMain.Pages.NotesPage;
import com.ProjectMain.Pages.TeamPage;


public class RegressionTest extends TestBase
{
	NotesPage objNote;
	TeamPage objTeam;
	@Test(priority=4)
	  public void checkSearch()
	  {
		  objNote=new NotesPage(driver);
		  objNote.waitNote();
		  objNote.search();
		  Boolean b=objNote.checkSearch();
		  SoftAssert obj1= new SoftAssert();
		  obj1.assertTrue(b);
		  obj1.assertAll();
		  
	  }
	 @Test(priority=5)
	  public void checkTeamMembers() 
	  {
		  objTeam=new TeamPage(driver);
		  objTeam.toWait();
		  objTeam.clickTeam();
		  objTeam.clickTeamMembers();  
		  Boolean b=objTeam.checkTeamMembers();
		  SoftAssert obj1= new SoftAssert();
		  obj1.assertTrue(b);
		  obj1.assertAll();
	  }
}
