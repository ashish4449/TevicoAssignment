import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class taskThree {
	public WebDriver d;

	public taskThree(WebDriver driver) {

		this.d = driver;
	}

	public void Region() throws InterruptedException {
		d.get("https://console.tevi.co/home");
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		d.findElement(By.id("signinSrEmail")).sendKeys("tevicouser@gmail.com");
		d.findElement(By.id("signupSrPassword")).sendKeys("@10724e2eF");
		d.findElement(By.cssSelector("button[type='submit']")).click();
		
		d.findElement(By.xpath("//button[normalize-space()='Skip For Now']")).click();

		WebElement el = d.findElement(By.xpath("(//input[@id='datatableSearch'])[3]"));
		((JavascriptExecutor) d).executeScript("arguments[0].click();", el);
		el.sendKeys("60011");

		Thread.sleep(3000);
		d.findElement(By.cssSelector("li[class='rounded p-2'] a[class='d-flex align-items-center text-decoration-none cursor-pointer']")).click();
		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(6000));
		
		Thread.sleep(3000);
		WebElement welcome = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='d-inline bg-white rounded px-2 py-1']")));
		System.out.println(welcome.getText());

	}
}
