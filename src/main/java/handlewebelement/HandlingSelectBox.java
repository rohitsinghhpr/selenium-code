package handlewebelement;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingSelectBox {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
        WebDriverManager.chromedriver().setup();
        
        WebDriver driver = new ChromeDriver();
        driver.get("https://rohitsinghhpr.github.io/qa-testing-3.0/qatesting-3.0.html");
        driver.manage().window().maximize();
        driver.findElement(By.id("widgets")).click();
        driver.findElement(By.id("select_menu")).click();
         
        // handing group values 
        Select groupvalues = new Select(driver.findElement(By.xpath("//*[@id=\"main_content\"]/div/div/div/div[1]/select")));
        
        List <WebElement> alloptions = groupvalues.getOptions();
        
        for(WebElement op:alloptions) {
        	System.out.println(op.getText());
        }
        
        // selecting by index 
        groupvalues.selectByIndex(1);
        Thread.sleep(5000); // 5 seconds delay
        groupvalues.selectByIndex(2);
        Thread.sleep(5000); // 5 seconds delay
        groupvalues.selectByIndex(3);
        Thread.sleep(5000); // 5 seconds delay
        groupvalues.selectByIndex(4);        
        
        
        driver.quit();        
	}

}
