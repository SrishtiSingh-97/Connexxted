package TestUtil;

import org.testng.annotations.BeforeClass;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.testng.annotations.AfterClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AndroidBaseTest {
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass(alwaysRun = true)
	public void Configure() throws MalformedURLException, URISyntaxException, InterruptedException {
		 service = new AppiumServiceBuilder()
	                .withAppiumJS(new File("/usr/local/lib/node_modules/appium//build/lib/main.js"))
	                .withIPAddress("127.0.0.1")
	                .usingPort(4723)
	                .build();
	        service.start();
	             
	 UiAutomator2Options options = new UiAutomator2Options();
	 options.setApp("/Users/appventurez/eclipse-workspace/ConnexxtedDev/src/test/java/Resources/connexxted_dev_7_Aug_2.apk");
	 options.setDeviceName("Test123");
	 
	 driver = new AndroidDriver(new URI("http://127.0.0.1:4723/").toURL(),options);
	 Thread.sleep(3000);
	}
	
/*	@AfterClass
	 public void tearDown() {
		 
		 if(driver!=null)

			driver.quit();
	        service.stop();
	 }
*/	 
}
