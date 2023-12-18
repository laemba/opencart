package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Loginpage;
import testBase.Baseclass;
import utilities.Dataproviders;

public class LoginTest extends Baseclass
{	
	@Test(dataProvider = "testdata",dataProviderClass = Dataproviders.class)
	public void loginTest(String username, String password)
	{
		logger.info("***** started Login Test****");
		Loginpage lg=new Loginpage(driver);
		logger.info("Entered username");
		lg.setUsername(username);
		//lg.setUsername(rb.getString("username"));
		logger.info("Entered username");
		//lg.enterPassword(rb.getString("password"));
		lg.enterPassword(password);
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
	
	

