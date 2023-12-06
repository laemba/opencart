package testCases;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pageObjects.Loginpage;
import testBase.Baseclass;

public class LoginTest2 extends Baseclass
{	
	@Test
	void loginTest()
	{
		logger.info("***** started Login Test****");
		Loginpage lg=new Loginpage(driver);
		logger.info("Entered username");
		lg.setUsername();
		logger.info("Entered username");
		lg.enterPassword();
		logger.info("click on login");
		lg.clickLogin();
		
		if("welcome".equals("welome"))
		{
			logger.info("Test is passed");
		}
		else
		{
			logger.error("test is failed");
		}
	}
}
	
	

