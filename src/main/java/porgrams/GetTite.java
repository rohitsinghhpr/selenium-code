package porgrams;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class GetTite {

	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().fullscreen();
		
		driver.get("https://learncodewithdurgesh.com/course/spring-framework-tutorial-learn-code-with-durgesh/221");

		List<WebElement> h1 = driver.findElements(By.cssSelector("h1.text-zinc-800 "));

		for(int i=0;i<h1.size();i++){
			System.out.println(h1.get(i).getText());
		}

	}

}
