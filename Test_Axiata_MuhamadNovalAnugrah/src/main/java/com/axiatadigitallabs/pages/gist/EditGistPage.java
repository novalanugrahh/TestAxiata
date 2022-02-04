package com.axiatadigitallabs.pages.gist;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.axiatadigitallabs.driver.DriverSingleton;

public class EditGistPage {
	
	private WebDriver driver;
	
	public EditGistPage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#gist-pjax-container > div.gisthead.pagehead.pb-0.pt-3.mb-4 > div > div.mb-3.d-flex.px-3.px-md-3.px-lg-5 > ul > li:nth-child(1) > a")
	private WebElement btnedit;
	
	@FindBy(css = "#gists > input")
	private WebElement inputeditgistdesc;
	
	@FindBy(css = "#gists > div.js-gist-file > file-attachment > div > div.file-header.d-flex.flex-items-center.pr-0 > div.input-group.gist-filename-input > input.form-control.js-gist-filename.js-blob-filename")
	private WebElement inputeditgistfile;
	
	@FindBy(css = "#code-editor > div > pre")
	private WebElement inputeditgistcode;
	
	@FindBy(xpath = "//div[@class='form-actions']/button")
	private WebElement btnsubmitedit;
	
	public void editGist(String description, String file, String kode) {
		btnedit.click();
		inputeditgistdesc.clear();
		inputeditgistdesc.sendKeys(description);
		inputeditgistfile.clear();
		inputeditgistfile.sendKeys(file);
		inputeditgistcode.clear();
		inputeditgistcode.sendKeys(kode);
		btnsubmitedit.click();
	}
	
	@FindBy(css = "#gist-pjax-container > div.container-lg.px-3.new-discussion-timeline > div > div > div:nth-child(1)")
	private WebElement textAfterEdit;
	
	public String getTextAfterEdit() {
		return textAfterEdit.getText();
	}
	
}
