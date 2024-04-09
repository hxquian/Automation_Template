package HRMS;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SmokeTesting extends BaseTest {
	
  Smoke smoke;
	
  @BeforeMethod
  public void defineInstance() {
	  smoke = new Smoke(driver);
  }
	
  // Account screen
  @Test
  public void changePasswordAPI () throws InterruptedException {
	  smoke.goToMyAcount();
	  Thread.sleep(500);
	  smoke.changePassword("Quian1997", "Quian1997@", "Quian1997@");
	  Assert.assertEquals("Old password is not valid", smoke.getErrorMessage());
  }
  
  // Permission screen
  @Test
  public void permissionAPI() {
	  smoke.goToPerMissionScreen();
	  smoke.updatePermission();
	  Assert.assertEquals("Update successfully", smoke.getAlertMsg());
  }
}
