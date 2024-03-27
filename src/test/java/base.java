import java.awt.AWTException;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class base extends ReportsNG {

	public static WebDriver driver = new ChromeDriver();

	@BeforeTest
	public void extentConfig() {
		ExtentRep();
	}

	@Test
	public void first() throws InterruptedException, AWTException {
		taskOne taskOne = new taskOne(driver);
		taskOne.fileUpload();
		Thread.sleep(4000);
	}

	@Test
	public void second() throws InterruptedException, AWTException {
		taskTwo taskTwo = new taskTwo(driver);
		taskTwo.RequestForgetPassword();
		Thread.sleep(4000);
	}

	@Test
	public void third() throws InterruptedException {
		taskThree taskThree = new taskThree(driver);
		taskThree.Region();
	}

	public String ScreenShot(String string, WebDriver d) throws IOException {

		TakesScreenshot ss = (TakesScreenshot) d; // casting the driver to the screenshot mode
		File source = ss.getScreenshotAs(OutputType.FILE); // in which format the ss will save
		File file = new File(System.getProperty("user.dir") + "//reports//" + "ScreenShot" + ".png"); // save
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + "ScreenShot" + ".png";

	}
}
