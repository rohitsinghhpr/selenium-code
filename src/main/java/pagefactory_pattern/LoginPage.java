package pagefactory_pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	private WebDriver driver;
	
	// using pagefactory annotations
	
	@FindBy(xpath = "//*[@id=\"userName\"]")
	private WebElement username;
	
	@FindBy(id = "userEmail")
	private WebElement useremail;
	
	@FindBy(xpath = "//*[@id=\"currentAddress\"]")
	private WebElement current_add;
	
	@FindBy(xpath = "//*[@id=\"permanentAddress\"]")
	private WebElement permanent_add;
	
	@FindBy(xpath ="//*[@id=\"submit\"]")
	private WebElement submit_btn;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	// page actions 
	
	public void enterUserName(String username) {
		this.username.sendKeys(username);
	}
	
	public void enterUserEamil(String useremail) {
		this.useremail.sendKeys(useremail);
	}
	
	public void enterCurrAdd(String curr_add) {
		this.current_add.sendKeys(curr_add);
	}
	
	public void enterParAdd(String par_add) {
		this.permanent_add.sendKeys(par_add);
	}
	
	public void sumitForm() {
	 this.submit_btn.click();
	}
	
}
