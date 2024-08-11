package handlewebelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleNestedIframe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rohitsinghhpr.github.io/qa-testing-3.0/qatesting-3.0.html");
        
        // id of web page
        String origin = driver.getWindowHandle();
        
        driver.findElement(By.xpath("//*[@id=\"alerts & windows\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"nested_frames\"]")).click();
        
        // parent frame 
        WebElement parent_frame = driver.findElement(By.xpath("//*[@id=\"main_content\"]/div/iframe"));
        driver.switchTo().frame(parent_frame);
        System.out.println(driver.findElement(By.tagName("p")).getText());
        // id of parent frame id
        String Parent_origin = driver.getWindowHandle();
        
        // child frame 
        WebElement child_frame = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(child_frame);
        System.out.println(driver.findElement(By.tagName("p")).getText());
        
        // switching back to parent frame 
        driver.switchTo().window(Parent_origin);
        
        
        // switching back to the page 
        
        driver.quit();
        
	}

}
