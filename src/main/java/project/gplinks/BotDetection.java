package project.gplinks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BotDetection {

	public static void main(String[] args) throws InterruptedException {

		String my_url = "https://www.browserscan.net/bot-detection";		
		WebDriverManager.chromedriver().setup();
	
		
		WebDriver driver = new ChromeDriver();
        driver.get(my_url);
        driver.manage().window().maximize();
        
        System.out.println(driver.getTitle());      
        
        Thread.sleep(5000);
        
        WebElement status = driver.findElement(By.xpath("//*[@id=\"browserscan\"]/main/div/div/div[2]/strong[2]"));
        
        if(status.getText().equals("Normal")) {
        	System.out.println("Not a bot");
        }else {
        	System.out.println("Bot Dectected");
        }
        
	}

}
