package testBase;
import java.time.Duration;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



public class Baseclass {

	public WebDriver driver;	
	public Logger logger;
	public ResourceBundle rb;
	@BeforeClass
	@Parameters({"browser"})
	public void setUp(String br)
	{
		rb=ResourceBundle.getBundle("config");//reading property file
		
		if(br.equals("chrome"))
		{
			
			logger=LogManager.getLogger(this.getClass());
			driver =new ChromeDriver();
		
		}
		else if(br.equals("edge"))
		{
			logger=LogManager.getLogger(this.getClass());
			driver =new EdgeDriver();
		}
		
		else
		{
			logger=LogManager.getLogger(this.getClass());
			driver =new ChromeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(rb.getString("appurl"));
		
	}
	
	@AfterClass
	public void teardown()
	{
		driver.close();
	}
	
	
	
	
}
