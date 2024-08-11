package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CssID {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver","/home/rohit/Downloads/edgedriver_linux64/msedgedriver");
		WebDriver driver = new EdgeDriver();
		// present on local file.
        driver.get("file:///home/rohit/Desktop/samelink.html");
        System.out.println(driver.findElement(By.linkText("Google")).getText());
        driver.findElement(By.xpath("//*[@id='email-input-box']"));
        driver.quit();
	}

}
