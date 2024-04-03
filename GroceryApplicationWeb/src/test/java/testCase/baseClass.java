package testCase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilities.ScreenShotCapture;

public class baseClass {
	WebDriver driver;
	ScreenShotCapture sc;
	public static Properties pro;  //TO GET URL FROM ANOTHER WINDOW
	public static void testBasic() throws IOException { // TO GET URL FROM ANOTHER CLASS

		pro = new Properties();
		FileInputStream fp = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\resources\\Properties\\config.properties");
		pro.load(fp);
	}
	
 
  @BeforeMethod(alwaysRun=true)  //(alwaysRun=true) used to run every time.
  @Parameters("Browser")
  public void beforeMethod(String browserName) throws IOException {
	  testBasic();
	  if(browserName.equals("chrome")) {
		 System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\src\\main\\resources\\driver\\chromedriver.exe");
			driver= new ChromeDriver();  
	  }
	  else if(browserName.equals("firefox")) {
		  System.setProperty("webdriver.gecko.driver", "C:\\Users\\admin\\Desktop\\driver1\\geckodriver.exe");
			 driver= new FirefoxDriver(); 
	  }
	  driver.get(pro.getProperty("BaseUrl"));
		//driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(50000));
  }

  @AfterMethod(alwaysRun = true)
	public void afterMethode(ITestResult iTestResult) throws IOException {
	
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			sc = new ScreenShotCapture();
			sc.captureFailureScreenShot(driver, iTestResult.getName());
		}
		driver.quit();
	
  }
}
