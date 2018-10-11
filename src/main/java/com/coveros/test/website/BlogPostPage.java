package com.coveros.test.website;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.coveros.test.selenium.pom.PageObject;

public class BlogPostPage extends PageObject {

	@FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/div/h1")
	private WebElement title;

	public String getPageTitle() {
		return driver.getTitle();
	}

	public String getBlogPostTitle() {
		return title.getText();
	}
}
