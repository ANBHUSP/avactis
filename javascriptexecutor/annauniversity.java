package javascriptexecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class annauniversity {
	@Test
	public void f() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://annauniv.edu/");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String title = (String) js.executeScript("return document.title");

		// Locating element by link text and store in variable "Element"
		WebElement Element = driver.findElement(By.linkText("DEPARTMENTS"));

		// Click on an element
		js.executeScript("arguments[0].click();", Element);
		Thread.sleep(5000);

		driver.close();
	}
}
