package action_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Resizeable {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/resizable");
        
        System.out.println("Page Title =>"+driver.getTitle());
        
        driver.manage().window().maximize();
        
        WebElement resize = driver.findElement(By.xpath("//*[@id=\"resizableBoxWithRestriction\"]/span"));
        
        Actions action = new Actions(driver);
        action.moveToElement(resize).dragAndDropBy(resize,50,150).build().perform();
	}

}
