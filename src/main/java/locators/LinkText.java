package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class LinkText {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// main_content
				System.setProperty("webdriver.edge.driver","/home/rohit/Downloads/edgedriver_linux64/msedgedriver");
				WebDriver driver = new EdgeDriver();
				// present on local file.
		        driver.get("file:///home/rohit/Desktop/samelink.html");
		        System.out.println(driver.findElement(By.linkText("Google")).getText());
		        driver.quit();
	}
}
