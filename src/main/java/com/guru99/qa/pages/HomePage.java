package com.guru99.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	@FindBy(linkText="Add Customer")
	private WebElement addCustomer;
	
	@FindBy(linkText="Add Tariff Plan to Customer")
	private WebElement addTariffPlanToCustomer;
	

	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void clickOnAddCustomer() {
		addCustomer.click();
	}
	
	public void clickOnAddTariffPlanToCustomer() {
		addTariffPlanToCustomer.click();
	}
	
	
	
	
}
