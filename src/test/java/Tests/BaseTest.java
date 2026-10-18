package Tests;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import driverpackage.DriverManager;
import utils.configs;

public class BaseTest {

configs config =new configs();	

@BeforeMethod(alwaysRun = true)
public void SetupBrowser() throws MalformedURLException {

    WebDriver driver = null;

    String browserName = System.getProperty("browser") != null
            ? System.getProperty("browser")
            : config.getval("browser");

    String execution = config.getval("execution");

    System.out.println("Execution = [" + execution + "]");
    System.out.println("Browser   = [" + browserName + "]");

    // Create the browser options
    if (browserName.equalsIgnoreCase("chrome")) {

        ChromeOptions options = new ChromeOptions();

        if (execution.equalsIgnoreCase("remote")) {
            driver = new RemoteWebDriver(
                    URI.create("http://localhost:4444").toURL(),
                    options);
        } else if (execution.equalsIgnoreCase("local")) {
            driver = new ChromeDriver(options);
        }

    } else if (browserName.equalsIgnoreCase("firefox")) {

        FirefoxOptions options = new FirefoxOptions();

        if (execution.equalsIgnoreCase("remote")) {
            driver = new RemoteWebDriver(
                    URI.create("http://localhost:4444").toURL(),
                    options);
        } else if (execution.equalsIgnoreCase("local")) {
            driver = new FirefoxDriver(options);
        }

    } else if (browserName.equalsIgnoreCase("edge")) {

        EdgeOptions options = new EdgeOptions();

        if (execution.equalsIgnoreCase("remote")) {
            driver = new RemoteWebDriver(
                    URI.create("http://localhost:4444").toURL(),
                    options);
        } else if (execution.equalsIgnoreCase("local")) {
            driver = new EdgeDriver(options);
        }

    } else {
        throw new IllegalArgumentException(
                "Unsupported browser: " + browserName);
    }

    if (driver == null) {
        throw new IllegalArgumentException(
                "Unsupported execution mode: " + execution);
    }

    // Store the driver for this TestNG thread
    DriverManager.setdriver(driver);

    // Configure and launch the browser
    DriverManager.getDriver().manage()
            .timeouts().implicitlyWait(Duration.ofSeconds(8));

    DriverManager.getDriver().manage().deleteAllCookies();

    DriverManager.getDriver().get(
            "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
}



@AfterMethod(alwaysRun = true)
public void tearDown() {
	WebDriver driver = DriverManager.getDriver();

	try {
		if (driver != null) {
			driver.quit();
		}
	} finally {
		DriverManager.unload();
	}
}

public static String addscreenshot(String name) {

	String timeStamp = new SimpleDateFormat("YYYY-MM-DD-HHss").format(new Date());
	String Threadname = Thread.currentThread().getName().toString();
	TakesScreenshot sc = (TakesScreenshot) DriverManager.getDriver();

	File Source = sc.getScreenshotAs(OutputType.FILE);

	String path = System.getProperty("user.dir") + "/Screen/" + name + timeStamp + Threadname + ".png";

	File target = new File(path);
	target.getParentFile().mkdir();

	try {
		Files.copy(Source.toPath(), target.toPath(), StandardCopyOption.REPLACE_EXISTING);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return path;

}


}
