package Academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;

import resources.ExtentsreportsNG;

public class Listener extends Base implements ITestListener
{
	ExtentTest test;
	ExtentReports extent =ExtentsreportsNG.getReportObject();
	ThreadLocal<ExtentTest> exttest = new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) 
	{
		// TODO Auto-generated method stub
		//ITestListener.super.onTestStart(result);
		
		String methodName=result.getMethod().getMethodName();
		 test = extent.createTest(methodName);
		 exttest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result)
	{
		exttest.get().log(Status.PASS,"Test passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result)
	{
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailure(result);
		exttest.get().fail(result.getThrowable());
		test.log(Status.FAIL, "Test Fail");
		WebDriver driver = null;
		String methodName =result.getMethod().getMethodName();
		
		try 
		{
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} 
		catch (Exception e1) 
		{
			// TODO Auto-generated catch block
		}	
		
		try 
		{
			
			String path =getScreenshots(methodName,driver);
			exttest.get().addScreenCaptureFromPath(path, methodName);
		}  
		catch (IOException e) 
		{
			
			e.printStackTrace();
		}
	}

	
	

	@Override
	public void onTestSkipped(ITestResult result)
	{
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	
	{
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) 
	{
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context)
	{
		// TODO Auto-generated method stub
		//ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		//ITestListener.super.onFinish(context);
		extent.flush();
	}

}
