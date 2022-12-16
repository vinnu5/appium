package webapp;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

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

public class drag_drop {
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
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		Thread.sleep(3330);
		driver.findElement(MobileBy.AccessibilityId("Drag and Drop")).click();
		AndroidElement F = driver.findElements(MobileBy.className("android.view.View")).get(0);
		AndroidElement T = driver.findElements(MobileBy.className("android.view.View")).get(1);
		TouchAction ta = new TouchAction(driver);
		//ta.longPress(longPressOptions().withElement(element(ele1)).withDuration(ofSeconds(3))).moveTo(element(ele2)).release().perform();
		ta.longPress(longPressOptions().withElement(element(F)).withDuration(ofSeconds(3))).moveTo(element(T)).release().perform();
	}

}
