package Practice.ConnexxtedDev.Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;

public class AndroidUtils {
	
	AndroidDriver driver;
	
	public AndroidUtils(AndroidDriver driver)
	{
		this.driver = driver;
	}
	
	public void swipeAction(WebElement imageElement, String direction) 
	{
		((JavascriptExecutor)driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId",((RemoteWebElement)imageElement).getId(),
				"direction", direction,
				"percent", 0.5
				));
	}

}
