package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import driverpackage.DriverManager;


public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(DriverManager.getDriver());
//		// TODO Auto-generated constructor stub
	}
	
//	 public HomePage(WebDriver driver) {
//
//	        super(DriverManager.getDriver());
//
//	        PageFactory.initElements(DriverManager.getDriver(), this);
//	    }
	By prod=By.cssSelector(".oxd-brand-banner img");	
	@FindBy(css=".oxd-brand-banner img")
	WebElement logo;
	
	public boolean verifylogo() {
		waitForElement(prod,10);
		
		return logo.isDisplayed();	
	}
	


}
