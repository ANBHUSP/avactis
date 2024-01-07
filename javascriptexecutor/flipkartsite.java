package javascriptexecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class flipkartsite {
  @Test
  
	  public void testJavaScriptCalls() throws Exception
		{
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.flipkart.com/");
				
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			String title = (String) js.executeScript("return document.title"); 
			
			//driver.getTitle();
			//long links = (Long) js.executeScript("var links = document.getElementsByTagName('A'); return links.length");
		
			
			//Locating element by link text and store in variable "Element"        		
	        WebElement Element = driver.findElement(By.linkText("YouTube"));
	        Thread.sleep(2000);

	        // Scrolling down the page till the element is found		
	        js.executeScript("arguments[0].scrollIntoView();", Element);
	        Thread.sleep(2000);
	        js.executeScript("arguments[0].click();", Element); 
	        Thread.sleep(5000);
	        
		
			driver.close();
		
  }
}
