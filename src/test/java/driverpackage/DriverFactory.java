package driverpackage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
public class DriverFactory {

	
	public static WebDriver CreateDriver(String Browser) {
		
		WebDriver Driver;
		if(Browser.equalsIgnoreCase("chrome")){
			
			Driver=new ChromeDriver();
			
		}else if(Browser.equalsIgnoreCase("Firefox")) {
			Driver=new FirefoxDriver();
		}else if(Browser.equalsIgnoreCase("Edge")) {
			Driver= new EdgeDriver();
		}else {
			
			throw new IllegalArgumentException ("browser parameter is invalid please check");
		}
		
		return Driver;
		
		
	}
	
	
	
	
	
	
	
	
}
