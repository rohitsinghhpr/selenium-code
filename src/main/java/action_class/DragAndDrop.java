package action_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/droppable");
        System.out.println("Page Title =>"+driver.getTitle());
        
        Actions action = new Actions(driver);
        
        WebElement src = driver.findElement(By.id("draggable"));
        WebElement tar = driver.findElement(By.id("droppable"));
        
        // grabbing the element
        action.moveToElement(src).clickAndHold(src).build().perform();
        // release the element 
        action.moveToElement(tar).release().build().perform(); 
        
        Thread.sleep(5000);
        
        driver.navigate().refresh();
        
        action.dragAndDrop(src, tar).build().perform();
        
        
	}

}
