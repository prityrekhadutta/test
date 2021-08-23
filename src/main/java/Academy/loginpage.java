package Academy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage
{
	WebDriver driver;
	public loginpage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	private @FindBy(id="user_email")
	WebElement username;
	
	private @FindBy(xpath="//input[@type='password']")
	WebElement password;
	
	private @FindBy(xpath="//input[@type='submit']")
	WebElement login;
	
	public WebElement getUsername()
	{
		return username;
	}
	public WebElement getPassword()
	{
		return password;
	}
	public WebElement clickLogin()
	{
		return login;
	}
	@FindBy(xpath="//a[@class='link-below-button']")
	WebElement forgotPassword;
	public Resetpassword clickForgotPassword()
    {
    	 forgotPassword.click();
    	 Resetpassword rp = new Resetpassword(driver);
    	 return rp;
    }
	

}
