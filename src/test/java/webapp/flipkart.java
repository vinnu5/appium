package webapp;

import java.net.MalformedURLException;
import java.net.URL;

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
import io.appium.java_client.touch.offset.PointOption;

public class flipkart {
AndroidDriver<AndroidElement> driver;
	
	@BeforeTest
	public void bt() throws MalformedURLException 
	{
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,AutomationName.ANDROID_UIAUTOMATOR2);
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.flipkart.android");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.flipkart.android.SplashActivity");
		driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);	

	}
	@Test
	public void negativecase() throws InterruptedException {
		Thread.sleep(8000);
		driver.findElementByAndroidUIAutomator("text(\"English\")").click();
		Thread.sleep(8000);
		driver.findElementByAndroidUIAutomator("text(\"CONTINUE\")").click();
		//driver.findElement(MobileBy.AccessibilityId("com.flipkart.android:id/select_btn")).click();
		Thread.sleep(10000);
		driver.findElement(MobileBy.id("com.flipkart.android:id/custom_back_icon")).click();
		Thread.sleep(5000);
		TouchAction ta = new  TouchAction(driver);	
		//ta.tap(616, 1500).perform();
		ta.longPress(PointOption.point(300, 1750)).moveTo(PointOption.point(140,600)).release().perform();
		Thread.sleep(2000);
		ta.longPress(PointOption.point(300, 1750)).moveTo(PointOption.point(140,600)).release().perform();
}
}