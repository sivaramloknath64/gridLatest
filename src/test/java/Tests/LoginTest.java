package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import driverpackage.DriverManager;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class LoginTest extends BaseTest {


	@Test(groups={"sanity"})
	public void Loginpage() {
		LoginPage login = new LoginPage(DriverManager.getDriver());
		HomePage Home = new HomePage(DriverManager.getDriver());

		login.Loginmethod();
		Assert.assertTrue(Home.verifylogo());

	}

	@Test(groups={"regression","sanity"})
	public void Loginpage1() {

		LoginPage login = new LoginPage(DriverManager.getDriver());
		HomePage Home = new HomePage(DriverManager.getDriver());

		login.Loginmethod();
		Home.verifylogo();
		Assert.assertTrue(Home.verifylogo());
	}


	@Test(enabled=false)
	public void Loginskipped() {

		LoginPage login = new LoginPage(DriverManager.getDriver());
		HomePage Home = new HomePage(DriverManager.getDriver());

		login.Loginmethod();
		Home.verifylogo();
		Assert.assertTrue(Home.verifylogo());
	}

	//@Test(retryAnalyzer=retryclass.class)
	@Test
	public void Loginandverify() {
		LoginPage login = new LoginPage(DriverManager.getDriver());
		HomePage Home = new HomePage(DriverManager.getDriver());

		login.Loginmethod();
		Home.verifylogo();
//		Assert.assertTrue(Home.verifylogo());
		Assert.fail();
	}
	
	@Test
	public void Loginpage3() {
		LoginPage login = new LoginPage(DriverManager.getDriver());
		HomePage Home = new HomePage(DriverManager.getDriver());

		login.Loginmethod();
		Home.verifylogo();
		
		Assert.assertTrue(Home.verifylogo());
	}
	
	
	
	@Test
	public void Loginpage5() {
		LoginPage login = new LoginPage(DriverManager.getDriver());
		HomePage Home = new HomePage(DriverManager.getDriver());

		login.Loginmethod();
		Home.verifylogo();
		
		Assert.assertTrue(Home.verifylogo());
	}
	
	
	
	@Test
	public void Loginpage6() {
		LoginPage login = new LoginPage(DriverManager.getDriver());
		HomePage Home = new HomePage(DriverManager.getDriver());

		login.Loginmethod();
		Home.verifylogo();
		
		Assert.assertTrue(Home.verifylogo());
	}
	
}
