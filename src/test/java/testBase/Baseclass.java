package testBase;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



public class Baseclass {

	public static WebDriver driver;	
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
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(rb.getString("appurl"));
		
	}
	
	@AfterClass
	public void teardown()
	{
		driver.close();
	}
	
	
	public void captureScreen(String tname) throws IOException
	{
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String targetpath=System.getProperty("user.dir")+"/screenshots/"+timestamp+tname+".png";
		File targetloc=new File(targetpath);
		try {
			FileUtils.copyFile(source, targetloc);	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	
}
