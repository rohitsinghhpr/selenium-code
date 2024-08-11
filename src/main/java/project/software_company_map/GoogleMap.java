package project.software_company_map;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleMap {
    public static void main(String[] args) throws InterruptedException, IOException {

        String url = "https://www.google.com/maps/@28.7332,77.7795259,15z?entry=ttu";
        // ------------------------------------------------------------------------=>
        String searchQuery = "software company in noida sector 63"; //--------------------------- --====>
        // ------------------------------------------------------------------------=>
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait myWait = new WebDriverWait(driver, 5000);

        driver.get(url);

        WebElement searchBar = driver.findElement(By.id("searchboxinput"));

        searchBar.sendKeys(searchQuery);
        driver.findElement(By.id("searchbox-searchbutton")).click();

        WebElement sidebar = myWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='feed']")));

        WebElement end = null;

        while (true) {
            try {
                sidebar.sendKeys(Keys.DOWN);
                end = sidebar.findElement(By.xpath("//span[@class='HlvSq']"));
                System.out.println(end.getText());
                if (end != null) {
                    break;
                }
            } catch (Exception e) {
                end = null;
                System.out.println(e.getMessage());
            }
        }

        System.out.println("=====================================================");

        File myFile = new File("/home/rohit/Desktop/company-list/"+searchQuery+".md");
        myFile.createNewFile();
        FileWriter fw = new FileWriter(myFile);
        List<WebElement> company_name = driver.findElements(By.className("NrDZNb"));
        List<String> list = new LinkedList<String>();
        for (WebElement cn : company_name) {
            // System.out.println(cn.getText());
            list.add(cn.getText());
        }
        Collections.sort(list);
        for (String name : list) {
            // System.out.println(cn.getText());
            fw.write("* " + name + "\n");
        }
        fw.write("------------------------------------\n");
        fw.write("# " + "number" + company_name.size());
        fw.close();
        driver.close();
    }
}