package testCases;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Loginpage;
import testBase.Baseclass;

public class LoginTest extends Baseclass
{	
	@Test
	void loginTest()
	{
		logger.info("***** started Login Test****");
		Loginpage lg=new Loginpage(driver);
		logger.info("Entered username");
		lg.setUsername(rb.getString("username"));
		logger.info("Entered username");
		lg.enterPassword(rb.getString("password"));
		logger.info("click on login");
		lg.clickLogin();
		
		if("welcome".equals(driver.getTitle()))
		{
			logger.info("Test is passed");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("test is failed");
			Assert.assertTrue(false);
		}
	}
}
	
	

