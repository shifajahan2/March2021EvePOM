package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
@Epic("Epic-100:Design open cart Application")
@Story("US-101: Design login page with different features")
public class LoginPageTest extends BaseTest{
	@Description("Testcase to Verify Forgot PASSWORD link")
	@Severity(SeverityLevel.TRIVIAL)
	@Test
	public void forgotPWDlInkTestExist() {
		
		Assert.assertTrue(loginPage.forgotPwdLinkTest().isDisplayed());
	}
	
	@Description("Testcase to get Login Page Title")
	@Severity(SeverityLevel.TRIVIAL)
		@Test
		public void loginPageTitleTestExists() {	
			Assert.assertEquals(loginPage.loginPageTitleTest(),Constants.LOGIN_PAGE_TITLE);	
		}
			
	@Description("Testcase to Verify Login Page Header")
	@Severity(SeverityLevel.TRIVIAL)
		@Test
		public void loginPageHeaderTestExists() {	
			Assert.assertEquals(loginPage.loginPageHeaderText(),Constants.LOGIN_PAGE_HEADER); 
			
		}
	@Description("Testcase to Verify Login procedure")
	@Severity(SeverityLevel.TRIVIAL)
		
	@Test	
public void doLoginExists() {
	loginPage.dologin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
}
	
}
	
	
		
		
		
