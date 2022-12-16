package webapp;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class sms {
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
	@Test
	public void t() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(MobileBy.AccessibilityId("OS")).click();
		driver.findElement(MobileBy.AccessibilityId("SMS Messaging")).click();
		driver.findElement(MobileBy.id("io.appium.android.apis:id/sms_recipient")).sendKeys("(555) 521-5554");
		driver.findElement(MobileBy.id("io.appium.android.apis:id/sms_content")).sendKeys(" my own message");
		driver.findElementByAccessibilityId("Send").click();
		Thread.sleep(2000);
		driver.activateApp("com.google.android.apps.messaging");
		Thread.sleep(2000);
		String value = driver.findElement(MobileBy.id("com.google.android.apps.messaging:id/conversation_snippet")).getText();
		System.out.println(value);
		driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
		Thread.sleep(2000);
		driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
		Thread.sleep(2000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}
}