package com.axiatadigitallabs.pages.gist;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.axiatadigitallabs.driver.DriverSingleton;

public class ListOfGistsPage {
	
	private WebDriver driver;
	
	public ListOfGistsPage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#user-links > details > summary > span")
	private WebElement btnpopupmenu;
	
	@FindBy(css = "#user-links > details > details-menu > a:nth-child(3)")
	private WebElement btnseeyourlistgist;
	
	public void seeList() {
		btnpopupmenu.click();
		btnseeyourlistgist.click();
	}
	
	@FindBy(css = "#gist-pjax-container > div > div > div.h-card.col-md-3.col-12 > div > div.clearfix.d-flex.d-md-block.flex-items-center.mb-4.mb-md-0 > div.vcard-names-container.float-left.js-profile-editable-names.col-12.py-3 > h1 > span.p-name.vcard-fullname.d-block.overflow-hidden")
	private WebElement textafterseeyourlist;
	
	public String getTextAfterSeeList() {
		return textafterseeyourlist.getText();
	}
	
	@FindBy(css = "#gist-pjax-container > div > div > div.col-9.col-md-9.col-12 > div.gist-snippet > div.gist-snippet-meta.d-flex.flex-lg-row.flex-column.width-full > div > div.d-inline-block.px-lg-2.px-0 > span:nth-child(1) > a:nth-child(2) > strong")
	private WebElement chooseGist;
	
	public void chooseGist() {
		chooseGist.click();
	}
	
}
