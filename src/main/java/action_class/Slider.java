package action_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Slider {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/slider");
        System.out.println("Page Title =>"+driver.getTitle());
        
        driver.manage().window().maximize();
        
        WebElement slider = driver.findElement(By.xpath("//*[@id=\"sliderContainer\"]/div[1]/span/input"));
        
        Actions action = new Actions(driver);
        //Thread.sleep(5000);
        System.out.println("after sliding the silder.");
        action.dragAndDropBy(slider,25,100).build().perform();
        System.out.println(slider.getAttribute("value"));

	}

}
