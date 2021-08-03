package com.qa.opencart.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.LoginPage;

public class BaseTest {
	public WebDriver driver;
	public DriverFactory driverFactory;
	public Properties prop;

	public LoginPage loginPage;

	@BeforeTest
	
public void setup() {	
		 driverFactory=new DriverFactory();
		 prop=driverFactory.init_prop();

		driver= driverFactory.init_driver(prop);
		 loginPage=new LoginPage(driver);
	}
}
