package handlewebelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDropDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rohitsinghhpr.github.io/qa-testing-3.0/qatesting-3.0.html");
        System.out.println(driver.getTitle());
        
        driver.manage().window().maximize();
        
        // locating the drop down button and clicking.
        driver.findElement(By.xpath("//*[@id=\"elements\"]")).click();
        
        // locating the options and clicking.
        driver.findElement(By.xpath("//*[@id=\"text_box\"]")).click();
        
        // matching the page title.
        if(driver.findElement(By.xpath("//*[@id=\"seleced-ele\"]/span[2]/u")).getText().equals("Text Box")){
        	
        	System.out.println("you are on the ritht page");
        	
        	// text box page - fill the form -------------------------------------------
        	
        	/*
        	 * locate the input web element
        	 * fill them 
        	 * and then submit
        	*/
        	
        	// name 
        	WebElement name = driver.findElement(By.id("tb_name"));
        	name.sendKeys("Rohit");
        	// email 
        	WebElement email = driver.findElement(By.id("tb_email"));
        	email.sendKeys("rs990f@gmail.com");
        	// current add
        	WebElement curr_add = driver.findElement(By.id("tb_current_add"));
        	curr_add.sendKeys("rafiq nagar, hapur");
        	// permanent add
        	WebElement per_add = driver.findElement(By.id("tb_permanent_add"));
        	per_add.sendKeys("new rangeet nagar, hapur");
        	// submit 
        	driver.findElement(By.xpath("//*[@id=\"tb_submit\"]")).submit();
        	
        	
        	// validating the input -------------------------------------------------------
        	
        	/*
        	 * check that column is display or not
        	 * match the input data with the output 
        	*/
        	
        }else {
        	System.out.println("test case failed / script failed");
        	driver.quit(); // not using the the close method due to one tab or window present only.
        }
	}

}
