package Practice.ConnexxtedDev.Android;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Practice.ConnexxtedDev.PageObject.Android.HomePage;
import Practice.ConnexxtedDev.PageObject.Android.LoginPage;
import TestUtil.AndroidBaseTest;

public class Home extends AndroidBaseTest{
	
	HomePage homePage;
			
	@BeforeClass
	public void validEmailAndPassword() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("testuser24@yopmail.com");
        driver.hideKeyboard();
        loginPage.enterPassword("Test@1234");
        driver.hideKeyboard();
        loginPage.clickLogin(); 
        homePage = new HomePage(driver);
    }

	@Test(priority=1)
	public void search() throws InterruptedException {
		homePage.searchAction("heh");
		Thread.sleep(2000);
	}
	
	@Test(priority=2)
	public void clickOnTitle() {
		homePage.clickTitle();
		String actualTitleHeader = homePage.clickTitle();
		Assert.assertEquals(actualTitleHeader, "heheh");
	}
	
	@Test(priority=3)
	public void clickImage() throws InterruptedException {
		homePage.checkImage();
	}
}