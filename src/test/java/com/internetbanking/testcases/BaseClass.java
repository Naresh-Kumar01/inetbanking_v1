package com.internetbanking.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.internetbanking.utilities.ReadConfig;



public class BaseClass {
	ReadConfig readconfig=new ReadConfig();
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getpassword();
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		 logger=Logger.getLogger("Internetbanking");
			//PropertyConfigurator.configure("Log4j.properties");
		 if(br.equals("chrome"))
		 {
			 System.setProperty("Webdriver.chrome.driver",readconfig.getChromepath());
				driver=new ChromeDriver();
		 }
		
	
		else if(br.equals("firefox"))
		{
			System.setProperty("Webdriver.gecko.driver", readconfig.getfirefoxpath());
			driver=new FirefoxDriver();
		}
		 else if (br.equals("ie")) 
		 {
			System.setProperty("Webdriver.ie.driver", readconfig.getIEPath());
			driver=new InternetExplorerDriver();
		}
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		 driver.get(baseURL);
		
	}
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException 
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}


}
