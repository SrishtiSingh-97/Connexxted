package Practice.ConnexxtedDev.PageObject.Android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Practice.ConnexxtedDev.Utils.AndroidUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {
	AndroidDriver driver;
	
	public HomePage(AndroidDriver driver)
	{
		super();
		this.driver =driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this); 
	}
	
	@AndroidFindBy(xpath = "//android.widget.EditText")
	private WebElement searchField;

	@AndroidFindBy(accessibility = "heheh")
	private WebElement postTitle;
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"0\"]/android.widget.ImageView[2]")
	private WebElement image;
	
	@AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"heheh\"])[1]")
	private WebElement titlePageHeader;
	
	@AndroidFindBy(xpath = "//android.widget.ImageView")
	private WebElement imageElement;
	
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]")
	private WebElement backBtn;
	
	public void searchAction(String search) {
		searchField.click();
		searchField.sendKeys(search);
	}
	
	public String clickTitle() {
		postTitle.click();
		return titlePageHeader.getAttribute("content-desc");
	}
	
	public void checkImage() {
		image.click();
		AndroidUtils AU = new AndroidUtils(driver);
		AU.swipeAction(imageElement, "left");
		AU.swipeAction(imageElement, "right");
		backBtn.click();
	}
}
