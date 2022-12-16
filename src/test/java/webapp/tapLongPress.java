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
import static  io.appium.java_client.touch.LongPressOptions.longPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.TapOptions.tapOptions;;
public class tapLongPress{
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
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		driver.findElement(MobileBy.AccessibilityId("Expandable Lists")).click();
		AndroidElement c = driver.findElement(MobileBy.AccessibilityId("1. Custom Adapter"));
		TouchAction ta = new  TouchAction(driver);	
		ta.tap(tapOptions().withElement(element(c))).perform();
		
		AndroidElement lp = driver.findElementByAndroidUIAutomator("text(\"People Names\")");
		Thread.sleep(3000);
		ta.longPress(longPressOptions().withElement(element(lp)).withDuration(ofSeconds(3))).release().perform();
		driver.findElementByAndroidUIAutomator("text(\"Sample action\")").click();
		
}
}