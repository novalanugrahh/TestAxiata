package com.axiatadigitallabs;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.axiatadigitallabs.config.AutomationFrameworkConfiguration;
import com.axiatadigitallabs.driver.DriverSingleton;
import com.axiatadigitallabs.pages.HomePage;
import com.axiatadigitallabs.pages.LoginPage;
import com.axiatadigitallabs.pages.LogoutPage;
import com.axiatadigitallabs.pages.gist.CreateGistPage;
import com.axiatadigitallabs.pages.gist.DeleteGistPage;
import com.axiatadigitallabs.pages.gist.EditGistPage;
import com.axiatadigitallabs.pages.gist.ListOfGistsPage;
import com.axiatadigitallabs.utils.ConfigurationProperties;
import com.axiatadigitallabs.utils.Constants;

@ContextConfiguration(classes = AutomationFrameworkConfiguration.class)
public class TestGitGithub extends AbstractTestNGSpringContextTests{
	private WebDriver driver;
	private LoginPage login;
	private HomePage home;
	private CreateGistPage creategist;
	private ListOfGistsPage seelist;
	private DeleteGistPage delete;
	private EditGistPage edit;
	private LogoutPage logout;

	@Autowired
	ConfigurationProperties configurationProperties;
	
	@BeforeSuite
	public void setup() {
		System.out.println("Test Begin!...");
	}
	
	@Test(priority = 0)
	public void As_a_User_I_want_to_login_to_gistgithub_com() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());
		driver = DriverSingleton.getDriver();
		driver.get(Constants.URL);
		
		login = new LoginPage();
		login.intoSignin(configurationProperties.getUsername(), configurationProperties.getPassword());
		
		
		assertEquals(login.getTextAfterLogin(), 
				configurationProperties.getTextafterLogin());
	}
	
	@Test(priority = 1)
	public void As_a_User_I_want_to_create_a_gist () {
		home = new HomePage();
		home.addGist();
		
		creategist = new CreateGistPage();		
		creategist.creatingGist(configurationProperties.getDescriptionGist(),
				configurationProperties.getFilegist(), configurationProperties.getCodeGist());
		
		assertEquals(creategist.getTextAfterCreate(), configurationProperties.getDescriptionGist());
	}
	
	@Test(priority = 2)
	public void As_a_User_I_want_to_see_the_list_of_gists() {
		seelist = new ListOfGistsPage();
		seelist.seeList();
		
		assertEquals(seelist.getTextAfterSeeList(), configurationProperties.getTextAfterSeeList());
	}
	
	@Test(priority = 3)
	public void As_a_User_I_want_to_delete_a_gist() {
		seelist = new ListOfGistsPage();
		seelist.chooseGist();
		
		delete = new DeleteGistPage();
		delete.delete();
		
		assertEquals(delete.getTextAfterDelete(), configurationProperties.getTextAfterDelete());
	}
	
	@Test(priority =  4)
	public void As_a_User_I_want_to_edit_a_gist() {
		home = new HomePage();
		home.addGist();
		
		creategist = new CreateGistPage();		
		creategist.creatingGist(configurationProperties.getDescriptionGist(),
				configurationProperties.getFilegist(), configurationProperties.getCodeGist());
		
		edit = new EditGistPage();
		edit.editGist(configurationProperties.getEditDescriptionGist(), configurationProperties.getEditfilegist(), 
				configurationProperties.getEditCodeGist());
		assertEquals(edit.getTextAfterEdit(), configurationProperties.getEditDescriptionGist());
	}
	
	@Test(priority = 5)
	public void As_a_User_I_want_to_logout_from_gist_github_com() {
		logout = new LogoutPage();
		logout.signout();
		
		assertEquals(logout.getTextAfterLogout(), configurationProperties.getTextAfterLogout());
	}
	
	@AfterSuite
	public void end() {
		driver.quit();
		System.out.println("End of this test\nThank you!");
	}
}