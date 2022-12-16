package webapp;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import static java.time.Duration.ofSeconds;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import static io.appium.java_client.touch.offset.ElementOption.element;
import  static io.appium.java_client.touch.LongPressOptions.longPressOptions;

public class swipeOptions {
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
	@Test(enabled = false)
	public void t() throws InterruptedException {
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		Thread.sleep(2000);
		driver.findElement(MobileBy.AccessibilityId("Date Widgets")).click();
		driver.findElement(MobileBy.AccessibilityId("2. Inline")).click();
		driver.findElement(MobileBy.AccessibilityId("12")).click();
		AndroidElement F = driver.findElement(MobileBy.AccessibilityId("15"));
		AndroidElement T = driver.findElement(MobileBy.AccessibilityId("8"));
		TouchAction ta =new TouchAction(driver);
		ta.longPress(longPressOptions().withElement(element(F)).withDuration(ofSeconds(3))).moveTo(element(T)).release().perform();
		driver.findElementByAndroidUIAutomator("text(\"PM\")");
		Thread.sleep(2000);
		driver.findElement(MobileBy.AccessibilityId("Switch to text input mode for the time input")).click();
	}
		
		@Test(enabled = true)
		public void t2() throws InterruptedException {
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
		    m.sendKeys("15");
		  
		    driver.findElement(MobileBy.id("android:id/am_pm_spinner")).click();
		    driver.findElementByAndroidUIAutomator("text(\"AM\")").click();
		    driver.findElement(MobileBy.id("android:id/toggle_mode")).click();
		    
		    
		    
}
}