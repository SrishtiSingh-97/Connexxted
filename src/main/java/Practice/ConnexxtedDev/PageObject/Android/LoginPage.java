package Practice.ConnexxtedDev.PageObject.Android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage{
	AndroidDriver driver;

	public LoginPage(AndroidDriver driver)
	{
		super();
		this.driver =driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this); 
	}
	
	@AndroidFindBy(xpath="//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]")
	private WebElement emailClick;
	
	@AndroidFindBy(xpath="//android.widget.ScrollView/android.widget.EditText[1]")
	private WebElement emailEnter;
	
	@AndroidFindBy(xpath= "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]")
	private WebElement passwordClick;
	
	@AndroidFindBy(xpath="//android.widget.ScrollView/android.widget.EditText[2]")
	private WebElement passwordEnter;
	
	@AndroidFindBy(accessibility="Login")
	private WebElement loginBtn;
	
	@AndroidFindBy(xpath="//android.view.View[@content-desc=\"Please enter email id in the correct format\"]")
	private WebElement emailValidation;
	
	@AndroidFindBy(xpath = "//android.widget.Toast")
	private WebElement toast;
	
	@AndroidFindBy(accessibility = "Welcome to Connexxted")
	private WebElement HomePageTitle;

	
	public void enterEmail(String email) {
		emailClick.click();
		emailEnter.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		passwordClick.click();
		passwordEnter.sendKeys(password);
	}
	
	public void clickLogin() {	
		loginBtn.click();
	}

	public String emailValidation() {
        return emailValidation.getAttribute("content-desc");
    }
	
	public String toastMessage() {
        return toast.getAttribute("name");
    }
	
	public void clearEmail() {
		emailEnter.clear();
	}
	
	public void clearPassword() {
		passwordEnter.clear();
	}
	
	public String homePageTitle() {
		return HomePageTitle.getAttribute("content-desc");
	}
}
