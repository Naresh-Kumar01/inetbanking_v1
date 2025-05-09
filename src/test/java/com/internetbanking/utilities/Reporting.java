package com.internetbanking.utilities;
//Listener class used to generate extent reports

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter 
{
   public ExtentSparkReporter sparkReporter;
   public ExtentReports extent;
   public ExtentTest logger;
   
   public void onStart(ITestContext testContext)
   {
	   String timeStamp =new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); // time stamp
	   String repName="Test-Report-"+timeStamp+".html";
	   
	   sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/"+repName);
	   try {
		sparkReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   extent=new ExtentReports();
	   
	   extent.attachReporter(sparkReporter);
	   extent.setSystemInfo("Host name","localhost");
	   extent.setSystemInfo("Environment","QA");
	   extent.setSystemInfo("user","Naresh");
	   
		/*
		 * htmlReporter.config().setDocumentTitle("Internet_banking Test Project"); //
		 * Title of Report htmlReporter.config().
		 * setReportName("Functional Test Report Automation Report"); // Name of the
		 * report htmlReporter.config().setTestViewChartLocation(chartLocation.TOP); //
		 * Location of the chart htmlReporter.config().setTheme(Theme.DARK); // Dark
		 * theme for the report
		 */	   }
   public void onTestSuccess(ITestResult tr)
   {
	   logger=extent.createTest(tr.getName());
	   logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
	   String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName();
	   File f=new File(screenshotPath);
	   
	   if(f.exists())
	   {
		   try {
			logger.fail("Screenshot is below:"+logger.addScreenCaptureFromPath(screenshotPath));
		} catch (Exception e) {
			System.out.println(e);
		}
	   }
   }
   public void onTestSkipped(ITestResult tr)
   {
	   logger=extent.createTest(tr.getName()); // create new entry in the report
	   logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
	   
   }
   public void onFinish(ITestContext testcontext)
   {
	   extent.flush();
   }
   
   
   
}
