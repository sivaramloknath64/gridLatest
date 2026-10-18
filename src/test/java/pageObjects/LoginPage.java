package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driverpackage.DriverManager;


public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(DriverManager.getDriver());

	}
//	
//	 public LoginPage(WebDriver driver) {
//
//	        super(DriverManager.getDriver());
//
//	        PageFactory.initElements(DriverManager.getDriver(), this);
//	    }

	@FindBy(xpath = "//input[@name='username']")
	WebElement username;

	@FindBy(xpath = "//input[@name='password']")
	WebElement password;

	@FindBy(css = ".oxd-form-actions.orangehrm-login-action")
	WebElement LoginButton;

	public void Loginmethod() {

		username.sendKeys("Admin");
		password.sendKeys("admin123");
		LoginButton.click();
	}

	public void Loginmethod(String user, String pass) {

		username.sendKeys(user);
		password.sendKeys(pass);
		LoginButton.click();
	}

}
