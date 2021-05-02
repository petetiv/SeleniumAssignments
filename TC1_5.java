package seleniumAssignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TC1_5 {
	static WebDriver driver;

	// Assignments from 1 to 5
	@Test
	public void loginAndVerification() {

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		String windowTitle = driver.getTitle();
		System.out.println("Window Title: " + windowTitle);

		List<WebElement> allTextBoxes = driver.findElements(
				By.xpath("//div/input[@type='text' or @type='password'][not(contains(@readonly,'readonly'))]"));
		System.out.println("Number of Text Boxes in HomePage Using Xpath: " + allTextBoxes.size());

		List<WebElement> allHyperLinks = driver.findElements(By.xpath("//a"));
		System.out.println("Number of Hyper Links in Home Page Using Xpath: " + allHyperLinks.size());

		List<WebElement> allImages = driver.findElements(By.xpath("//img"));
		System.out.println("Number of Images in Home Page Using Xpath: " + allImages.size());

		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_dashboard_index")));

		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='User Management']")));

		if (driver.findElement(By.id("menu_admin_UserManagement")).getText().equalsIgnoreCase("User Management")) {
			System.out.println("String Found: User Management");
		} else {
			System.out.println("String not Found: User Management");
		}

		if (driver.findElement(By.id("menu_admin_Job")).getText().equalsIgnoreCase("Job")) {
			System.out.println("String Found: Job");
		} else {
			System.out.println("String not Found: Job");
		}

		if (driver.findElement(By.id("menu_admin_Organization")).getText().equalsIgnoreCase("Organization")) {
			System.out.println("String Found: Organization");
		} else {
			System.out.println("String not Found: Organization");
		}

		if (driver.findElement(By.id("menu_admin_Qualifications")).getText().equalsIgnoreCase("Qualifications")) {
			System.out.println("String Found: Qualifications");
		} else {
			System.out.println("String not Found: Qualifications");
		}
		driver.findElement(By.id("menu_admin_Job")).click();
		if (driver.findElement(By.id("menu_admin_viewJobTitleList")).getText().equalsIgnoreCase("Job Titles")) {
			System.out.println("String Found: Job Titles");
		} else {
			System.out.println("String not Found: Job Titles");
		}
	}

}
