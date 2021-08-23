package Academy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomepageLanding 
{
	WebDriver driver;
	public HomepageLanding(WebDriver driver)
	{
		this.driver = driver;
		//PageFactory.initElements(driver, this);
	}
	//@FindBy(css="a[href*='sign_in']")
	//WebElement login;
	private By Loginbutton=By.cssSelector("a[href*='sign_in']");
	private By featuredtext =By.xpath("//div[@class='text-center']/h2");
	private By menubar= By.xpath("//ul[@class='nav navbar-nav navbar-right']/li/a");
	//By forgotPassword= By.xpath("//a[@class='link-below-button']");
	
	public loginpage getLogin()
	{
		 driver.findElement(Loginbutton).click();
		 loginpage lp = new loginpage(driver);
		 return lp;
	}
	
    public WebElement getTitleCourse()
    {
    	return driver.findElement(featuredtext);
    }
    public List<WebElement> getmenubarlist()
    {
    	return driver.findElements(menubar);
    }
    
	
    
}
