package project.software_company_map;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sector {
    public static void main(String[] args) throws InterruptedException, IOException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait myWait = new WebDriverWait(driver, 5);
        String url = "https://www.google.com/search?q=software+company+in+noida+sector+62&sca_esv=9d5b952a18faf0f8&sca_upv=1&biw=1328&bih=649&tbm=lcl&sxsrf=ADLYWIKo9nBrnaIVKQSAcop4TpiPXP6C7g%3A1720873246242&ei=HnGSZue6Dtrj2roPz7WOoAQ&ved=0ahUKEwjnwa60gKSHAxXasVYBHc-aA0QQ4dUDCAk&oq=software+company+in+noida+sector+62&gs_lp=Eg1nd3Mtd2l6LWxvY2FsIiNzb2Z0d2FyZSBjb21wYW55IGluIG5vaWRhIHNlY3RvciA2MkgAUABYAHAAeACQAQCYAQCgAQCqAQC4AQzIAQCYAgCgAgCYAwCSBwCgBwA&sclient=gws-wiz-local#rlfi=hd:;si:;mv:[[28.6295866,77.3746946],[28.610962299999997,77.35551219999999]];tbs:lrf:!1m4!1u3!2m2!3m1!1e1!1m4!1u2!2m2!2m1!1e1!2m1!1e2!2m1!1e3!3sIAE,lf:1,lf_ui:2";
        driver.get(url);

        WebElement searchbar = driver.findElement(By.xpath("//*[@id=\"APjFqb\"]"));
        searchbar.clear();
        searchbar.sendKeys("software testing company in noida sector 64");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER);

        WebElement sidbar;
        WebElement next = myWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Next")));

        // file handling
        File sector62 = new File("/home/rohit/Desktop/company-list/sector64-company-list.md");
        sector62.createNewFile();
        FileWriter fw = new FileWriter(sector62);
        List<String> company_name = new LinkedList<String>();
        HashSet<String> unique_company = new HashSet<String>();

        while (next != null) {
            try {
                next.click();
                sidbar = driver.findElement(By.id("search"));
                List<WebElement> ele = sidbar.findElements(By.className("dbg0pd"));
                if (!ele.isEmpty()) {
                    for (int i = 0; i < ele.size(); i++) {
                        // addling company name to list
                        company_name.add(ele.get(i).getText());
                    }
                } else {
                    System.out.println("sidebar not elements found");
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
            // updating the next ele
            try {
                next = myWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Next")));
            } catch (Exception e) {
                next = null;
                System.err.println(e.getMessage());
            }
        }

        driver.close();

        // adding in set
        for (String cn : company_name) {
            unique_company.add(cn);
        }
        // sorting the set
        List<String> list = new LinkedList<String>(unique_company);
        Collections.sort(list);
        // write the file unique name
        for (String uc : list) {
            fw.write("* " + uc + "\n");
        }

        fw.close();

    }
}
