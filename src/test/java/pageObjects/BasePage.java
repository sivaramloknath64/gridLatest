package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	protected WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);		
	}


	public void waitForElement(By findBY,int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBY));
	}

	public void scrollBy(WebElement ele, String feature) {

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		switch (feature) {
		case "scroll":
			js.executeScript("window.scrollBy(0,500);");
			break;
		case "ScrollIntoElement":
			js.executeScript("arguments[0].scrollIntoView(true);", ele);
			break;

		case "click":
			js.executeScript("arguments[0].click();", ele);
			break;
			
			default :
	            throw new IllegalArgumentException("Unknown feature: " + feature);

		}

	}

}
