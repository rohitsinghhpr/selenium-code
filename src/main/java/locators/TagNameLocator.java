package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TagNameLocator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// main_content
				System.setProperty("webdriver.edge.driver","/home/rohit/Downloads/edgedriver_linux64/msedgedriver");
				WebDriver driver = new EdgeDriver();
		        driver.get("https://rohitsinghhpr.github.io/qa-testing-3.0/qatesting-3.0.html");
		        System.out.println(driver.findElement(By.tagName("h2")).getText());
		        driver.quit();
	}

}
