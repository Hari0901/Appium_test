package appium_testing01;

import java.io.File;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Case1 {

	public static void main(String[] args) throws Exception {
//		AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
//		service.start();
		try {
		    // do stuff with drivers
			File f =new File("in-generalknowledges-app-11-58175751-8290590a08671e2f08ed6b0b40d4ec1a.apk");
//			File fs = new File(f, "appium_testing01/in-generalknowledges-app-11-58175751-8290590a08671e2f08ed6b0b40d4ec1a.apk");
			UiAutomator2Options options = new UiAutomator2Options()
	                .setDeviceName("pixel")
	                .setPlatformName("Android")
	                .setAutomationName("UiAutomator2")
	                .setApp(f.getAbsolutePath());

			AppiumDriver driver = new AndroidDriver(new URL("http://192.168.0.103:4723/"), options);
//			driver.findElement(By.id("android:id/button1"));)
	        // Your test code here
			driver.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();
			Thread.sleep(4000);
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("(//android.view.ViewGroup[@resource-id='in.generalknowledges.app:id/itemRoot'])[2]")));
			driver.findElement(By.xpath("//android.widget.TextView[@resource-id='in.generalknowledges.app:id/itemTitle' and @text='GK Question Bank']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//android.widget.EditText")).sendKeys("3");
			Thread.sleep(500);
			driver.findElement(By.xpath("//android.widget.Button[@text=\"Go\"]")).click();
			Thread.sleep(3000);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//android.widget.TextView[@text=\"80. Who is the founder of Bombay Times\"]")));
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//android.widget.Button[@text=\"Show Ans\"])[4]")).click();
			Thread.sleep(2000);
			String Answer = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Answer: Robert Knight & Thomas Bennnet\"]")).getText();
			
			if(!Answer.trim().equalsIgnoreCase("Robert Knight & Thomas Bennnet")) {
				throw new Exception("Wrong Answer Shown.");
			}else {
				System.err.println("Answer Verified.");
			}
//			driver.quit();   
		}catch (Exception e) {
			throw new Exception(e);
		}
		finally {
//		    service.stop();
		}
		
		
	}

}
