package com.qa.opencart.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage {
private WebDriver driver;
private ElementUtil elementUtil;

public LoginPage(WebDriver driver) {
	this.driver = driver;
	elementUtil=new ElementUtil(this.driver);
}
private By forgotPwdLink = By.linkText("Forgotten Password");
private By forgotpasswordLink = By.linkText("Forgotten Password");

private By loginPageHeader=By.cssSelector("div#logo h1");
private By email=By.id("input-email");
private By Pwd=By.id("input-password");
private By CntBtn=By.xpath("//input[@value='Login']");

public WebElement forgotPwdLinkTest() {
	return elementUtil.waitForElementToBeVisible(forgotPwdLink, 5);
	}

@Step("Getting Login page title")
public String loginPageTitleTest() {
	return elementUtil.getPageTitle();
	
}
@Step("Getting Login page Header")
public String loginPageHeaderText() {
	return elementUtil.dogetText(loginPageHeader);
}

@Step("Login with username:{0} and password{1}")
public void dologin(String un, String pwd) {
	elementUtil.doSendKeys(email, un);
	elementUtil.doSendKeys(Pwd, pwd);
	elementUtil.doClick(CntBtn);
	
}
}


