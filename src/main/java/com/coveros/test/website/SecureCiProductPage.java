package com.coveros.test.website;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.coveros.test.selenium.pom.PageObject;

/**
 * https://www.coveros.com/products/secure-ci/
 * 
 * @author brian
 *
 */
public class SecureCiProductPage extends PageObject{

	public BlogPostPage clickOnBlogPost (String blogPostName) {
		driver.findElement(By.linkText(blogPostName)).click();
		new WebDriverWait(driver, 10000)
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"recent-posts-4\"]/div/h5")));
		BlogPostPage page = factory.newPage(BlogPostPage.class);
		return page;
	}
}
