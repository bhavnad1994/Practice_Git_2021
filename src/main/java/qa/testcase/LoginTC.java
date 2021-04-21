package qa.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import qa.base.Base;
import qa.pages.LoginPage;

public class LoginTC extends Base {

	LoginPage login;

	public LoginTC() {
		super();
	}

	@BeforeClass
	public void setup() {
		initializaton();
		login = new LoginPage();
	}

	@Test(priority = 1)
	public void loginPageTitleTest() {

		String title = login.validateLoginPageTitle();
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}

	@Test(priority = 2)
	public void logintest() {

		login.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 0)
	public void crmlogoImageTest() {
		
		boolean flag=login.validateCRMImage();
		Assert.assertTrue(flag);
	}

	@AfterClass
	public void tearDown() {

		driver.quit();
	}

}
