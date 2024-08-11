package wating;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.PageLoadStrategy;

public class ExplicitWait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.EAGER);

		WebDriver driver = new ChromeDriver();

		driver.get("https://demoqa.com/dynamic-properties");

		WebElement enble_after, color_change, visible_after;
		
		// enble after 5 seconds
	    enble_after = driver.findElement(By.id("enableAfter"));
		System.out.println(enble_after.isEnabled());

		// change color after 5 seconds
		color_change = driver.findElement(By.id("colorChange"));
	   System.out.println(color_change.getCssValue("color"));
	   
	   // explicit wait - to use explicit wait , we have  we a class called WebDriverWait;
	   
	   WebDriverWait ex_wait = new WebDriverWait(driver,5);
	   
	   ex_wait.until(ExpectedConditions.elementToBeClickable(enble_after));
	   System.out.println(enble_after.isEnabled());
	   
	   ex_wait.until(ExpectedConditions.attributeToBe(color_change, "color", "rgba(220, 53, 69, 1)"));
	   System.out.println(color_change.getCssValue("color"));
	   
	   visible_after = ex_wait.until(ExpectedConditions.presenceOfElementLocated(By.id("visibleAfter")));
	   
	   if(visible_after.isDisplayed()) {
		   visible_after.click();
		   System.out.println(visible_after.getText());
	   }
	  
	   System.out.println(driver.getTitle());
	  
       driver.quit();
	}
}
