package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class ClassLocator {

	public static void main(String[] args) {
        // main_content
		System.setProperty("webdriver.edge.driver","/home/rohit/Downloads/edgedriver_linux64/msedgedriver");
		WebDriver driver = new EdgeDriver();
        driver.get("https://rohitsinghhpr.github.io/qa-testing-3.0/qatesting-3.0.html");
        
        // so, findElement method return a WebEelement instance.
        
        System.out.println(driver.findElement(By.id("main_content")).getText());
        System.out.println(driver.findElement(By.id("seleced-ele")).getText());
        driver.quit();
	}

}
