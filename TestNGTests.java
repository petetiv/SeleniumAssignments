package seleniumAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class TestNGTests {

	WebDriver driver;
	WebDriverWait wait;

	// Program 6
	@BeforeSuite
	public void beforeSuite(ITestContext context) {

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 20);
		context.setAttribute("driver", driver);
	}

	// Program 7
	@Test(priority = 1)
	public void logIn() {
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("welcome")));
	}

	// Program 8
	@Test(priority = 6)
	public void pageTitles() {
		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("searchSystemUser_userName")));
		String adminPageTitle = driver.findElement(By.xpath("//*[@id='menu_admin_viewAdminModule']//b")).getText();
		System.out.println("Page Title: " + adminPageTitle);

		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("empsearch_employee_name_empName")));
		String pimPageTitle = driver.findElement(By.xpath("//*[@id='menu_pim_viewPimModule']//b")).getText();
		System.out.println(" Page Title: " + pimPageTitle);

		driver.findElement(By.id("menu_leave_viewLeaveModule")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("calFromDate")));
		String leaveDashboardPageTitle = driver.findElement(By.xpath("//*[@id='menu_leave_viewLeaveModule']//b"))
				.getText();
		System.out.println(" Page Title: " + leaveDashboardPageTitle);

		driver.findElement(By.id("menu_directory_viewDirectory")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("searchDirectory_emp_name_empName")));
		String directoryPageTitle = driver.findElement(By.xpath("//*[@id='menu_directory_viewDirectory']//b"))
				.getText();
		System.out.println(" Page Title: " + directoryPageTitle);

		driver.findElement(By.id("menu_maintenance_purgeEmployee")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("confirm_password")));
		String maintainancePageTitle = driver.findElement(By.xpath("//*[@id='menu_maintenance_purgeEmployee']//b"))
				.getText();
		System.out.println(" Page Title: " + maintainancePageTitle);
	}

	// Program 9
	public void minimizeWindow(int a, int b) {

		Dimension d = new Dimension(a, b);
		driver.manage().window().setSize(d);
	}

	// Program 10
	@Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
	public String dashboardHeading() {
		driver.findElement(By.id("menu_dashboard_index")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[text()='Assign Leave']")));
		String dashboardHeading = driver.findElement(By.xpath("//div[@id='content']//div/h1")).getText();
		System.out.println("Dashboard Heading: " + dashboardHeading);
		return dashboardHeading;
	}

	// Program 13
	@Test(priority = 4)
	public void searchEmployee() {
		try {
			driver.findElement(By.id("menu_pim_viewPimModule")).click();
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("empsearch_employee_name_empName")));
			driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys("Linda Jane Anderson");
			Thread.sleep(5000);
			driver.findElement(By.id("searchBtn")).click();
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (driver.findElement((By.xpath("//*[@id='resultTable']//tr/td[2]/a"))).isEnabled())
			if (driver.findElement(By.xpath("//*[@id='resultTable']//tr/td[2]/a")).getText().equalsIgnoreCase("0016")) {
				System.out.println("0016");
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}
		if (driver.findElement(By.xpath("//*[@id='resultTable']//tr/td[3]/a")).getText()
				.equalsIgnoreCase("Linda Jane")) {
			System.out.println("Linda Jane");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		if (driver.findElement(By.xpath("//*[@id='resultTable']//tr/td[5]")).getText()
				.equalsIgnoreCase("VP - Sales & Marketing")) {
			System.out.println("VP - Sales & Marketing");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

	}

	// Program 15
	@Test(priority = 5)
	public void xpathTest() {
		driver.findElement(By.id("MP_link")).click();
		if (driver.findElements(By.xpath("//input[@value='Marketplace']")).size() > 0) {
			System.out.println("Market Place Passed");
			Assert.assertTrue(true);
		} else {
			System.out.println("Market Place Failed");
			Assert.assertTrue(false);
		}

		if (driver.findElements(By.xpath("//a[@id='welcome']")).size() > 0) {
			System.out.println("Welcome Passed");
			Assert.assertTrue(true);
		} else {
			System.out.println("Welcome Failed");
			Assert.assertTrue(false);
		}

		adminMenu();
		driver.findElement(By.id("menu_dashboard_index")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[text()='Leave List']")));
		if (driver.findElements(By.xpath("//table[@class='quickLaungeContainer']//tr//td[2]")).size() > 0) {
			System.out.println("Leave List Passed");
			Assert.assertTrue(true);
		} else {
			System.out.println("Leave List Failed");
			Assert.assertTrue(false);
		}

	}

	public void adminMenu() {
		if (driver.findElements(By.xpath("//a[@id='menu_admin_viewAdminModule']/b")).size() > 0) {
			System.out.println("Admin Passed");
			Assert.assertTrue(true);
		} else {
			System.out.println("Admin Failed");
			Assert.assertTrue(false);
		}
	}
}
