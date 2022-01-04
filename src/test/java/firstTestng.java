import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class firstTestng {
	String baseURL = "https://www.selenium.dev/downloads/";
	WebDriver driver;

	@BeforeTest
	public void verifyHomePageTitle() {
		System.out.println("Verify home page title");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Desktop\\selenium\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get(baseURL);
		String expectedRes = "Downloads | Selenium";
		String ActualRes = driver.getTitle();
		Assert.assertEquals(expectedRes, ActualRes);
	}

	@AfterTest
	public void exitBrowser() {
		driver.quit();
		System.out.println("exit Browser");
	}

	@Test()
	public void cTest() {
		System.out.println("Hello from C method");
	}

	@Test(priority = -1)
	public void bTest() {
		System.out.println("Hello from B method");
	}

	@Test(priority = 3)
	public void aTest() {
		System.out.println("Hello from A method");
	}

	@Test()
	public void dTest() {
		System.out.println("Hello from D method");
	}

}