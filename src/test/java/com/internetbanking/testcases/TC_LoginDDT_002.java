package com.internetbanking.testcases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.internetbanking.pageobjects.LoginPage;
import com.internetbanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass
{

	@Test (dataProvider ="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		logger.info("user name provided");
		lp.setPassword(pwd);
		logger.info("password provided");
		lp.Click_submit();
		Thread.sleep(3000);
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();// close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warning("Login failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login passed");
			Thread.sleep(3000);
			lp.click_logout();
			driver.switchTo().alert().accept(); // close the logout alert
		driver.switchTo().defaultContent();	
			
		}
	}
	
	public boolean isAlertPresent() // user defined method created to check alert present or not
	{
		try {
			driver.switchTo().alert();
			return true;
			
		} catch (NoAlertPresentException e) {
			return false;
			
		}
		
		
	}
	@DataProvider(name="LoginData")
	String [] [] getData() throws IOException
	
	{
		String path=System.getProperty("used.dir")+"/src/test/java/com/internetbanking/testData/USER Data.xlsx";
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int col_count=XLUtils.getCellCount(path,"Sheet1" , 1);
		String logindata[][]=new String[rownum][col_count];
		for (int i = 1; i < rownum; i++) 
		{
			for(int j=0;j<col_count;j++)
			{
				logindata[i-1][j]=XLUtils.getcelldata(path, "sheet1", i, j); // 0,1
				
			}
			
		}
		return logindata;
	}
}
