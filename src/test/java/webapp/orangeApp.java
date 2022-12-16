package webapp;


	import java.net.MalformedURLException;
	import java.net.URL;
	import java.util.List;

	import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	import com.google.common.collect.ImmutableMap;

	import io.appium.java_client.android.AndroidDriver;
	import io.appium.java_client.android.AndroidElement;
	import io.appium.java_client.remote.AndroidMobileCapabilityType;
	import io.appium.java_client.remote.MobileCapabilityType;

	public class orangeApp {
		 AndroidDriver<AndroidElement> driver;
		
		@BeforeTest
		public void bt() throws MalformedURLException 
		{
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
			dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			dc.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
			dc.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE,"C:/Users/godvi/Downloads/chromedriver.exe");
			//dc.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
			driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);	
		

		}
		@Test
		public void t() throws InterruptedException {
			Thread.sleep(3000);
		 driver.get("https://www.google.com");
		 driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("Orangehrm");
         Actions v = new Actions(driver);
         v.sendKeys(Keys.ENTER).build().perform();
         v.click();
         
         WebElement ck = driver.findElement(By.xpath("//*[@href='https://opensource-demo.orangehrmlive.com/']"));
         JavascriptExecutor j =(JavascriptExecutor)driver;
        
         j.executeScript("arguments[0].scrollIntoView(true)",ck);
         ck.click();
         Thread.sleep(5000);
        
         driver.findElement(By.xpath("//*[@class='oxd-input oxd-input--focus']")).sendKeys("Admin");
         Thread.sleep(5000);
 		driver.findElement(By.xpath("//*[@class='oxd-input oxd-input--active']")).sendKeys("admin123");
 		 Thread.sleep(5000);
 		driver.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")).click();
 		 Thread.sleep(5000);
 		
 		driver.findElement(By.xpath("//*[@class='oxd-topbar-header']/div/i")).click();	
 		 Thread.sleep(5000);
 		
 		driver.findElement(By.xpath("//*[@class='oxd-main-menu']/li[1]/a")).click();
 		System.out.println(driver.getTitle());
 		 Thread.sleep(5000);
 		
 		driver.findElement(By.xpath("//*[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
 		 Thread.sleep(5000);
 		 System.out.println(driver.getTitle());
 		driver.findElement(By.xpath("//*[@class='oxd-dropdown-menu']/li[4]/a")).click();
 			
 	}
 }











