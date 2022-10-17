package Com.OrangeHRM.TestCases;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Com.Orange.qa.Pages.OrangeHRMHomepage;
import Com.Orange.qa.Pages.OrangeHRMLoginpage;
import Com.OrangeHRM.qa.base.TestBase;

public class HomepageTest extends TestBase{

	OrangeHRMLoginpage Loginpage;
	OrangeHRMHomepage  Homepage;
	
	public HomepageTest() throws IOException {
		super();
		
	}
	 public static Logger log = LogManager.getLogger(TestBase.class.getName());

	@BeforeMethod
	public void Setup() throws IOException {
	
		initialization();
		   log.info("Driver is initialized");

		Loginpage =new OrangeHRMLoginpage();
		Homepage = new OrangeHRMHomepage();
	}
	
	@Test
	public void EmployeeName() throws InterruptedException {
		
		Loginpage.Validateusername(props.getProperty("Username"), props.getProperty("Password"));
		Thread.sleep(3000);
		logger.info("Entered username");
		logger.info("Entered Password");
		Homepage.Reporterpage(props.getProperty("Name"));
		Assert.assertTrue(true);
		
	}
	
	@AfterMethod
	public void Teardown() {
		driver.quit();
	}
}
