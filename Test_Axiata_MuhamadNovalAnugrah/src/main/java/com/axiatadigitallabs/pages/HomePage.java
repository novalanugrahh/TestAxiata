package com.axiatadigitallabs.pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.axiatadigitallabs.driver.DriverSingleton;

public class HomePage {
	
	private WebDriver driver;
	
	public HomePage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "body > div.position-relative.js-header-wrapper > div > div:nth-child(6) > a > svg.octicon.octicon-plus.d-none.d-md-inline-block")
	private WebElement btnaddgist;
	
	public void addGist() {
		btnaddgist.click();
	}
}