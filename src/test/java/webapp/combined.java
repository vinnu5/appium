package webapp;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class combined {
	 AndroidDriver<AndroidElement> driver;
	
	@BeforeTest
	public void bt() throws MalformedURLException 
	{
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		dc.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE,"C:/Users/godvi/Downloads/chromedriver.exe");
		//dc.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
		driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);	
	

	}
	@Test
	public void t() throws InterruptedException {
		Thread.sleep(3000);
	 driver.get("https://www.google.com");
	 List<AndroidElement> A = driver.findElements(By.tagName("a"));
     System.out.println(A.size());
     
     for(int i1 =0;i1<A.size();i1++) {
    	 String c = A.get(i1).getText();
    	 String h = A.get(i1).getAttribute("href");
    	 System.out.println(c);
    	 System.out.println(h);
    	 
}
	}
}
