package seleniumAssignments;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OrangeHRP_StepDefinition {
	OrangeHrpPages OrangeOR;
	WebDriver Driver;
	
	@Given("When I am in OrangeHRP Application")
	public void whenIaminOrangeHRPApplication() {
		System.setProperty("webdriver.chrome.driver", "C:\\Soft\\JarFiles\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions co = new ChromeOptions();
		Driver 	= new ChromeDriver(co);
		Driver.get("https://opensource-demo.orangehrmlive.com/");
		OrangeOR = new OrangeHrpPages(Driver);
	}

	@Then("Login to Application")
	public void loginToApplication() {
	System.out.println(Driver.getTitle());
	OrangeOR.settextforUserName("Admin");
	OrangeOR.setTextforPassword("admin123");
	OrangeOR.setStaySignedInClick();
	}

	@When("Dashboard page is available")
	public void dashboardPageIsAvailable()  {
	   OrangeOR.getDashBoardisplayed();
	   System.out.println(Driver.getCurrentUrl());
	}

	@When("click on Admin menu")
	public void clickOnAdminMenu()  {
		OrangeOR.settoAdminMenu();
	}

	@Given("I am logged into Orange Application")
	public void iAamLoggedIntoOrangeApplication()  {
		System.out.println(Driver.getTitle());
	}

	@When("I click on Admin Link")
	public void iClickOnAdminLink() {
		OrangeOR.settoAdminMenu();
	}

	@Then("Click on Job")
	public void clickOnJob()  {
		OrangeOR.settoJobMenu();
	    
	}

	@Then("validate text – Job Title")
	public void validateTextJobTitle()  {
		
		OrangeOR.settoJobTitle();
		OrangeOR.getJobTitle();
		
		
	}
	@When("I click on Recruitment")
	public void iClickOnRecruitment()  {
		OrangeOR.settoRecruitment();
	    
	}

	@Then("Click on Vacancies")
	public void clickOnVacancies()  {
	   OrangeOR.settoVacancies();
	}
	
	@When("I click on UserProfile")
	public void iClickOnUserProfile()  {
		OrangeOR.setUserProfile();
	}

	@Then("Click on Logout")
	public void clickOnLogout()  {
	    OrangeOR.setLogout();
	}

	@Then("Close the browser")
	public void closeTheBrowser() {
	Driver.close();
	Driver.quit();
	}


}