package test;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class EnterpriseTest {
	WebDriver driver;
	
	@Before
	public void openWelcomePage() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		WebElement element;
		
		// open site
		driver.get("http://localhost:8080/CourseProject");
		Thread.sleep(1000);
		
		// click login button
		element = driver.findElement(By.id("login-button"));
		element.click();
		Thread.sleep(1000);

		// login
		element = driver.findElement(By.id("username"));
		element.sendKeys("vbnm", Keys.TAB, "vbnm", Keys.ENTER);
		Thread.sleep(1000);
		
		// navigate to enterprise
		element = driver.findElement(By.cssSelector("#navigation-pages-container ul li:nth-of-type(3)"));
		element.click();
		Thread.sleep(1000);
		Assume.assumeTrue(driver.getTitle().endsWith("Enterprise"));
	}
	
	@Test
	public void testRegistration() throws InterruptedException {
		WebElement element;

		// submit amount
		element = driver.findElement(By.id("amount"));
		element.sendKeys("3");
		Thread.sleep(1000);
		element = driver.findElement(By.id("submit"));
		element.click();
		Thread.sleep(1000);

		// check for notice of successful message
		element = driver.findElement(By.id("notice-container"));
		Assert.assertTrue(!element.getText().equals(""));
	}
	
	@After
	public void closePage() {
		// close site
		driver.quit();
	}
}