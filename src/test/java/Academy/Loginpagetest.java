package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import resources.Base;



public class Loginpagetest extends Base
{
	private static Logger lg= LogManager.getLogger(Loginpagetest.class.getName());
	WebDriver driver;
	
	@BeforeTest
	public void beforeTest() throws IOException
	{
		driver = initializeDriver();
		lg.info("Driver is intialize" );
		driver.get(prop.getProperty("url"));
		lg.info("Navigate to home page");
	}
	
	
	@Test(dataProvider= "getdata")
	
	
	public void homepagelogin(String username, String password ) throws IOException
	{
	  driver.get(prop.getProperty("url"));	 
	  HomepageLanding hmp = new HomepageLanding(driver);
	  loginpage lp =hmp.getLogin();
	  lp.getUsername().sendKeys(username);
	  lg.error("getting the username");
	  lp.getPassword().sendKeys(password);
	  lg.info("getting the password");
	  lp.clickLogin().click();
	  lg.info("click loginbutton");
	   Resetpassword rp = lp.clickForgotPassword();
	   rp.getEmail();
	   rp.clickSendMe();
	}
	@DataProvider 
	public Object[][] getdata()
	
	
	{
		int row =2;
		int col =2;
		Object[][] data = new Object[row][col];
		data[0][0]="prity.dutta101@gmail.com";
		data[0][1]="12345";
		
		data[1][0]="Himanagshu86@gmail.com";
		data[1][1]="098754";
		
		return data;
	}
	@AfterTest
	public void afterTest()
	{
		driver.close();
	}
	
	

}
