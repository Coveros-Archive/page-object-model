package com.coveros.test.website;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.coveros.test.selenium.pom.PageObject;

public class CoverosHomePage extends PageObject {

	public SecureCiProductPage clickSecureCi() {
		WebElement element = driver.findElement(By.linkText("SecureCI"));
		element.click();
		new WebDriverWait(driver, 10000)
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"rpwe_widget-5\"]/div[1]/h5")));
		return factory.newPage(SecureCiProductPage.class);
	}
}
