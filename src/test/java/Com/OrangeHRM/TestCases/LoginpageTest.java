package Com.OrangeHRM.TestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Com.Orange.qa.Pages.OrangeHRMLoginpage;
import Com.OrangeHRM.qa.base.TestBase;

public class LoginpageTest extends TestBase {

	OrangeHRMLoginpage Loginpage;
	
	public LoginpageTest() throws IOException {
		super();
	}
	
	 public static Logger log = LogManager.getLogger(TestBase.class.getName());
	
	@BeforeMethod
    public void Setup() throws IOException {
    	
       initialization();  	
	   log.info("Driver is initialized");

       Loginpage  = new OrangeHRMLoginpage();
       log.info("Driver is initialized");

    }
    
	@Test
	public void OrangeUername() throws InterruptedException {
		boolean UserID =Loginpage.Validateusername(props.getProperty("Username"), props.getProperty("Password"));		
		AssertJUnit.assertTrue(false);
		logger.warn("Login failed");
	}
	
	@Test
	public void OrangeHRMPageTitle() throws InterruptedException {
		String PageTitle =Loginpage.validatePageTitle(props.getProperty("Username"), props.getProperty("Password"));		
        AssertJUnit.assertEquals(PageTitle, props.getProperty("Title"));
	
	}
	@AfterMethod
	public void Teardown() {
		driver.quit();
		
	}
		
}