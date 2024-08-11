package handlewebelement;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.net.URL;
import java.net.HttpURLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleBrokenLinks {
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";

	public static int passed_links =0,failed_links =0,error_links =0;
	public static void verifyURL(String url,int url_no){
    	try {
    		// URL and HTTPS ..............coming form the java.
    		// create a URL instance.
    		// make a HTTPS request. 
    		// check the status code.
    		
    		URL link = new URL(url);
    		HttpURLConnection connection = (HttpURLConnection) link.openConnection();
    		connection.setConnectTimeout(5000);
    		connection.connect();
    		
    		if(connection.getResponseCode() == 200) {
    			System.out.println(ANSI_GREEN + url_no + "=>" +url + " --> " + connection.getResponseMessage() + ANSI_RESET);
    			passed_links++;
    		}else {
    			System.out.println(ANSI_RED + url_no + "=>" + url + " --> " + connection.getResponseMessage() + ANSI_RESET);
    			failed_links++;
    		}
    		
    	}catch(Exception e) {
    		System.out.println(url_no +" => error "+e.getMessage());
    		error_links++;
    	}
    }
	public static void testResult() {
		// test result
        System.out.println("--------------------------------");
        System.out.println("passed links -> "+ passed_links);
        System.out.println("failed links -> "+ failed_links);
        System.out.println("error links -> "+ error_links);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.testingbaba.com");
        System.out.println("Page Title =>"+driver.getTitle());
        
        List<WebElement> links = driver.findElements(By.tagName("a"));
        
        System.out.println("total number of links "+ links.size());
        System.out.println("----------------------------");
        
        for(int i=0;i<links.size();i++) {
        	String url = links.get(i).getAttribute("href");
        	HandleBrokenLinks.verifyURL(url,i);	
        }
        HandleBrokenLinks.testResult();
        driver.quit();
        
        /*
         * goto - https://www.browserstack.com/guide/how-to-find-broken-links-in-selenium
         * fetch all link 
         * open one by one 
         * and check the status
         * */
        
	}

} 
