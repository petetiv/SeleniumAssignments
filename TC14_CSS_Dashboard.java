package seleniumAssignments;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC14_CSS_Dashboard {

	public static Properties prop; 
	public static FileInputStream fileLoc;
	WebDriver driver;

	@BeforeTest()
	public void BrowserOpen() throws InterruptedException {
		try {
			fileLoc = new FileInputStream(System.getProperty("user.dir")+"\\Config.properties");
			prop = new Properties();
			prop.load(fileLoc);
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(prop.getProperty("Url"));
		Thread.sleep(2000);
		driver.manage().window().maximize();

	}
	@Test(priority=1)
	public void Login() throws InterruptedException {

		String  Name = prop.getProperty("username");
		String  Psword = prop.getProperty("passwd");
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(Name);
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(Psword);
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority=2,dependsOnMethods= {"Login"})
	public void CSSSelectorlist() throws InterruptedException
	{
		String text;
		Boolean ObjectExist;
		ObjectExist= driver.findElement(By.cssSelector("#menu_pim_viewPimModule > b")).isDisplayed();
		Assert.assertTrue(ObjectExist);
		text=driver.findElement(By.cssSelector("#menu_pim_viewPimModule > b")).getText();
		Reporter.log("PIM text is displaying as:'" + text +"'", true);
		Thread.sleep(3000);
		
		ObjectExist= driver.findElement(By.cssSelector("#menu_time_viewTimeModule > b")).isDisplayed();
		Assert.assertTrue(ObjectExist);
		text=driver.findElement(By.cssSelector("#menu_time_viewTimeModule > b")).getText();
		Reporter.log("Time text is displaying as :'" + text +"'", true);
		Thread.sleep(3000);
			
		ObjectExist= driver.findElement(By.cssSelector("#menu_maintenance_purgeEmployee > b")).isDisplayed();
		Assert.assertTrue(ObjectExist);
		text=driver.findElement(By.cssSelector("#menu_maintenance_purgeEmployee > b")).getText();
		Reporter.log("Maintanence text is displaying as :'" + text +"'", true);
		Thread.sleep(3000);

		ObjectExist= driver.findElement(By.cssSelector("#dashboard-quick-launch-panel-menu_holder > table > tbody > tr > td:nth-child(1) > div")).isDisplayed();
		Assert.assertTrue(ObjectExist);
		text=driver.findElement(By.cssSelector("#dashboard-quick-launch-panel-menu_holder > table > tbody > tr > td:nth-child(1) > div")).getText();
		Reporter.log("Assign Leave text is displaying as :'" + text +"'", true);
		
		Thread.sleep(3000);
		ObjectExist= driver.findElement(By.cssSelector("#dashboard-quick-launch-panel-menu_holder > table > tbody > tr > td:nth-child(3) > div")).isDisplayed();
		Assert.assertTrue(ObjectExist);
		text=driver.findElement(By.cssSelector("#dashboard-quick-launch-panel-menu_holder > table > tbody > tr > td:nth-child(3) > div")).getText();
		Reporter.log("Timesheet text is displaying as :'" + text +"'", true);
		
		Thread.sleep(3000);
		ObjectExist= driver.findElement(By.cssSelector("#div_graph_display_emp_distribution > canvas:nth-child(2)")).isDisplayed();
		Assert.assertTrue(ObjectExist);
		text=driver.findElement(By.cssSelector("#panel_resizable_1_0 > legend")).getText();
		Reporter.log("Timesheet text is displaying as :'" + text +"'", true);
	}
	
	@AfterTest()
	public void signoff()
	{
		driver.quit();
	}
}
