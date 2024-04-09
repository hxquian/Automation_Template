package HRMS;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import A1A.Functions;

public class PositionAndCoreCompetency extends Functions {
	
	WebDriver driver;
	public PositionAndCoreCompetency(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy (xpath = "//p[contains(text(), 'Core')]")
	private WebElement postionAndCoreCompetencyTab;
	
	public void goToPostionAndCoreCompetencyTab() {
		postionAndCoreCompetencyTab.click();
	}
	
	@FindBy (xpath = "//button/span[contains(text(), 'POSITION')]")
	private WebElement positionTab;
	
	public void goToPositionTab() {
		positionTab.click();
	}
	
	@FindBy (xpath = "//button[text()='Add Position']")
	private WebElement openPopUpAddPositionBtn;
	
	@FindBy (id ="positionCode")
	private WebElement inputPositionCode;
	
	@FindBy (id ="positionName")
	private WebElement inputPositionName;
	
	@FindBy (id = "level")
	private WebElement selecLevel;
	
	@FindBy (id = "probationDuration")
	private WebElement selectProbationDuration;
	
	@FindBy (xpath = "//form//div[@id='office']")
	private WebElement selectOffice;
	
	@FindBy ( id= "organizationalLevel")
	private WebElement selectOrganizationalLevel;
	
	@FindBy (id = "listOfSelectedLevel")		
	private WebElement selectListOfSelectedLevel;
	
	@FindBy (xpath = "//li[@aria-selected='false']")
	private List<WebElement> selectedList;
	
	@FindBy (xpath = "//button[text()='Add']")
	private WebElement addPositionBtn;
	

	public void addRandomPosition() throws InterruptedException {
		WaitForElementToClickable(openPopUpAddPositionBtn);
		openPopUpAddPositionBtn.click();
		inputPositionCode.sendKeys("Code" + TestData.randomNumber(10000));
		inputPositionName.sendKeys("Name Test " + TestData.randomNumber(10000));
		WaitForElementToClickable(selecLevel);
		selecLevel.click();
		selectedList.get(TestData.randomNumber(selectedList.size())).click();
		WaitForElementToClickable(selectProbationDuration);
		selectProbationDuration.click();
		selectedList.get(TestData.randomNumber(selectedList.size())).click();
		WaitForElementToClickable(selectOffice);
		selectOffice.click();
		selectedList.get(0).click();
		WaitForElementToClickable(selectOrganizationalLevel);
		selectOrganizationalLevel.click();
		selectedList.get(TestData.randomNumber(selectedList.size())).click();
		WaitForElementToClickable(selectListOfSelectedLevel);
		selectListOfSelectedLevel.click();
		Thread.sleep(1000);
		selectedList.get(TestData.randomNumber(selectedList.size())).click();
		WaitForElementToClickable(addPositionBtn);
		addPositionBtn.click();		
	}
	
	@FindBy (css = ".css-levciy-MuiTablePagination-displayedRows")
	private WebElement paginationText;
	
	@FindBy(css = "svg[data-testid='KeyboardArrowRightIcon']")
	private WebElement paginationBtn;
	
	@FindBy (css = "svg[data-testid='KeyboardArrowLeftIcon']")
	private WebElement previousPageBtn;
	
	@FindBy (css = "svg[data-testid='AddCircleOutlineIcon']")
	private List<WebElement> addChildPostionBtn;
	
	@FindBy (css = "button[aria-label='Select columns']")
	private WebElement columnsBtn;
	
	@FindBy (xpath ="//button[text()='Hide all']")
	private WebElement hideAllBtn;
	
	private int pageClickAbleCount(String pageText) {
		String total = pageText.split(" of ")[1];
		int totalNumber = Integer.valueOf(total);
		int clickableCount = totalNumber/10;
		return clickableCount;
	}
	
	public Boolean createRandomChildPosition () {
		int maxClickableCount = pageClickAbleCount(paginationText.getText());
		int nextPageClickableCount = TestData.randomNumber(maxClickableCount);
		for (int i = 0; i<nextPageClickableCount; i++) {
			WaitForElementToClickable(paginationBtn);
			paginationBtn.click();
		}
		columnsBtn.click();
		hideAllBtn.click();
		paginationBtn.click();
		previousPageBtn.click();
		addChildPostionBtn.get(TestData.randomNumber(10)).click();
		try {
			inputPositionCode.sendKeys("Code" + TestData.randomNumber(10000));
			inputPositionName.sendKeys("Name Test " + TestData.randomNumber(10000));
			WaitForElementToClickable(selecLevel);
			selecLevel.click();
			selectedList.get(TestData.randomNumber(selectedList.size())).click();
			WaitForElementToClickable(selectProbationDuration);
			selectProbationDuration.click();
			selectedList.get(TestData.randomNumber(selectedList.size())).click();
			WaitForElementToClickable(addPositionBtn);
			addPositionBtn.click();
			return true;
		}		
		catch (NoSuchElementException e) {
			System.out.print("Lowest level");
			return false;
		}
	}
	
	
	
	
	
}
