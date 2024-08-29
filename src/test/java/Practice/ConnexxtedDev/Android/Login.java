package Practice.ConnexxtedDev.Android;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Practice.ConnexxtedDev.PageObject.Android.LoginPage;
import TestUtil.AndroidBaseTest;

public class Login extends AndroidBaseTest{

	@Test(priority =1)
	public void invalidEmail() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("testuser24");
        driver.hideKeyboard();
        loginPage.enterPassword("Test@1234");
        driver.hideKeyboard();
        loginPage.clickLogin();
        String actualValidationMessage = loginPage.emailValidation();
        Assert.assertEquals(actualValidationMessage, "Please enter email id in the correct format");
        Thread.sleep(2000);
    }
	
	@Test(priority =2)
	public void validEmailInvalidPassword() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("testuser24@yopmail.com");
        driver.hideKeyboard();
        loginPage.enterPassword("Test@12346376");
        driver.hideKeyboard();
        loginPage.clickLogin();
        String actualToastMessage = loginPage.toastMessage();
        Assert.assertEquals(actualToastMessage, "Invalid Credentials");     
    }
	
	@Test(priority =3)
	public void validEmailAndPassword() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("testuser24@yopmail.com");
        driver.hideKeyboard();
        loginPage.enterPassword("Test@1234");
        driver.hideKeyboard();
        loginPage.clickLogin();
        String title = loginPage.homePageTitle();
        Assert.assertEquals(title, "Welcome to Connexxted");     
    }
	
	@AfterMethod
	public void clearFields() {
        driver.terminateApp("com.connexxted");
        driver.activateApp("com.connexxted");
	}
}
