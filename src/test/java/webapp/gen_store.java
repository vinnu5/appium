package webapp;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class gen_store {
AndroidDriver<AndroidElement> driver;
	
	@BeforeTest
	public void bt() throws MalformedURLException 
	{
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,AutomationName.ANDROID_UIAUTOMATOR2);
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.androidsample.generalstore");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.androidsample.generalstore.SplashActivity");
		driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);	

	}

	@Test(enabled = true)
	public void positivecase() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.findElement(MobileBy.id("android:id/text1")).click();
		Thread.sleep(3000);
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))").click();
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("vinay");
		
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(3000);
		String S= driver.findElementByAndroidUIAutomator("new UiScrollable (new UiSelector()).scrollIntoView(text(\"Converse All Star\" ))").getText();
		System.out.println(" Scrolled to the product -> "+S);
		driver.findElements(MobileBy.xpath("//*[@text='ADD TO CART']")).get(1).click();
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(3000);
		String s= driver.findElement(MobileBy.id("com.androidsample.generalstore:id/productName")).getText();
		System.out.println(" Shoe added to the cart is -> " +s);
		 Assert.assertEquals(S, s);
		 System.out.println("TASK done ");
}
	
	
	
	
	
}