package multiplebrowserintance;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class MultiBrowserLaunch extends Thread {
	public void run() {
		try {
			System.setProperty("webdriver.edge.driver", "/home/rohit/Downloads/edgedriver_linux64/msedgedriver");
			WebDriver driver = new EdgeDriver();
			driver.get("https://rohitsinghhpr.github.io/qa-testing-3.0/qatesting-3.0.html");
			System.out.println(driver.getTitle());
			System.out.println(Thread.currentThread().getName()+" is running");
			driver.quit();
		} catch (Exception e) {
			System.out.println("Exception is caugth");
		}
	}
}
