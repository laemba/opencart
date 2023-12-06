package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage
{
	
	WebDriver driver;	
	public Loginpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy(name="username") 
	WebElement username;
	@FindBy(name="password") 
	WebElement password;
	@FindBy(xpath="//button[@type='submit']") 
	WebElement login;
	
	
	public void setUsername()
	{
		username.sendKeys("Admin");
	}
	
	public void enterPassword()
	{
		password.sendKeys("admin1234");
	}
	
	public void clickLogin()
	{
		login.click();
	}

	

}
