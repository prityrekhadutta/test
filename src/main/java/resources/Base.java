package resources;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.common.io.Files;

public class Base 

{
	 
    public WebDriver driver;
    public Properties prop;
	public WebDriver initializeDriver() throws IOException
	{
	    prop= new Properties();
	    //System.getProperty("user.dir")
	    FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
        prop.load(fis);
        
        String baseurl=prop.getProperty("url");
        String browserName=prop.getProperty("browser");
        //String browserName = System.getProperty("browser");
        if (browserName.contains("chrome"))
         {
    	   System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver\\chromedriver.exe");
    	   ChromeOptions cp = new ChromeOptions();
    	   cp.addArguments("headless");
    	   if(browserName.contains("headless"))
    		{
    		   cp.addArguments("headless");
    		  
    	    }
    	   driver=new ChromeDriver(cp);
         }
       else if(browserName.equals("FireFox"))
        {
         System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\geckodriver-v0.29.1-win64\\geckodriver.exe");
         driver=new FirefoxDriver();
    
         }
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        return driver;
       
       
     
	}  
	public String getURL() throws IOException
	{
		prop= new Properties();
	    FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
        prop.load(fis);
        String baseurl=prop.getProperty("url");
        return baseurl;
	}
	public String getScreenshots(String methodName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts =(TakesScreenshot)driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String Destination = System.getProperty("user.dir")+"\\reports\\"+methodName+".png";
		FileUtils.copyFile(source,new File(Destination));
		return Destination;
		
	}
	
}