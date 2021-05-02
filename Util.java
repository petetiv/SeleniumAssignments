package seleniumAssignments;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

//TestBase
public class Util {

	public static WebDriver driver;
	public static FileInputStream fileLoc;
	public static Properties prop;
	//
	//
	@BeforeClass
	public void setUp() {

		try {
			fileLoc = new FileInputStream(System.getProperty("user.dir")+"\\ExecutionProperties\\Config.properties");
			prop = new Properties();
			prop.load(fileLoc);
		}catch(Exception e) {
			e.printStackTrace();
		}

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Driver\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("Url"));

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}


	public static void captureScreenshot(WebDriver webdriver,String fileWithPath) throws Exception{

		//Convert web driver object to TakeScreenshot

		TakesScreenshot scrShot =((TakesScreenshot)webdriver);

		//Call getScreenshotAs method to create image file

		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

		//Move image file to new destination

		File DestFile=new File(fileWithPath);

		//Copy file at destination

		FileUtils.copyFile(SrcFile, DestFile);

	}
}