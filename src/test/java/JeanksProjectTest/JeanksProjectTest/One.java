package JeanksProjectTest.JeanksProjectTest;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class One {
  
	public static WebDriver driver;
  
  @BeforeClass
	public void testSetup() {
		
	  // To run scripts on chrome browser
	  System.setProperty("webdriver.chrome.driver","/home/nadsoft/AutomationSoftware/ChromrDriver/chromedriver"); 
	  driver = new ChromeDriver();

	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void tearDown() {
		//driver.quit();
	}
	
	@Test
	public void adminLogin() throws InterruptedException, AWTException{
 		
 		            
		driver.get("https://www.drive-on.com.au/login/");
		
		//Enter user name
		driver.findElement(By.id("user_login")).clear();
		driver.findElement(By.id("user_login")).sendKeys("admin");
		
		//Enter password
		driver.findElement(By.id("user_pass")).clear();
		driver.findElement(By.id("user_pass")).sendKeys("Wedriveon16!");
		
		//Login button
		driver.findElement(By.name("wp-submit")).click();
		
		String url = driver.getCurrentUrl();
		Assert.assertEquals("https://www.drive-on.com.au/partners/my-dashboard/", url);
	}
}
