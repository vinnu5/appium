package webapp;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
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
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class chrome_press {
AndroidDriver<AndroidElement> driver;
	
	@BeforeTest
	public void bt() throws MalformedURLException 
	{
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,AutomationName.ANDROID_UIAUTOMATOR2);
		driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
}
	@Test
	public void t() throws InterruptedException {
	
	//driver.findElement(MobileBy.AccessibilityId("Apps list")).click();
	Thread.sleep(3000);
	TouchAction ta = new  TouchAction(driver);	
	AndroidElement lp = driver.findElementByAndroidUIAutomator("text(\"Chrome\")");
	Thread.sleep(3000);
	ta.longPress(longPressOptions().withElement(element(lp)).withDuration(ofSeconds(3))).release().perform();
	driver.findElements(MobileBy.className("android.widget.ImageView")).get(1).click();
	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Install unknown apps\"))").click();
	
	driver.findElements(MobileBy.className("android.widget.Switch")).get(0).click();
	}
}