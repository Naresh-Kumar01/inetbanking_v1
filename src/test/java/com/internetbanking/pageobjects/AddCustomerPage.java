
package com.internetbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	WebDriver ldriver;
	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(xpath ="//a[text()='New Customer']")
	@CacheLookup
	WebElement linkAddNewCustomer;
	@FindBy(xpath ="//input[@type='text' or @name='name'] ")
	@CacheLookup
	WebElement  CustoName;
    @FindBy(xpath ="//input[text()='male' or @type='radio']")
    @CacheLookup
    WebElement Gender;
    @FindBy(xpath ="//input[@type='date' or @name='dob' or @id='dob']")
    @CacheLookup
    WebElement txtdob;
    @FindBy(xpath ="//textarea[@name='addr']" )
    @CacheLookup
    WebElement address;
    @FindBy(xpath ="//input[@name='city' and @type='text']" )
    @CacheLookup
    WebElement city;
    @FindBy(xpath ="//input[@name='state' and @type='text'] " )
    @CacheLookup
    WebElement state;
    @FindBy (xpath ="//input[@name='pinno' and @type='text']" )
    @CacheLookup
    WebElement pin;
    @FindBy(xpath ="//input[@name='telephoneno' and @type='text']" )
    @CacheLookup
    WebElement mobileno;
    @FindBy(xpath ="//input[@name='emailid' and @type='text'] ")
    @CacheLookup
    WebElement email;
    @FindBy(xpath ="//input[@type='submit' and @value='Submit' and @name='sub']" )
    WebElement btnsubmit;
    
    public void clickaddnewcustomer()
    {
    	linkAddNewCustomer.click();
    }
    public void custname(String cname)
    {
    	CustoName.sendKeys(cname);
    }
    public void custgender(String cgender)
    {
    	Gender.sendKeys(cgender);
    	
    }
    public void custdob(String mm,String dd,String yy)
    {
    	txtdob.sendKeys(mm);
    	txtdob.sendKeys(dd);
    	txtdob.sendKeys(yy);
    }
    public void custadd(String add)
    {
    	address.sendKeys(add);
    }
    public void custcity(String c_city)
    {
    	city.sendKeys(c_city);
    }
    public void custstate(String c_state)
    {
    	state.sendKeys(c_state);
    }
    public void cust_pin(String c_pin)
    {
    	pin.sendKeys(c_pin);
    }
    public void c_mobile(String C_mobile)
    {
    	mobileno.sendKeys(C_mobile);
    }
    public void custemail(String c_email)
    {
    	email.sendKeys(c_email);
    }
    public void clickonsubmit()
    {
    	btnsubmit.click();
    }
}
    

