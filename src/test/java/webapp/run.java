package webapp;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class run extends combined {
	AndroidDriver<AndroidElement> driver;
	@BeforeTest
	public void bt() throws MalformedURLException 
	{
		driver = capabilities.webapp();
		
	}
  @Test
  public void t() throws InterruptedException 
  {
         driver.get("https://www.google.com");
         System.out.println("will do appium");
         driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("moolyaEd");
         Actions v = new Actions(driver);
         v.sendKeys(Keys.ENTER).build().perform();
         List<AndroidElement> A = driver.findElements(By.tagName("a"));
         System.out.println(A.size());
         
         for(int i1 =0;i1<A.size();i1++) {
        	 String c = A.get(i1).getText();
        	 System.out.println(c);
         }
         
       
        // j.executeScript("document.getElementsByClassName('oewGkc LeUQr MUxGbd v0nnCb')[1].scrollIntoView();");
      	//j.executeScript("document.getElementsByClassName('oewGkc LeUQr MUxGbd v0nnCb')[1].click();");
         WebElement ck = driver.findElement(By.xpath("//*[contains(text(),'MoolyaEd | LinkedIn')]"));
         JavascriptExecutor j =(JavascriptExecutor)driver;
         j.executeScript("arguments[0].scrollIntoView(true)",ck);
         ck.click();
 		System.out.println(driver.getTitle());
 	}
         
  }
  
