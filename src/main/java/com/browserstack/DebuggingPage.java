package com.browserstack;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DebuggingPage {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		String links[] = {
				"https://www.browserstack.com/guide/category/testing-on-cloud",
				"https://www.browserstack.com/guide/category/debugging",
				"https://www.browserstack.com/guide/category/best-practices",
				"https://www.browserstack.com/guide/category/tools-frameworks",
				"https://www.browserstack.com/guide/category/tutorials"
		};	
		
		File myfile = new File("/home/rohit/myfile.txt");
		FileWriter fw = new FileWriter(myfile);
		
		// for the page category
		for(int i=0;i<links.length;i++) {
			driver.get(links[i].concat("/page/1")); // init with page 1.
			int page = Integer.parseInt(driver.findElement(By.xpath("//a[@class=\"page-numbers\"][3]")).getText());
			
			WebElement ul = driver.findElement(By.className("tax-category__card-ul"));
			List<WebElement> h3 = ul.findElements(By.tagName("h3"));
			
			for(WebElement ele:h3) {
				System.out.println(ele.getText());
				fw.write(ele.getText()+"\n");
			}
						
			// for the category page navigation
			for(int j=2;j<page;j++) {
				driver.get(links[i].concat("/page/"+j));
				WebElement ul_2 = driver.findElement(By.className("tax-category__card-ul"));
				List<WebElement> h3_2 = ul_2.findElements(By.tagName("h3"));
				for(WebElement ele:h3_2) {
					System.out.println(ele.getText());
					fw.write(ele.getText()+"\n");
				}
			}
			fw.write(" "+"\n");
		}
		fw.close();
	}

}
