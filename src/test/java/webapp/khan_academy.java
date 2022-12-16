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

public class khan_academy {
	 AndroidDriver<AndroidElement> driver;
		
		@BeforeTest
		public void bt() throws MalformedURLException 
		{
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
			dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,AutomationName.ANDROID_UIAUTOMATOR2);
			dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"org.khanacademy.android");
			dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"org.khanacademy.android.ui.library.MainActivity");
			driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);	

		}
		@Test
		public void t() throws InterruptedException {
			//Thread.sleep(3000);
			//driver.findElement(MobileBy.AccessibilityId("Khan Academy")).click();
			Thread.sleep(20000);
			driver.findElement(MobileBy.AccessibilityId("Search tab")).click();
			Thread.sleep(2000);
			driver.findElementByAndroidUIAutomator("text(\"Computing\")").click();
			driver.findElementByAndroidUIAutomator("text(\"Computers and the Internet\")").click();
			Thread.sleep(5000);
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Online data security\"))").click();
			//driver.pressKey(new KeyEvent(AndroidKey.BACK ) );
			driver.findElementByAndroidUIAutomator("text(\"Cyber attacks\")");
			driver.findElements(MobileBy.className("android.widget.ImageView")).get(0).click();
			String toast = driver.findElement(MobileBy.xpath("//android.widget.Toast[1]")).getText();
			System.out.println(toast);
			driver.findElement(MobileBy.AccessibilityId("Bookmarks tab")).click();
			driver.findElementByAndroidUIAutomator("text(\"Edit\")").click();
			driver.findElements(MobileBy.className("android.widget.ImageView")).get(0).click();
			driver.findElementByAndroidUIAutomator("text(\"Delete\")").click();
			
}
}