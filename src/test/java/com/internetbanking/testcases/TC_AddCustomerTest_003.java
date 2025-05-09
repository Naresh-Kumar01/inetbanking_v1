package com.internetbanking.testcases;
import org.apache.commons.lang3.RandomStringUtils;
import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.internetbanking.pageobjects.AddCustomerPage;
import com.internetbanking.pageobjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {
	
	@Test
	public void addnewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp= new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.Click_submit();
		Thread.sleep(3000);
		AddCustomerPage addcust=new AddCustomerPage(driver);
		addcust.clickaddnewcustomer();
		addcust.custname("Naresh");
		addcust.custgender("male");
		addcust.custdob("10", "02", "1994");
		Thread.sleep(3000);
		addcust.custadd("G-1003 Nilaya Green Ghaziabad");
		addcust.custcity("Ghaziabad");
		addcust.custstate("Uttar Pradesh");
		addcust.cust_pin("201003");
		addcust.c_mobile("9220579104");
		//addcust.custemail("nareshsofttech@gmail.com");
		addcust.clickonsubmit();
		String email=randomstring()+"@gmail.com";
		addcust.custemail(email);
		Thread.sleep(3000);
		
	boolean	res=driver.getPageSource().contains("Customer Registered Successfully ");
	
	if(res==true)
	{
		Assert.assertTrue(true);
	}
	else {
		captureScreen(driver,"addnewcustomer" );
		Assert.assertTrue(false);
	}
		
	}
	public  String randomstring()
	{
	String	generatedstring=RandomStringUtils.randomAlphabetic(0);
	return generatedstring;
	}

}
