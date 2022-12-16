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

public class instance_use  {
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

@Test
public void t1() throws InterruptedException {
	
	Thread.sleep(3000);
	driver.findElement(MobileBy.id("android:id/text1")).click();
	Thread.sleep(3000);
	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))").click();
	driver.findElement(MobileBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("vinay");
	
	driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	Thread.sleep(3000);
	driver.findElements(MobileBy.xpath("//*[@text='ADD TO CART']")).get(0).click();
	driver.findElements(MobileBy.xpath("//*[@text='ADD TO CART']")).get(0).click();
	Thread.sleep(3000);
	
    driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"PG 3\").instance(0))"));
    driver.findElements(MobileBy.id("com.androidsample.generalstore:id/productAddCart")).get(1).click();
	int count = driver.findElements(MobileBy.id("com.androidsample.generalstore:id/rvProductList")).size();
	//System.out.println(count);
	for(int i =0;i<count;i++)
	{
	  String s=  driver.findElements(MobileBy.id("com.androidsample.generalstore:id/productName")).get(i).getText();
	  System.out.println(s);
	  if(s.equalsIgnoreCase("PG 3"))
	  {
		  System.out.println(s);
		  driver.findElements(MobileBy.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
		  break;
	  }
	}
	driver.findElement(MobileBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
	Thread.sleep(3000);
	driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"PG 3\"))"));
	String p3 =driver.findElements(MobileBy.id("com.androidsample.generalstore:id/productPrice")).get(1).getText();
	 driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnProceed")).click(); 
		
	
}
}