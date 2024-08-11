package project.gplinks;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GPlink {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://freefireindiaapk.link/how-to-use-a-mortgage-to-finance-a-property-in-a-gated-community/");
		
		System.out.println(driver.getTitle());

	}

}
