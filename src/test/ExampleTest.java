package test;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExampleTest {
	WebDriver driver;
	
	@Before
	public void openWelcomePage() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		
		// open site
		driver.get("http://localhost:8080/CourseProject");
		Thread.sleep(1000);
	}
	
	@Test
	public void testRetryPasswordError() throws InterruptedException {
		WebElement element;
		
		// click personal account button
		element = driver.findElement(By.id("personal-account-button"));
		element.click();
		Thread.sleep(1000);
		
		// fill out registration form with "asdf" as username, "asdf" as password, and "qwer" as retry password
		element = driver.findElement(By.id("username"));
		element.sendKeys("asdf", Keys.TAB, "asdf", Keys.TAB, "qwer");
		Thread.sleep(1000);
		
		// submit form
		element = driver.findElement(By.id("submit"));
		element.click();
		Thread.sleep(1000);
		
		// make sure error message is displayed because retry password doesn't match password
		element = driver.findElement(By.id("retry-password-error"));
		Assert.assertEquals("Password doesn't match.", element.getText());
	}
	
	@After
	public void closePage() {
		// close site
		driver.quit();
	}
}

/***************************************************************************************
SETTING UP THE PROJECT

1. Make sure CourseProject is in your Eclipse workspace directory.
2. Open Eclipse.

3. Navigate to "Window" > "Preferences".
4. Select "Server" > "Runtime Environments" in the left menu.
5. Add Apache Tomcat Version 9.

6. Right-click on CourseProject in the Package Explorer, then select "Properties".

7. Select "Java Build Path" in the left menu.
8. Navigate to the "Libraries" tab and click on "Add Library...".
9. Add the JUnit 4 library.
10. Click on "Add External JARS...".
11. Add all items in the Selenium folder. Also add the MySQL connector.

12. Select "Deployment Assembly" in the left menu.
13. Click on "Add...", then select "Archives from File System".
14. Add the MySQL connector.

15. Open "MyDB.java" in the "db" package.
16. Change the "user" and "pass" variables to your username and password in MySQL.
17. Copy the code in the comments and paste it into MySQL Workbench.
18. In the MySQL Workbench Navigator, look under "SCHEMAS" > "coursedatabase" > "Tables".
19. If there are any tables, right-click on them and select "Drop Table...", then "Drop Now".
20. Click on the lightning button in MySQL Workbench to run the code you pasted.

21. Back in Eclipse, navigate to "Window" > "Preferences".
22. Select "General" > "Web Browser".
23. Click on "Use external web browser".
24. Select your preferred web browser.
***************************************************************************************/
