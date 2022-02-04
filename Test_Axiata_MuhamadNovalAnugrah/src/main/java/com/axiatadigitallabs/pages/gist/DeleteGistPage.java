package com.axiatadigitallabs.pages.gist;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.axiatadigitallabs.driver.DriverSingleton;

public class DeleteGistPage {
	
	private WebDriver driver;
	
	public DeleteGistPage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#gist-pjax-container > div.gisthead.pagehead.pb-0.pt-3.mb-4 > div > div.mb-3.d-flex.px-3.px-md-3.px-lg-5 > ul > li:nth-child(2) > form > button")
	private WebElement btndelete;
	
	public void delete() {
		btndelete.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	@FindBy(css = "#js-flash-container > div > div")
	private WebElement textAfterDelete;
	
	public String getTextAfterDelete() {
		return textAfterDelete.getText();
	}
}
