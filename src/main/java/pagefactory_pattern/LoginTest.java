package pagefactory_pattern;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/text-box");
		
		LoginPage loginpage = new LoginPage(driver);
		
		loginpage.enterUserName("rohit");
		loginpage.enterUserEamil("rs907592@gmail.com");
		loginpage.enterCurrAdd("rangeet nagar, hapur");
		loginpage.enterParAdd("same as above");
		// submitting the form ! 
		loginpage.sumitForm(); 
		
	}

}
