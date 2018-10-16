package com.coveros.test.website;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.coveros.test.selenium.pom.PageObject;

/**
 * Generic page object that can be used to represent andy blog post page.
 * 
 * @author brian
 *
 */
public class BlogPostPage extends PageObject {

	private By titleElement = By.xpath("//*[@id=\"header\"]/div[2]/div/div/div/h1");

	public String getPageTitle() {
		return driver.getTitle();
	}

	public String getBlogPostTitle() {
		return driver.findElement(titleElement).getText();
	}
}
