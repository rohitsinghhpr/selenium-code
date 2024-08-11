package handlewebelement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class HandlePop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver","/home/rohit/Downloads/edgedriver_linux64/msedgedriver");
		WebDriver driver = new EdgeDriver();
		driver.get("https://demo.automationtesting.in/Alerts.html");
		// clicking on the alert button
		driver.findElement(By.xpath("//*[@id=\"OKTab\"]/button")).click();
		// switching to alert box 
		driver.switchTo().alert();
		// clicking on the alertbox's OK button
		driver.switchTo().alert().dismiss();
		// ok with cancel
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"CancelTab\"]/button")).click();
		driver.switchTo().alert().accept(); // ok
		driver.findElement(By.xpath("//*[@id=\"CancelTab\"]/button")).click();
		driver.switchTo().alert().dismiss(); // cancle
		// textbox
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[3]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"Textbox\"]/button")).click();
		driver.switchTo().alert().sendKeys("this is my input");
		driver.switchTo().alert().accept();
	}

}
