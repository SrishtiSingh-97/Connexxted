package Practice.ConnexxtedDev.Android;

import org.testng.Assert;
import org.testng.annotations.Test;

import Practice.ConnexxtedDev.PageObject.Android.LoginPage;
import TestUtil.AndroidBaseTest;

public class Login extends AndroidBaseTest{
	
	@Test
	public void invalidEmail() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("testuser24");
        driver.hideKeyboard();
        loginPage.enterPassword("Test@1234");
        driver.hideKeyboard();
        loginPage.clickLogin();
        String actualValidationMessage = loginPage.emailValidation();
        Assert.assertEquals(actualValidationMessage, "Please enter email id in the correct format");
        
    }
}
