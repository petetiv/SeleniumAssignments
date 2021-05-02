package seleniumAssignments;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHrpPages {

	WebDriver Driver;

	@FindBy(name = "txtUsername")
	@CacheLookup
	WebElement TextforUserName;

	public void settextforUserName(String UserName) {
		TextforUserName.clear();
		TextforUserName.sendKeys(UserName);
	}

	public boolean gettextforUserName() {
		return TextforUserName.isDisplayed();
	}

	@FindBy(name = "txtPassword")
	@CacheLookup
	WebElement TextforPassword;

	public void setTextforPassword(String Password) {
		TextforPassword.clear();
		TextforPassword.sendKeys(Password);
	}

	public boolean getTextforPassword() {
		return TextforPassword.isDisplayed();
	}

	@FindBy(name = "Submit")
	@CacheLookup
	WebElement StayLogegedIn;

	public void setStaySignedInClick() {
		StayLogegedIn.click();
	}

	public boolean getStaySignedInSelected() {
		return StayLogegedIn.isSelected();
	}

	@FindAll(@FindBy(xpath = "//*[contains(@href,'.com/')]"))
	@CacheLookup
	List<WebElement> AllLinks;

	public List<WebElement> getAllLinks() {

		return AllLinks;
	}

	@FindAll(@FindBy(xpath = "//*[contains(@src,'.png')]"))
	@CacheLookup
	List<WebElement> allImages;

	public List<WebElement> getAllImages() {

		return allImages;
	}

	@FindAll(@FindBy(xpath = "//*[contains(@class,'textInputContainer')]"))
	@CacheLookup
	List<WebElement> alltexBox;

	public List<WebElement> getAllTextbox() {

		return alltexBox;
	}

	@FindBy(id = "content")
	@CacheLookup
	WebElement DashBoardCheck;

	public boolean getDashBoardisplayed() {
		return DashBoardCheck.isDisplayed();
	}

	@FindBy(id = "menu_admin_viewAdminModule")
	@CacheLookup
	WebElement AdminMenu;

	public void settoAdminMenu() {
		AdminMenu.click();
	}

	public boolean gettoAdminMenuSelected() {
		return AdminMenu.isSelected();
	}

	@FindAll(@FindBy(xpath = "//*[contains(@class,'arrow')]"))
	@CacheLookup
	List<WebElement> allItems_AdminMenu;

	public List<WebElement> getAllItems_AdminMenu() {

		return allItems_AdminMenu;
	}

	@FindBy(xpath = "/html/body/div[1]/div[2]/ul/li[1]/ul/li[2]/a")
	@CacheLookup
	WebElement JobMenu;

	public void settoJobMenu() {
		Actions action = new Actions(Driver);
		action.moveToElement(JobMenu).build().perform();
		JobMenu.click();
		// AdminMenu.click();
	}

	public boolean gettoJobMenuSelected() {
		return JobMenu.isSelected();
	}

	@FindBy(xpath = "/html/body/div[1]/div[2]/ul/li[1]/ul/li[2]/ul/li[1]/a")
	@CacheLookup
	WebElement JobTitle;

	public String settoJobTitle() {
		String text;
		JobTitle.click();
		text = JobMenu.getText();
		;
		return text;
	}

	@FindBy(id = "frmList_ohrmListComponent")
	@CacheLookup
	WebElement JobTitleList;

	public void getJobTitle() {

		System.out.println(JobTitleList.getText());
	}

	@FindBy(xpath = "/html/body/div[1]/div[2]/ul/li[5]/a/b")
	@CacheLookup
	WebElement Recruitment;

	public void settoRecruitment() {

		Recruitment.click();
	}

	@FindBy(id = "menu_recruitment_viewJobVacancy")
	@CacheLookup
	WebElement Vacancy;

	public void settoVacancies() {

		Actions action = new Actions(Driver);
		action.moveToElement(Vacancy).build().perform();
		Vacancy.click();
	}

	@FindBy(xpath = "/html/body/div[1]/div[3]/div[1]/div[2]/form/fieldset/p/input[1]")
	@CacheLookup
	WebElement PimSearch;

	public void setPIMSearch() {
		PimSearch.click();
	}

	@FindBy(xpath = "/html/body/div[1]/div[2]/ul/li[2]/a/b")
	@CacheLookup
	WebElement Pim;

	public void setPIM() {
		Pim.click();
	}

	@FindBy(name = "empsearch[employee_name][empName]")
	@CacheLookup
	WebElement TextforEmployeeName;

	public void setTextforEmployeeName(String EmployeeName) {
		TextforEmployeeName.clear();
		TextforEmployeeName.sendKeys(EmployeeName);
	}

	public boolean getTextforEmployeeName() {
		return TextforEmployeeName.isDisplayed();
	}

	@FindBy(xpath = "//*[@id=\"welcome\"]")
	@CacheLookup
	WebElement UserProfile;

	public void setUserProfile() {

		Actions action = new Actions(Driver);
		action.moveToElement(UserProfile).build().perform();
		UserProfile.click();
	}

	@FindBy(xpath = "/html/body/div[1]/div[1]/div[10]/ul/li[2]/a")
	@CacheLookup
	WebElement Logout;

	public void setLogout() {

		Actions action = new Actions(Driver);
		action.moveToElement(Logout).build().perform();
		Logout.click();
	}

	@FindBy(id = "menu_admin_viewAdminModule")
	@CacheLookup
	WebElement AdminLink;

	public void ClickOnAdminLink() {
		AdminLink.click();
	}

	@FindBy(id = "menu_pim_viewPimModule")
	@CacheLookup
	WebElement PIMLink;

	public void ClickOnPIMLink() {
		PIMLink.click();
	}

	@FindBy(id = "menu_dashboard_index")
	@CacheLookup
	WebElement DashBoardLink;

	public void ClickOnDashBoardLink() {
		DashBoardLink.click();
	}

	@FindBy(id = "menu_maintenance_purgeEmployee")
	@CacheLookup
	WebElement MaintenanceLink;

	public void ClickOnMaintenanceLink() {
		MaintenanceLink.click();
	}

	@FindBy(id = "menu_directory_viewDirectory")
	@CacheLookup
	WebElement DirectoryLink;

	@FindBy(xpath = "//*[@id=\"content\"]/div/div[1]/h1")
	WebElement DashBoardHeader;

	public String GetDashBoardHeaderText() {
		return DashBoardHeader.getText();
	}

	public OrangeHrpPages(WebDriver Driver) {
		this.Driver = Driver;
		PageFactory.initElements(Driver, this);
	}

}