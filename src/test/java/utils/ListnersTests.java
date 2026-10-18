package utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import Tests.BaseTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnersTests implements ITestListener{
	

private ExtentSparkReporter sparkreporter;
private ThreadLocal<ExtentTest> test=new ThreadLocal<ExtentTest>();
private ExtentReports extentReport; 
	


	public void onStart(ITestContext context) {

	String datee=new SimpleDateFormat("YYYY-DDMM-HHMmss").format(new Date());
	String path=System.getProperty("user.dir")+"//Reports//TestReport_"+datee+".html";
	sparkreporter=new ExtentSparkReporter(path);
	sparkreporter.config().setDocumentTitle("Testreport");
	sparkreporter.config().setTheme(Theme.DARK);
	extentReport =new ExtentReports();
	extentReport.attachReporter(sparkreporter);
	extentReport.setSystemInfo("browser","chrome");
	extentReport.setSystemInfo("Host","Local");

	}

	public void onTestStart(ITestResult result) {
	ExtentTest etest=extentReport.createTest(result.getName());
	etest.assignCategory(result.getMethod().getGroups());
	test.set(etest);
		
	}

	public void onTestSuccess(ITestResult result) {
	test.get().log(Status.PASS,"Testpased"+ result.getName());	
	
	}

	public void onTestFailure(ITestResult result) {
		
	test.get().log(Status.FAIL,"Tesfailed"+ result.getName());
	test.get().log(Status.FAIL,result.getThrowable());
	
	BaseTest base=(BaseTest)result.getInstance();
	String path=base.addscreenshot(result.getName());
	test.get().addScreenCaptureFromPath(path);
	}

	public void onTestSkipped(ITestResult result) {
	test.get().log(Status.SKIP,"Testskipped"+ result.getName());	
	}

	public void onFinish(ITestContext context) {

	extentReport.flush();
	test.remove();
	}

}
