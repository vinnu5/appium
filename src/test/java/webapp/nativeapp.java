package webapp;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class nativeapp {
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
			Thread.sleep(3000);
           driver.findElement(MobileBy.AccessibilityId("Preference")).click();
           Thread.sleep(2000);
           driver.findElements(MobileBy.className("android.widget.TextView")).get(3).click();
           Thread.sleep(2000);
           driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"WiFi\")")).click();
           Thread.sleep(2000);
           driver.findElements(MobileBy.className("android.widget.TextView")).get(3).click();
           //driver.navigate().back();
           driver.hideKeyboard();
           driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"WiFi settings\")")).click();
           Thread.sleep(2000);
           driver.findElement(MobileBy.className("android.widget.EditText")).sendKeys("vinay");
         
         //  driver.switchTo().alert().sendKeys("alert");
           driver.findElement(MobileBy.id("android:id/button2")).click();
           
		}
}