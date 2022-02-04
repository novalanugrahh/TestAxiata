package com.axiatadigitallabs.pages.gist;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.axiatadigitallabs.driver.DriverSingleton;

public class CreateGistPage {
	
	private WebDriver driver;
	
	public CreateGistPage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#gists > input")
	private WebElement inputgistdesc;
	
	@FindBy(css = "#gists > div.js-gist-file > file-attachment > div > div.file-header.d-flex.flex-items-center.pr-0 > div.input-group.gist-filename-input > input.form-control.js-gist-filename.js-blob-filename")
	private WebElement inputgistfile;
	
	@FindBy(css = "#code-editor > div > pre")
	private WebElement inputgistcode;
	
	@FindBy(css = "#new_gist > div > div.d-flex.flex-items-center.flex-justify-between > div > button")
	private WebElement btnsubmitgist;
	
	public void creatingGist(String description, String file, String code) {
		inputgistdesc.sendKeys(description);
		inputgistfile.sendKeys(file);
		inputgistcode.sendKeys(code);
		btnsubmitgist.click();
	}
	
	@FindBy(css = "#gist-pjax-container > div.container-lg.px-3.new-discussion-timeline > div > div > div:nth-child(1)")
	private WebElement textAfterCreate;
	
	public String getTextAfterCreate() {
		return textAfterCreate.getText();
	}
}
