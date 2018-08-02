package test;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class MessageTest {
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
		element.sendKeys("asdf", Keys.TAB, "asdf", Keys.ENTER);
		Thread.sleep(1000);
		
		// navigate to profile
		element = driver.findElement(By.cssSelector("#navigation-pages-container ul li:nth-of-type(4)"));
		element.click();
		Thread.sleep(1000);
		element = driver.findElement(By.cssSelector("#user-select-container ul li:nth-of-type(1)"));
		element.click();
		Thread.sleep(1000);
		Assume.assumeTrue(driver.getTitle().endsWith("Profile"));
	}
	
	@Test
	public void testRegistration() throws InterruptedException {
		WebElement element;

		// submit empty form
		element = driver.findElement(By.id("submit"));
		element.click();
		Thread.sleep(1000);
		element = driver.findElement(By.id("subject-error"));
		Assert.assertTrue(element.getText().equals("Subject must be filled out."));
		element = driver.findElement(By.id("body-error"));
		Assert.assertTrue(element.getText().equals("Body must be filled out."));
		
		// submit filled-out form
		element = driver.findElement(By.id("subject"));
		element.sendKeys("Hello", Keys.TAB, "How are you doing?");
		Thread.sleep(1000);
		element = driver.findElement(By.id("submit"));
		element.click();
		Thread.sleep(1000);

		// check for notice of successful message
		element = driver.findElement(By.id("notice-container"));
		Assert.assertTrue(element.getText().equals("Message sent."));
	}
	
	@After
	public void closePage() {
		// close site
		driver.quit();
	}
}