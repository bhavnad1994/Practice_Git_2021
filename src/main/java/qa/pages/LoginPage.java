package qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.base.Base;

public class LoginPage extends Base {
	//Please implement the functionality
	
	
	@FindBy(name="username")
	public WebElement txt_username;
	
	@FindBy(name="password")
	public WebElement txt_password;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginBtn;
	
	@FindBy(xpath="(//img[contains(@class,\"img-responsive\")])[1]")
	public WebElement crmLogo;
	
	
	public LoginPage() {
		PageFactory.initElements(driver,this);
	}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();
	}
	
	public DashBoard doLogin(String u, String p) {
		txt_username.clear();
		txt_username.sendKeys(u);
		txt_password.clear();
		txt_password.sendKeys(p);
		loginBtn.click();
		return new DashBoard();
	}
	
	
	
}
