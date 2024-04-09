package HRMS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import A1A.Functions;

public class ListModulePage extends Functions {

	WebDriver driver;

	public ListModulePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#demo-simple-select")
	private WebElement languagesButton;

	@FindBy(xpath = "//li[@data-value='VI']")
	private WebElement VI;

	@FindBy(xpath = "//li[@data-value='TH']")
	private WebElement TH;

	@FindBy(xpath = "//li[@data-value='KM']")
	private WebElement KM;

	@FindBy(xpath = "//li[@data-value='EN']")
	private WebElement EN;

	/**
	 * Change the language: en = English, vi = Vietnamese, th = Thai, kh = Khmer
	 * 
	 * @throws InterruptedException
	 */
	public void changeLanguage(String lan) throws InterruptedException {
		languagesButton.click();
		Thread.sleep(500);
		switch (lan) {
		case "en":
			EN.click();
			break;
		case "vi":
			VI.click();
			break;
		case "th":
			TH.click();
			break;
		case "kh":
			KM.click();
			break;
		}
	}
	/**
	 * Go to the module: Account, Organizational, Recruitment, PMS, Employees, Compensation, General, Training
	 * 
	 * @throws InterruptedException
	 */
	public void goToModule(String ModuleName) {
		String xpathOfModule = "//p[contains(text(), '" + ModuleName + "')]/following-sibling::button";
		driver.findElement(By.xpath(xpathOfModule)).click();
	}
	
	@FindBy (css = ".MuiAlert-message")
	private WebElement alertMsg;
	
	public String getAlertMsg() {
		waitForElementToAppear(alertMsg);
		return alertMsg.getText();
	}
}
