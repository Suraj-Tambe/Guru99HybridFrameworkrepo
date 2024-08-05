package com.guru99.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	WebDriver driver;
	@FindBy(xpath="//*[@id=\"main\"]/div/form/div/div[1]/label")
	private WebElement button;
	
	@FindBy(xpath="//input[@id=\"fname\"]")
	private WebElement firstName;
	
	
	@FindBy(xpath="//input[@id=\"lname\"]")
	private WebElement lastName;
	
	@FindBy(xpath="//input[@id=\"email\"]")
	private WebElement email;
	
	@FindBy(xpath="//*[@placeholder=\"Enter your address\"]")
	private WebElement address;
	
	@FindBy(xpath="//input[@id=\"telephoneno\"]")
	private WebElement mobileNumber;
	
	@FindBy(xpath="//input[@type=\"submit\"]")
	private WebElement submitButton;
	
	public AddCustomerPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void clickbutton() {
		button.click();
	}
	public void enterFirstName(String fNameText ) {
		firstName.sendKeys(fNameText);
	}
	public void enterLastName(String lNameText ) {
		lastName.sendKeys(lNameText);
	}
	public void entereMail(String mailText ) {
		email.sendKeys(mailText);
	}
	public void enterAddress(String addText ) {
		address.sendKeys(addText);
	}
	public void enterMob(String MobText ) {
		mobileNumber.sendKeys(MobText);
	}
	public void clickOnSubmit() {
		submitButton.click();
	}
}
