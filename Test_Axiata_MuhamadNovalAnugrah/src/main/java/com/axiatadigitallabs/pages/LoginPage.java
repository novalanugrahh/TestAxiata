package com.axiatadigitallabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.axiatadigitallabs.driver.DriverSingleton;

public class LoginPage {
	
	private WebDriver driver;
	
	public LoginPage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "body > div.position-relative.js-header-wrapper > div > div.Header-item.f4.mr-0 > a.HeaderMenu-link.no-underline.mr-3")
	private WebElement btnsignin;
	
	@FindBy(id = "login_field")
	private WebElement inputusername;
	
	@FindBy(id = "password")
	private WebElement inputpassword;
	
	@FindBy(css = "#login > div.auth-form-body.mt-3 > form > div > input.btn.btn-primary.btn-block.js-sign-in-button")
	private WebElement btnsigningin;
	
	public void intoSignin(String username, String password) {
		btnsignin.click();
		inputusername.sendKeys(username);
		inputpassword.sendKeys(password);
		btnsigningin.click();
	}
	
	@FindBy(css="#gist-pjax-container > div.gisthead.pagehead.pb-0.pt-3.mb-4 > div > div > div > h1")
	private WebElement textafterlogin;
	
	public String getTextAfterLogin() {
		return textafterlogin.getText();
	}
}
