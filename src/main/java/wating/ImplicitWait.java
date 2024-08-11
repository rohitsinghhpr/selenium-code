package wating;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.PageLoadStrategy;

public class ImplicitWait {

	public static void main(String[] args) throws InterruptedException {
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

		// wating for properties to be change of elements
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //...not working
		
		// Thread.sleep(5000); //...wroking
		
		System.out.println(enble_after.isEnabled());
		System.out.println(color_change.getCssValue("color"));

		/*
		 * 
		 * // visible after 5 seconds visible_after =
		 * driver.findElement(By.id("visibleAfter"));
		 * System.out.println(visible_after.isDisplayed());
		 * 
		 */

	}

}
