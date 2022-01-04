import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class YoutubeSearch {
    // Configuring the system properties of chrome driver
//    System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Desktop\\selenium\\chromedriver.exe");
    //Initializing the browser driver
    WebDriver driver = new ChromeDriver();

    @BeforeTest
    public void visitWebsite(){

        driver.navigate().to("https://www.youtube.com/");

    }
//    @Test(priority = 1)
    @Test(enabled = false)
    public void maxWindow(){
        driver.manage().window().maximize();
    }

    @Test(priority = 2)
    public void enterSearchTerm(){
        WebElement searchInput = driver.findElement(By.id("search"));
        searchInput.sendKeys("Software Quality assurance");
    }
    @Test(priority = 3)
    public void submitSearchTerm(){
        WebElement searchButton = driver.findElement(By.id("search-icon-legacy"));
        searchButton.click();
    }
    @AfterTest
    public void terminateBrowser(){
        driver.close();
        driver.quit();
    }
}
