package com.qa.opencart.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.opencart.factory.DriverFactory;

public class ElementUtil {
	
	public WebDriver driver;
	public JavaScriptUtil jsUtil;
	

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
		jsUtil=new JavaScriptUtil(this.driver);
	}
	
	
	public WebElement getelement(By Locator) {	
	WebElement element=driver.findElement(Locator);
	if(Boolean.parseBoolean(DriverFactory.Highlight));
	jsUtil.flash(element);
	return element;
	}
	
	
	
	//public WebElement getelement(By Locator) {
		//WebElement element=driver.findElement(Locator);
		//if(Boolean.parseBoolean(DriverFactory.HighLight)) {
			//jsUtil.flash(element);	
	//	}
		//return element;	
//	}
	
	
	public List<WebElement> doGetWebElements(By Locator) {
		return driver.findElements(Locator);	
	}
	
	
	
	public WebElement waitForElementToBeVisible(By Locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver,timeout);
		return wait.until(ExpectedConditions.visibilityOf(getelement(Locator)));	
	}
	
	 
	public String getPageTitle() {
	return driver.getTitle();	
	}
	
	public boolean isLinkDisplayed(By Locator) {
	return getelement(Locator).isDisplayed();	
	}
	
	public void doSendKeys(By Locator, String text) {
		WebElement element=getelement(Locator);
		element.clear();
		element.sendKeys(text);
		}
	
	public void doClick(By Locator) {
		getelement(Locator).click();	
	}
	
	public String dogetText(By Locator) {
		return getelement(Locator).getText();
	}
	
	public List<WebElement> waitForElementsToBeVisible(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	public String waitForTitleIs(String expTitle, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		if (wait.until(ExpectedConditions.titleIs(expTitle)))
			return driver.getTitle();
		return null;
	}
	
}

