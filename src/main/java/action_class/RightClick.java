package action_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClick {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rohitsinghhpr.github.io/qa-testing-3.0/qatesting-3.0.html");
        System.out.println("Page Title =>"+driver.getTitle());
        
        driver.manage().window().maximize();
        
        Actions action = new Actions(driver);
        
        WebElement alerts = driver.findElement(By.xpath("//*[@id=\"alerts & windows\"]"));
        WebElement seleced_ele = driver.findElement(By.id("seleced-ele"));
        
        action.contextClick(alerts).build().perform();
        action.click().build().perform();
        action.contextClick(seleced_ele).build().perform();
        
        driver.quit();
        
	}

}
