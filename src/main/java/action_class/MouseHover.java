package action_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHover {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://getbootstrap.com/docs/5.3/getting-started/introduction/");
        System.out.println("Page Title =>"+driver.getTitle());
        
        Actions action = new Actions(driver);
        
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"bd-docs-nav\"]/ul/li[1]/ul/li[1]"))).click().build().perform();
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"bd-docs-nav\"]/ul/li[1]/ul/li[2]"))).click().build().perform();
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"bd-docs-nav\"]/ul/li[1]/ul/li[3]"))).click().build().perform();
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"bd-docs-nav\"]/ul/li[1]/ul/li[4]"))).click().build().perform();
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"bd-docs-nav\"]/ul/li[1]/ul/li[5]"))).click().build().perform();
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"bd-docs-nav\"]/ul/li[1]/ul/li[6]"))).click().build().perform();
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"bd-docs-nav\"]/ul/li[1]/ul/li[7]"))).click().build().perform();
        action.contextClick().perform();
        
        driver.quit();
        
	}

}
