package HRMS;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class positionTest extends BaseTest {

	PositionAndCoreCompetency pac;

	@BeforeMethod
	public void setUpInstances() {
		pac = new PositionAndCoreCompetency(driver);
	}

	@SuppressWarnings("deprecation")
	@Test (invocationCount = 100)
	public void createPosition() throws InterruptedException {
		ListModule.goToModule("Organizational");
		Thread.sleep(1000);
		pac.goToPostionAndCoreCompetencyTab();
		pac.goToPositionTab();
		Thread.sleep(1000);
		pac.addRandomPosition();
		Assert.assertEquals("Add Success", ListModule.getAlertMsg());
	}
	
	@Test (invocationCount = 100)
	public void createChildPostion() throws InterruptedException {
		ListModule.goToModule("Organizational");
		pac.goToPostionAndCoreCompetencyTab();
		pac.goToPositionTab();
		Thread.sleep(1000);
		if (pac.createRandomChildPosition()) {
			Assert.assertEquals("Add Success", ListModule.getAlertMsg());
		}
	}
}
