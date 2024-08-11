package handlewebelement;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SwitchWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver","/home/rohit/Downloads/edgedriver_linux64/msedgedriver");
		WebDriver driver = new EdgeDriver();
		driver.get("https://demo.automationtesting.in/Windows.html");
		//locating window link element
		driver.findElement(By.xpath("//*[@id=\"Tabbed\"]/a/button")).click();
		System.out.println(driver.getTitle()); // still on the parent window
		// switch to child window 
		// so do that we need window id
		Set <String> tabs = driver.getWindowHandles(); // return how many windows are open and their id.
		// need to read 
		for(String i:tabs) { // i contains id 
			String t = driver.switchTo().window(i).getTitle();
			System.out.println("tab/win id --> "+i);
			System.out.println("page title --> "+t);
			// closing the new tab 
			if(t.contains("Selenium")) {
				driver.close();
			}
		}
        //driver.quit();
	}

}
