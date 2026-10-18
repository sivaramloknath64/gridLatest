package driverpackage;

import org.openqa.selenium.WebDriver;

public class DriverManager {
	
	
	private static ThreadLocal<WebDriver> tldriver=new ThreadLocal<WebDriver>();
	
	public static void setdriver(WebDriver Instance) {
		
		tldriver.set(Instance);
	}
	
	public static WebDriver getDriver() {
	 return	tldriver.get();
	}

	public static void unload() {
		tldriver.remove();
	}
	
}
