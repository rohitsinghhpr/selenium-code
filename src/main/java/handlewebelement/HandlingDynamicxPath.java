package handlewebelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingDynamicxPath {

	public static void main(String[] args) {
		
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        
        driver.get("https://www.softwaretestinghelp.com/xpath-functions/");
        WebElement tag = driver.findElement(By.xpath("//a[text()='Software Testing Help']"));
        System.out.println(tag.getAttribute("href"));
        
        WebElement tag2 = driver.findElement(By.xpath("//*[contains(text(),'This Tutorial Explains')]"));
        System.out.println("tag2 ->"+ tag2.getText());
        
        driver.quit();
        
	}

}
