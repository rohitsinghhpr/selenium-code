package handlewebelement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenAllLinkOfDropDownInNewTab {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/elements");
		System.out.println(driver.getTitle());

		driver.findElement(By.className("element-group")).click();
		List<WebElement> li = driver.findElement(By.className("element-group")).findElement(By.className("menu-list"))
				.findElements(By.tagName("li"));

		for (int i = 0; i < li.size(); i++) {
			System.out.println(li.get(i).getText());
			
			// open a new tab here
			
			
		}
		

		/*
		 * goto demoqa locate element accordian and click count options click on options
		 * capture the url open that url in new tab.
		 * ...not working - leave right now, try another day.
		 */

	}

}
