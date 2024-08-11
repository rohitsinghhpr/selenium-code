package handlewebelement;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingTabs {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rohitsinghhpr.github.io/qa-testing-3.0/qatesting-3.0.html");
        
        driver.findElement(By.xpath("//*[@id=\"alerts & windows\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"browser_window\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"main_content\"]/div/div[1]/a")).click();
        
        // storing the origin win/tab id;
        String origin = driver.getWindowHandle();
        
        Set<String> alltabs = driver.getWindowHandles();
        
        for(String tab:alltabs) {
        	System.out.println(tab);
            // switching to new tab  
        	if(!tab.equals(origin)) {
        		driver.switchTo().window(tab);
        		System.out.println(driver.getTitle());
        		driver.findElement(By.xpath("//textarea[@title='Search']")).sendKeys("testing baba");
        		driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]")).click();
        	}
        }
        
        driver.switchTo().window(origin);
        driver.findElement(By.xpath("//*[@id=\"header-nav\"]/ul[1]/li/a")).click();
        
        driver.quit();
        
        
	}
	

}
