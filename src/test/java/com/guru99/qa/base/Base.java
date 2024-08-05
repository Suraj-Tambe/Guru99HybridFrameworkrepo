package com.guru99.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base {
	WebDriver driver;
	public Properties prop;
	public Base() {
		prop=new Properties();
		File propFile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\guru99\\qa\\config\\config.properties");
		try {
		FileInputStream fin=new FileInputStream(propFile);
		prop.load(fin);
		}catch(Throwable e) {
		e.printStackTrace(); 	
		}
	}
	
	
	public WebDriver initializeBrowserAndOpenApplicationURL() {
		System.setProperty("webdriver.chrome.driver","S:\\New Java Programming\\GURU99\\drivers\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.setBinary("C:\\Users\\Suraj Tambe\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
		options.addArguments("--remote-allow-origins=*"); 
		driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.get(prop.getProperty("url"));
		return driver;
		
	}
	

}
