package snapdeal_test_cases;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Billing_test {

	public AndroidDriver<MobileElement> driver;
	
	public AppiumDriverLocalService service;
	
@Before
	
	//..Under this method we have set desired capabilities of the emulator..// 
	
	// Also we have set the app path which we are testing.. //

	public void drag_drop() throws MalformedURLException{
		
		service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingDriverExecutable(new File("C:\\Program Files (x86)\\Appium\\node.exe")).withAppiumJS(new File("C:\\Program Files (x86)\\Appium\\node_modules\\appium\\bin\\appium.js")).withIPAddress("127.0.0.1").usingPort(4723));
		
		service.start();

		new File("//src//main//java//com.snapdeal.main.6.0.5.apk");

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("deviceName", "Samsung");

		capabilities.setCapability("platformVersion", "6.0");

		capabilities.setCapability("platformName", "Android");

		capabilities.setCapability("appPackage", "com.snapdeal.main");

		capabilities.setCapability("appActivity", "com.snapdeal.ui.material.activity.MaterialMainActivity");

		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}
	@org.junit.Test

	//This method will verify the billing of a product.//
	
	public void verify_billing() throws InterruptedException{

		driver.findElementById("android:id/button1").click();

		Thread.sleep(1000);

		driver.findElementById("com.snapdeal.main:id/home_screen_login_skip").click();

		Thread.sleep(10000);

		WebElement electornics = driver.findElementByXPath("//android.widget.FrameLayout[@index = '1']");

		electornics.click();

		Thread.sleep(1000);

		WebElement mobile=driver.scrollTo("Mobile Phones");

		mobile.click();

		driver.findElementByName("All Mobile Phones").click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.scrollTo("Top Selling").click();

		Thread.sleep(8000);

		driver.findElementByXPath("//android.widget.FrameLayout[@index = '0']").click();

		driver.findElementById("com.snapdeal.main:id/buyButton").click();

		driver.findElementByName("Black").click();

		driver.findElementByName("DONE").click();

		driver.findElementByName("Continue").click();


	}
	@After
	
	//This method will close the current application ..//
	
	public void close(){
		
		driver.closeApp();
		service.stop();
	}
}
