package handlewebelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDynamicId {
	
	public static void findButtonAndClick(ChromeDriver driver) {
		//find button click button and then find id and print current_id value.
		driver.findElement(By.xpath("//*[@id=\"dynamicid\"]/div/button[1]")).click();
		String current_id = driver.findElement(By.xpath("//button[starts-with(@id,'its')]")).getAttribute("id");
		System.out.println("current id -> "+current_id);
	}

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rohitsinghhpr.github.io/qa-testing-3.0/qatesting-3.0.html");
        System.out.println(driver.getTitle());
        driver.findElement(By.xpath("//*[@id=\"New\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"dynamic_id\"]")).click();
        
        findButtonAndClick((ChromeDriver) driver);
        Thread.sleep(5000);
        findButtonAndClick((ChromeDriver) driver);
        Thread.sleep(5000);
        findButtonAndClick((ChromeDriver) driver);
        Thread.sleep(5000);
        findButtonAndClick((ChromeDriver) driver);
        Thread.sleep(5000);
        findButtonAndClick((ChromeDriver) driver);
        
        driver.quit();
	}

}
