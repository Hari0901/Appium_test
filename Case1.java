package appium_testing01;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.By;

import CommonFunctions.CommonFunction;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Case1 {

	public static void main(String[] args) throws Exception {
		AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
		service.start();
		try {
		    // do stuff with drivers
//			File f =new File("appium_testing01");
//			File fs = new File(f, "base.apk");
			UiAutomator2Options options = new UiAutomator2Options()
	                .setDeviceName("pixel")
	                .setPlatformName("Android")
	                .setAutomationName("UiAutomator2")
	                .setApp("app-debug.apk");

			AppiumDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

	        // Your test code here
			driver.findElement(By.xpath("//AppCompatButton[contains(text(),'SKIP'])")).click();
	     
//			driver.quit();   
		}catch (Exception e) {
			throw new Exception(e);
		}
		finally {
		    service.stop();
		}
		
		
	}

}
