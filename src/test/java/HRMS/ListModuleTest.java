package HRMS;

import org.junit.Assert;
import A1A.Retry;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ListModuleTest extends BaseTest {
	
	@Test //(retryAnalyzer = Retry.class)
	public void verifyLoginSucess() throws InterruptedException {
		ListModule.changeLanguage("en");
		Assert.assertEquals("Select the module that you want to use", login.getScreenName());		
	}
	
}