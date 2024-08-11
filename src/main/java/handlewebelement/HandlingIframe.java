package handlewebelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingIframe {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rohitsinghhpr.github.io/qa-testing-3.0/qatesting-3.0.html");
        
        // find the iframe and find the few element in iframe.
        
        String origin = driver.getWindowHandle();
        
        driver.findElement(By.xpath("//*[@id=\"alerts & windows\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"frames\"]")).click();
        
        WebElement frame = driver.findElement(By.tagName("iframe"));
		
        driver.switchTo().frame(frame);
        
        WebElement p1 = driver.findElement(By.tagName("p"));
        
        System.out.println(p1.getText());
        
        driver.switchTo().window(origin);
        
        driver.findElement(By.xpath("//*[@id=\"header-nav\"]/ul[1]/li/a")).click();
        
        System.out.println("----------------------------------------------------------------------");
        
        System.out.println(driver.getCurrentUrl());
        
        driver.quit();
        
	}

}
