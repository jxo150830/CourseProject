package test;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
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
		
		// click personal account button
		element = driver.findElement(By.id("personal-account-button"));
		element.click();
		Thread.sleep(1000);
		Assume.assumeTrue(driver.getTitle().equals("Register"));
	}
	
	@Test
	public void testRegistration() throws InterruptedException {
		WebElement element;

		// submit empty form
		element = driver.findElement(By.id("submit"));
		element.click();
		Thread.sleep(1000);
		element = driver.findElement(By.id("username-error"));
		Assert.assertTrue(element.getText().equals("Username must be filled out."));
		element = driver.findElement(By.id("password-error"));
		Assert.assertTrue(element.getText().equals("Password must be filled out."));
		element = driver.findElement(By.id("retry-password-error"));
		Assume.assumeTrue(element.getText().equals("Retry-password must be filled out."));
		
		// submit form with "asdf" as username, "asdf" as password, and "qwer" as retry password
		element = driver.findElement(By.id("username"));
		element.sendKeys("asdf", Keys.TAB, "asdf", Keys.TAB, "qwer");
		element = driver.findElement(By.id("submit"));
		element.click();
		Thread.sleep(1000);
		element = driver.findElement(By.id("retry-password-error"));
		Assume.assumeTrue(element.getText().equals("Password doesn't match."));

		// submit form with "asdf" as username, "asdf" as password, and "asdf" as retry password
		element = driver.findElement(By.id("reset"));
		element.click();
		element = driver.findElement(By.id("username"));
		element.sendKeys("asdf", Keys.TAB, "asdf", Keys.TAB, "asdf");
		element = driver.findElement(By.id("submit"));
		element.click();
		Thread.sleep(1000);
		
		// check for notice of successful registration
		element = driver.findElement(By.id("notice-container"));
		Assert.assertTrue(element.getText().equals("Registration done. Please login."));
	}
	
	@After
	public void closePage() {
		// close site
		driver.quit();
	}
}