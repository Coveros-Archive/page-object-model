package com.coveros.test.website;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.coveros.test.selenium.pom.PageObjectFactory;

/**
 * Example test cases for the blog post page of the Coveros Web Site. The
 * default configuration runs tests in Chrome on a Mac. Uncomment appropriate
 * code to run on Firefox and/or Windows.
 * 
 * @author brian
 *
 */
public class TestBlogPostPage {

	private CoverosHomePage homePage;
	private WebDriver driver;

	@BeforeClass
	public static void beforeClass() {

		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver/mac/chromedriver");
		// System.setProperty("webdriver.chrome.driver",
		// "src/main/resources/chromedriver/windows/chromedriver.exe");

		// System.setProperty("webdriver.gecko.driver",
		// "src/main/resources/geckodriver/windows/geckodriver.exe");

		// System.setProperty("webdriver.gecko.driver",
		// "src/main/resources/geckodriver/mac/geckodriver");

	}

	@Before
	public final void setUp() throws Exception {

		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		driver = new ChromeDriver(capabilities);

		// DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		// driver = new MarionetteDriver(capabilities);

		driver.manage().deleteAllCookies();

		PageObjectFactory factory = PageObjectFactory.newInstance(driver, "https://coveros.com");

		homePage = factory.newPage(CoverosHomePage.class);
		new WebDriverWait(driver, 10000)
				.until(ExpectedConditions.presenceOfElementLocated(CoverosHomePage.taglineElement));
	}

	@Test
	public void testBlogPostJourney() {
		SecureCiProductPage productPage = homePage.clickSecureCi();
		BlogPostPage blogPostPage = productPage.clickOnBlogPost("Setting Up Selenified Using Maven");

		assertEquals("Setting Up Selenified Testing Framework Using Maven | Coveros", blogPostPage.getPageTitle());
		assertEquals("Setting Up Selenified Using Maven", blogPostPage.getBlogPostTitle());
	}

	@After
	public void shutDown() {
		driver.close();
	}

}
