package webapp;

import static io.appium.java_client.touch.TapOptions.tapOptions;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.PointOption;
import static io.appium.java_client.touch.offset.PointOption.point;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class task {
AndroidDriver<AndroidElement> driver;
	
	@BeforeTest
	public void bt() throws MalformedURLException 
	{
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,AutomationName.ANDROID_UIAUTOMATOR2);
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.appium.android.apis");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "io.appium.android.apis.ApiDemos");
		driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);	

	}
	
	@Test(enabled =false)
	public void t1() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		Thread.sleep(2000);
		driver.findElement(MobileBy.AccessibilityId("Date Widgets")).click();
		Thread.sleep(2000);
		driver.findElement(MobileBy.AccessibilityId("2. Inline")).click();
		Thread.sleep(2000);
		driver.findElement(MobileBy.id("android:id/toggle_mode")).click();
	    AndroidElement h =   driver.findElement(MobileBy.id("android:id/input_hour"));
	    h.clear();
	    h.sendKeys("11");
	    Thread.sleep(2000);
	    AndroidElement m =   driver.findElement(MobileBy.id("android:id/input_minute"));
	    m.clear();
	    m.sendKeys("59");
	  
	    driver.findElement(MobileBy.id("android:id/am_pm_spinner")).click();
	    driver.findElementByAndroidUIAutomator("text(\"AM\")").click();
	    driver.findElement(MobileBy.id("android:id/toggle_mode")).click();
	    driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }
	@Test(enabled = true)
	public void t2() throws InterruptedException {
		Thread.sleep(2000);
		driver.activateApp("com.android.chrome");
		Thread.sleep(3000);
	//AndroidElement sc =	driver.findElements(MobileBy.className("android.widget.ImageView")).get(0);
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("+sc+" ))").click();
		TouchAction ta = new  TouchAction(driver);	
		//ta.tap(616, 1500).perform();
		ta.longPress(PointOption.point(15, 2020)).moveTo(PointOption.point(97,321)).release().perform();
		driver.findElement(MobileBy.AccessibilityId("Close"));
		Thread.sleep(2000);
		ta.longPress(PointOption.point(15, 2020)).moveTo(PointOption.point(37,411)).release().perform();
		driver.findElements(MobileBy.className("android.widget.ImageView")).get(0).click();
		//driver.findElement(MobileBy.id("com.android.chrome:id/search_box_text")).sendKeys("Hanshika marriage pics");
		 //Actions v = new Actions(driver);
      //   v.sendKeys(Keys.ENTER).build().perform();
      //   Thread.sleep(6000);
       //  driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Hansika Motwani Shares Pic From Wedding - See Her Bridal Mehendi ... \"))").click();
        // WebElement ck = driver.findElement(By.xpath("//android.view.View[@content-desc=\"NDTV https://www.ndtv.com › "
         		//+ "entertainment Hansika Motwani Shares Pic From Wedding - See Her Bridal Mehendi ...\"]/android.view.View[2]"));
        // JavascriptExecutor j =(JavascriptExecutor)driver;
         //j.executeScript("arguments[0].scrollIntoView(true)",ck);
         //ck.click();
 		
	
    }
}