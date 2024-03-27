import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class taskTwo {
	public WebDriver d;

	public taskTwo(WebDriver driver) {

		this.d = driver;
	}

	public void RequestForgetPassword() throws InterruptedException {

		d.get("https://console.tevi.co/home");
//		d.manage().window().maximize();
//		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
//		d.findElement(By.id("signinSrEmail")).sendKeys("tevicouser@gmail.com");
//		d.findElement(By.id("signupSrPassword")).sendKeys("@10724e2eF");
//		d.findElement(By.cssSelector("button[type='submit']")).click();

		WebElement el = d.findElement(By.xpath("(//input[@id='datatableSearch'])[3]"));
		((JavascriptExecutor) d).executeScript("arguments[0].click();", el);
		Thread.sleep(2000);
		el.sendKeys("tevi");

		List<WebElement> elements = d.findElements(By.cssSelector(".list-unstyled.list-py-3.mb-0 > li"));
		int numberOfElements = elements.size();
		System.out.println("Number of elements: " + numberOfElements);

		if (numberOfElements > 1) {
			System.out.println("More than one Account is found");
		} else {
			System.out.println("Working fine only one account found");
		}

		d.findElement(By.xpath("//a[contains(.,'Users')]")).click();
		Thread.sleep(2000);

		d.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(6000));
//        WebElement modalDialog = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal-content")));
//        d.switchTo().activeElement();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-content']")));

		d.findElement(By.xpath("(//input[@type='email'])[2]")).sendKeys("4shishkum4r@gmail.com");

		d.findElement(By.xpath("//div[@role='combobox']")).click();
		d.findElement(By.xpath("//span[normalize-space()='Read-only Admin']")).click();

		d.findElement(By.xpath("//button[normalize-space()='Save']")).click();

		// WebElement alert=d.findElement(By.id("toast-container"));
		WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));

		String msg = alert.getText();
		System.out.println(msg);
		// Assert.assertEquals("[x]User has been invited.",msg);
		System.out.println("user verified successfully");

		WebElement delete = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='btn-group']")));
		delete.click();

		d.findElement(By.xpath("//button[normalize-space()='Delete User']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-content']")));

		d.findElement(By.xpath("//button[normalize-space()='Delete']")).click();

		Thread.sleep(6000);
		String msg2 = d.findElement(By.id("toast-container")).getText();

		// String msg2=alert2.getText();

		System.out.println(msg2);

		d.findElement(By.xpath("//div[@class='text-start']")).click();

		d.findElement(By.xpath("//a[normalize-space()='Log Out']")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("//a[normalize-space()='Forgot Password?']")).click();

		Thread.sleep(2000);
		d.findElement(By.xpath("(//input[@id='signinSrEmail'])[1]")).sendKeys("tevicouser@gmail.com");
		Thread.sleep(2000);
		d.findElement(By.xpath("//button[normalize-space()='Submit']")).click();

		WebElement passReq = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		System.out.println(passReq.getText());

	}

}
