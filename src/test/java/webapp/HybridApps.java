package webapp;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Alert;
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

public class HybridApps {
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
	@Test(enabled = false)
	public void negativecase() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(MobileBy.id("android:id/text1")).click();
		Thread.sleep(3000);
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))").click();
		//driver.findElement(MobileBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("vinay");
		
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		String toast = driver.findElement(MobileBy.xpath("//android.widget.Toast[1]")).getText();
		System.out.println(toast);
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
		driver.findElements(MobileBy.xpath("//*[@text='ADD TO CART']")).get(0).click();
		driver.findElements(MobileBy.xpath("//*[@text='ADD TO CART']")).get(0).click();
		
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(2000);
		String price1 =driver.findElements(MobileBy.id("com.androidsample.generalstore:id/productPrice")).get(0).getText();
		price1 = price1.substring(1);
		 Double PRO1 = Double.parseDouble(price1);
		 System.out.println(PRO1);
		
		 String price2 =driver.findElements(MobileBy.id("com.androidsample.generalstore:id/productPrice")).get(1).getText();
			price2 = price2.substring(1);
			 Double PRO2 = Double.parseDouble(price2);
			 System.out.println(PRO2);
			 Double totPrice = PRO1+PRO2;
			 System.out.println("Total price is : " +totPrice);
			 Thread.sleep(3000);
			
	     String FINAL =driver.findElements(MobileBy.id("com.androidsample.generalstore:id/totalAmountLbl")).get(0).getText();
			 FINAL = FINAL.substring(1);
			 Double final1 = Double.parseDouble(FINAL);
			 System.out.println(final1);
			 
			// Assert.assertEquals(totPrice, final1);
			 if(totPrice.equals(final1))
			 {
			 System.out.println("added price matches total cart price");
	         }
			 else
			 {
				 System.out.println("prices not matched");
			 }
			 driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnProceed")).click(); 
		
	}
	}	
		
		
		
		
		
		
		
		
		
		
		
