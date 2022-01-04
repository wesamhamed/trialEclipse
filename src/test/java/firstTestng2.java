import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class firstTestng2 {

	String baseURL = "https://www.selenium.dev/downloads/";
	WebDriver driver = new ChromeDriver();

	@Test
	public void verifyHomePageTitle() {
		
		driver.get(baseURL);
		String expectedRes = "Downloads | Selenium";
		String ActualRes = driver.getTitle();
		Assert.assertEquals(expectedRes, ActualRes);
		driver.close();
	}
}