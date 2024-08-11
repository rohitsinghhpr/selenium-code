package project.gplinks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CloudHumanVerification {

	public static void main(String[] args) throws InterruptedException {

		/*
		 * locate the first iframe locate 
		 * then checkbox and clikc on it ...again return
		 * failed
		 */

		String gplink_url = "https://gplinks.co/zSmJ6YR";		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
        driver.get(gplink_url);
        
        System.out.println(driver.getTitle());
        
        // wating to be loaded;
        
        WebDriverWait mywait = new WebDriverWait(driver,5000);
        mywait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
        
        Thread.sleep(10000);
        
        WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"challenge-stage\"]/div/label/input"));
        checkbox.click();
        
        
        
	}

}
