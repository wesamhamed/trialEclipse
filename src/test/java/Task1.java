import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task1 {
	String baseURL = "http://demo.guru99.com/test/newtours/";
	WebDriver driver;
	
	@BeforeTest
	public void visitHomePage() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Desktop\\selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(baseURL);
		Assert.assertTrue(driver.getTitle().contains("Welcome: Mercury Tours"));
	}
	@Test
	public void visitRegisterPage() {
		WebElement registerBtn = driver.findElement(By.cssSelector("a[href='register.php']"));
		registerBtn.click();
		Assert.assertTrue(driver.getTitle().contains("Register: Mercury Tours"));
	}
	@AfterMethod
	public void goBackHomePage() {
		WebElement homeLink = driver.findElement(By.linkText("Home"));
		homeLink.click();
		Assert.assertTrue(driver.getTitle().contains("Welcome: Mercury Tours"));
	}
	@Test
	public void visitSupportPage() {
		WebElement supportBtn = driver.findElement(By.linkText("SUPPORT"));
		supportBtn.click();
		Assert.assertTrue(driver.getTitle().contains("Under Construction: Mercury Tours"));
	}
	
	@AfterTest
	public void exitBrowser() {
		driver.quit();
		System.out.println("exit Browser");
	}
	
}
