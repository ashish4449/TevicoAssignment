import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class taskOne {
	public WebDriver d;

	public taskOne(WebDriver driver) {

		this.d = driver;
	}

	public void fileUpload() throws InterruptedException, AWTException {
		d.get("https://console.tevi.co/login");
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		d.findElement(By.id("signinSrEmail")).sendKeys("tevicouser@gmail.com");
		d.findElement(By.id("signupSrPassword")).sendKeys("@10724e2eF");
		d.findElement(By.cssSelector("button[type='submit']")).click();

		Thread.sleep(3000);
		String Currenturl = d.getCurrentUrl();
		Assert.assertEquals("https://console.tevi.co/home", Currenturl);
//		if(Currenturl.equalsIgnoreCase("https://console.tevi.co/home")) {
//			System.out.println("login successfully");
//		}else {
//			System.out.println("Invalid Creds");
//		}

		d.findElement(By.xpath("//span[normalize-space()='Well-Architected']")).click();

		WebElement testwork = d.findElement(By.xpath("//a[normalize-space()='TestWorklo...']"));
		((JavascriptExecutor) d).executeScript("arguments[0].click();", testwork);

		Thread.sleep(2000);
		
		WebElement pre= d.findElement(By.xpath("//a[normalize-space()='Previous']"));
		((JavascriptExecutor) d).executeScript("arguments[0].click();", pre);
		
		d.findElement(By.id("infrastructureArchitecturedocumentKey")).click();
		

		
		d.findElement(By.xpath("//button[normalize-space()='Choose file']")).click();
		Thread.sleep(2000);
//
		String filePath = "C:\\Users\\yowow\\OneDrive\\Desktop\\Ashish.pdf";

//		upload.sendKeys(filePath);
		//d.findElement(By.xpath("//button[normalize-space()='Choose file']")).sendKeys(filePath);
		WebElement fileInput = d.findElement(By.xpath("//input[@type='file']"));
		fileInput.sendKeys(filePath);
		
		
		StringSelection ss = new StringSelection(filePath);

		// Copy the file path to the clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		// Create an instance of Robot class
		Robot robot = new Robot();

		// Simulate pressing Enter to focus on the file upload dialog
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		// Simulate pressing Ctrl+V to paste the file path into the dialog
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		// Simulate pressing Enter to confirm the file upload
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

}
