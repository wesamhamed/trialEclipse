import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class HandlingScreenShot {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Desktop\\selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.newegg.com/");
		driver.manage().window().maximize();

//      ------------- screenshot----------
//		Screenshot screenshot = new AShot().takeScreenshot(driver);
//		File imageFile = new File(System.getProperty("user.dir") + "\\Downloads\\" + "image1.png");
//		ImageIO.write(screenshot.getImage(), "png", imageFile);
//		driver.quit();
		// -------------- Full Page Screenshot ------------------
		Screenshot fullPageScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1 * 1000))
				.takeScreenshot(driver);
		File fullImageFile = new File(System.getProperty("user.dir") + "\\Downloads\\" + "image1.png");
		ImageIO.write(fullPageScreenshot.getImage(), "png", fullImageFile);

//      ------------------element screenshot----------
		WebElement searchContainerElement =driver.findElement(By.className("header2021-search-inner"));
		Screenshot screenSearch = new AShot().takeScreenshot(driver, searchContainerElement);
		File ElementPath = new File("D:\\QA\\practice\\actualDesign.png"); 
		ImageIO.write(screenSearch.getImage(),"png", ElementPath);
		BufferedImage expectedImage = ImageIO.read(new File("D:\\QA\\practice\\expectedElementDesign.png"));
		BufferedImage actualImage = screenSearch.getImage();
        ImageDiffer result = new ImageDiffer(); 
        ImageDiff exectionResult = result.makeDiff(expectedImage, actualImage);
        Assert.assertFalse(exectionResult.hasDiff());
		
	}

}
