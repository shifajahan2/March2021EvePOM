package com.qa.opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	public WebDriver driver;
	public Properties prop;
    public static String Highlight;
    public OptionsManager optionsManager;
    public static ThreadLocal<WebDriver> tlDriver=new ThreadLocal<>();
    
	public WebDriver init_driver(Properties prop) {
		String Highlight=prop.getProperty("highlight");
		optionsManager=new OptionsManager(prop);
        String browsername=prop.getProperty("browser");
		System.out.println("Starting with Browser " + browsername);
		if(browsername.equals("chrome")) {	
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
			//driver = new ChromeDriver(optionsManager.getChromeOptions());
			
		} else if (browsername.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
		//	driver = new FirefoxDriver(optionsManager.getFirefoxOptions());

		} else if (browsername.equals("Safari")) {
			tlDriver.set(new SafariDriver());
			//driver = new SafariDriver();

		} else {
			System.out.println("Please pass the right Browser " + browsername);
		}

		getDriver().get(prop.getProperty("url"));
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().fullscreen();

		return getDriver();
	}
		
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
		
	}

	public Properties init_prop() {
		prop=new Properties();
		try {
			FileInputStream ip= new FileInputStream(".\\src\\test\\resources\\config\\config.properties");
			prop.load(ip);}
			 catch (FileNotFoundException e) {
			e.printStackTrace();
			}
		  catch (IOException e) {
						e.printStackTrace();
		}
	
return prop;
		
	}
	
	//Method to Get ScrennShot
	
	public String getScreenshot(){
	File src=((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
	String Path=System.getProperty("user.dir")+"/screenshots/"+System.currentTimeMillis()+".png";
	File destination=new File(Path);
	
	try {
		FileUtils.copyFile(src, destination);
	} catch (IOException e) {
			e.printStackTrace();
	}
		return Path;			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
