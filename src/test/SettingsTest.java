package test;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class SettingsTest {
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
		
		// navigate to enterprise
		element = driver.findElement(By.cssSelector("#navigation-pages-container ul li:nth-of-type(6)"));
		element.click();
		Thread.sleep(1000);
		Assume.assumeTrue(driver.getTitle().endsWith("Settings"));
	}
	
	@Test
	public void testRegistration() throws InterruptedException {
		WebElement element;

		// submit form
		element = driver.findElement(By.id("new-name"));
		element.sendKeys("qwer", Keys.TAB, "qwer", Keys.TAB, "qwer", Keys.TAB, "qwer");
		Thread.sleep(1000);
		element = driver.findElement(By.cssSelector("#color-settings label:nth-of-type(2)"));
		element.click();
		Thread.sleep(1000);
		element = driver.findElement(By.id("about"));
		element.sendKeys(Keys.CONTROL + "a", Keys.CONTROL, Keys.BACK_SPACE, "This user has nothing to say about themselves.");
		Thread.sleep(1000);
		element = driver.findElement(By.id("submit"));
		element.click();
		Thread.sleep(1000);

		// check for notice of successful settings change
		element = driver.findElement(By.id("notice-container"));
		Assert.assertTrue(element.getText().equals("Settings saved.\n" + "Account settings not saved due to password mismatch."));
	}
	
	@After
	public void closePage() {
		// close site
		driver.quit();
	}
}