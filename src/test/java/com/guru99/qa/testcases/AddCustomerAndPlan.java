package com.guru99.qa.testcases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.guru99.qa.base.Base;
import com.guru99.qa.pages.AddCustomerPage;
import com.guru99.qa.pages.HomePage;

public class AddCustomerAndPlan extends Base {
	
	public AddCustomerAndPlan() {
		super();
	}
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		driver=initializeBrowserAndOpenApplicationURL();
			}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();	
	}
	
	@Test(priority=1)
	public void VerifyAddingCustomerWithValidData() {
		HomePage homePage=new HomePage(driver);
		homePage.clickOnAddCustomer();
		AddCustomerPage acp=new AddCustomerPage(driver);
		acp.clickbutton();
		acp.enterFirstName(prop.getProperty("firstName"));
		acp.enterLastName(prop.getProperty("lastName"));
		acp.entereMail(prop.getProperty("validEmail"));
		acp.enterAddress(prop.getProperty("address"));
		acp.enterMob(prop.getProperty("mobilenumber"));
		acp.clickOnSubmit();
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"main\"]/div/header/h1")).isDisplayed(),"New customer not created");
	}
	
	@Test(priority=2)
	public void UserAddTariffPlanForCustomerCreatedInAboveScenario() {
		HomePage homePage=new HomePage(driver);
		homePage.clickOnAddTariffPlanToCustomer();
		//driver.findElement(By.linkText("Add Tariff Plan to Customer")).click();
		driver.findElement(By.xpath("//*[@id=\"customer_id\"]")).sendKeys(prop.getProperty("customerID"));
		driver.findElement(By.xpath("//input[@class=\"fit\"]")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"main\"]/div/header/h1")).isDisplayed());
		driver.findElement(By.xpath("//label[@for=\"sele\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"submit\"]")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"main\"]/div/h2")).isDisplayed(),"Tariff plan for customer not created");
	}
	
	

}
