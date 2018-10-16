package com.coveros.test.website;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.coveros.test.selenium.pom.PageObject;

/**
 * Page object representing the Coveros web site home page.
 * 
 * https://www.coveros.com
 */
public class CoverosHomePage extends PageObject {

	private By secureCiLink = By.linkText("SecureCI");

	public static final By taglineElement = By.xpath("//*[@id=\"header\"]/div[2]/div/div/div[1]/h1");
	public SecureCiProductPage clickSecureCi() {
		WebElement element = driver.findElement(secureCiLink);
		element.click();
		new WebDriverWait(driver, 10000)
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"rpwe_widget-5\"]/div[1]/h5")));
		return factory.newPage(SecureCiProductPage.class);
	}
}
