package com.axiatadigitallabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.axiatadigitallabs.driver.DriverSingleton;

public class LogoutPage {
	private WebDriver driver;
	
	public LogoutPage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#user-links > details > summary > span")
	private WebElement btnpopupmenu;
	
	@FindBy(css = "#user-links > details > details-menu > form > button")
	private WebElement btnsignout;
	
	@FindBy(css = "#js-pjax-container > div > form > input.btn.btn-block.f4.py-3.mt-5")
	private WebElement btnconfirmsignout;
	
	public void signout() {
		btnpopupmenu.click();
		btnsignout.click();
		btnconfirmsignout.click();
	}
	
	@FindBy(css = "body > div.position-relative.js-header-wrapper > header > div > div.HeaderMenu.HeaderMenu--logged-out.position-fixed.top-0.right-0.bottom-0.height-fit.position-lg-relative.d-lg-flex.flex-justify-between.flex-items-center.flex-auto > div.d-lg-flex.flex-items-center.px-3.px-lg-0.text-center.text-lg-left > div.position-relative.mr-3.mb-4.mb-lg-0.d-inline-block > a")
	private WebElement textafterlogout;
	
	public String getTextAfterLogout() {
		return textafterlogout.getText();
	}
}
