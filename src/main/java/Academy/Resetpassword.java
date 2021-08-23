package Academy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Resetpassword


{
	WebDriver driver;
	public Resetpassword(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	private @FindBy(id="user_email")
	WebElement email;
	public WebElement getEmail()
	{
		return email;
		
	}
	private @FindBy(name="commit")
	WebElement sendMeInstruction;
	public WebElement clickSendMe()
	{
		return sendMeInstruction;
	}

}
