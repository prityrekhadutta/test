package Academy;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import resources.Base;

public class HomepageTest extends Base
{
	private static Logger lg= LogManager.getLogger(HomepageTest.class.getName());
    WebDriver driver;
    HomepageLanding hmp;
    
	@BeforeTest
	public void beforeTest() throws IOException
	{
		lg.info("hi");
		driver= initializeDriver();
		lg.info("Driver is intialize" );
		driver.get(prop.getProperty("url"));
		lg.info("Navigate to home page");lg.info("hi");
		lg.info("hi");
	}

	
	@Test
	public void FeatureTextCheck() throws IOException
	{
		
	    hmp = new HomepageLanding(driver);
	    lg.info("getting the title");
	    String str=hmp.getTitleCourse().getText();
	    lg.info("comparing the title");
	    Assert.assertEquals(str,"FEATURED COURSES");
	    lg.info("comparing the title pass");
	}
	
	
	@Test
	public void checkMenuBarContact() throws IOException
	{
		
		
		List<WebElement> menulist=hmp.getmenubarlist();
		lg.info("getting the size");
		int count = menulist.size();
		
		lg.info("checking if all the element is displayed");
		for(int i=0; i<count; i++)
	   
		{
			WebElement menuOneitem = menulist.get(i);
			String str = menulist.get(i).getText();
			//System.out.println(str);
			Assert.assertTrue(menuOneitem.isDisplayed()) ;
			
		}
		 
	}
   @Test
	public void menubarnav()
	{
		SoftAssert sa = new SoftAssert();
		List<WebElement> menuList=hmp.getmenubarlist();
		int count = menuList.size();
		for( int i=0;i<count;i++)
		{
			String onClick = Keys.chord(Keys.CONTROL,Keys.ENTER);
			 menuList.get(i).sendKeys(onClick);
			
		}
		Set<String> wh =driver.getWindowHandles();
		Iterator<String> it=wh.iterator();
		String parent = it.next();
		while(it.hasNext())
		{
			String child = it .next();
			if(child!=parent)
			{
				driver.switchTo().window(child);
				String title =driver.getTitle();
				System.out.println( "title is "+title);
				driver.close();	
			}
			
		}
		driver.switchTo().window(parent);
		
	}
	@AfterTest
	public void afterTest()
	{
		driver.close();
	}
	
	
	
}
