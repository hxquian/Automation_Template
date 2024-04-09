package HRMS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import A1A.Functions;

public class Smoke extends Functions {
	
	WebDriver driver;
	public Smoke(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
// Get alert message
	@FindBy (css = ".MuiAlert-message")
	private WebElement alertMsg;
	
	public String getAlertMsg() {
		waitForElementToAppear(alertMsg);
		return alertMsg.getText();
	}
	
// Account screen
	@FindBy (css = ".css-4lptmi-MuiTypography-root")
	private WebElement accountName;
	
	@FindBy (css = ".css-1wyegzp-MuiButtonBase-root-MuiMenuItem-root")
	private WebElement myAccount;
	
	public void goToMyAcount () {
		accountName.click();
		myAccount.click();
	}
	
	@FindBy (id = "currentPassword")
	private WebElement inputCurrentPass;
	
	@FindBy (id = "newPassword")
	private WebElement inputNewPass;
	
	@FindBy (id = "confirmationPassword")
	private WebElement inputConfirmPass;
	
	@FindBy (css = ".css-1tkuvux-MuiButtonBase-root-MuiButton-root")
	private WebElement updateBtn;
	
	@FindBy (css = ".css-18o39so-MuiButtonBase-root-MuiButton-root")
	private WebElement confirmBtn;
	
	@FindBy (css = ".css-1ks0xe0-MuiFormHelperText-root")
	private WebElement errorMsg;
	
	public void changePassword(String oldPw, String newPw, String confirmPw) throws InterruptedException {
		inputCurrentPass.sendKeys(oldPw);
		inputNewPass.sendKeys(newPw);
		Thread.sleep(500);
		inputConfirmPass.sendKeys(confirmPw);
		Thread.sleep(500);
		updateBtn.click();
		WaitForElementToClickable(confirmBtn);
		confirmBtn.click();
	}
	
	public String getErrorMessage() {
		waitForElementToAppear(errorMsg);
		return errorMsg.getText();
	}
	
//Permission screen
	@FindBy (css = ".css-166ncg0-MuiButtonBase-root-MuiButton-root")
	private WebElement module_01;
	
	@FindBy (xpath = "//a[@href = '/permission']")
	private WebElement permissionTab;
	
	@FindBy (css = ".css-12gge1x-MuiButtonBase-root-MuiButton-root")
	private WebElement updatePermissionBtn;
	
	public void goToPerMissionScreen() {
		module_01.click();
		permissionTab.click();
		WaitForElementToClickable(updatePermissionBtn);		
	}
	
	public void updatePermission() {
		WaitForElementToClickable(updatePermissionBtn);
		updatePermissionBtn.click();
	}
}
