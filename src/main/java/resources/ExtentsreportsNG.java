package resources;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public   class ExtentsreportsNG 

{
	static ExtentReports ext;
	public static ExtentReports getReportObject()
	{
	//set the path 
	String setPath=System.getProperty("user.dir")+"\\reports\\index.html";
	// needed two class 
	//1. ExtentSparkReporter, ExtentReport
	// create object of ExtentSparkReporter and pass the path
	ExtentSparkReporter reporter = new ExtentSparkReporter(setPath);
	reporter.config().setDocumentTitle("Test Result");
	reporter.config().setReportName("QAClick WebApp");
    ext = new ExtentReports();
	ext.attachReporter(reporter);
	ext.setSystemInfo("Tester" , "prity");
	return ext;
	
	}
	

}
