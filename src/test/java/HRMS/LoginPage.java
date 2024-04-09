package HRMS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import A1A.Functions;

public class LoginPage extends Functions {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void toPage (String url) {
		driver.get(url);
	}
	
	@FindBy (css ="#outline-username")
	private WebElement username;
	
	@FindBy (css = "#outline-password")
	private WebElement password;
	
	@FindBy (xpath ="//button[@type='submit']")
	private WebElement loginButton;
	
	// Login method	
	public void login (String name, String pass) {
		username.sendKeys(name);
		password.sendKeys(pass);
		loginButton.click();
	}
	
	@FindBy (xpath = "//button[@type='button']")
	private WebElement showPass;	
	
	// confirm hide password method
	public boolean comfirmHidePassword (String pass) {
		password.sendKeys(pass);
		int passwordCount = pass.length();
		String passwordHide="";
		for (int i=0; i<passwordCount; i++) {
			passwordHide = passwordHide + "*";
		}		
		if ((password.getText().length()==passwordCount) && (password.getText()==passwordHide)) {
			return true;
		}
		else return false;			
	}
	
	@FindBy (css = "p")
	private WebElement message;
	
	// get message	
	public String getMessage () {
		return message.getText();
	}
	
	@FindBy (css ="h2")
	private WebElement screenName;
	
	// get screen name (h2)
	public String getScreenName() {
		return screenName.getText();
	}
}