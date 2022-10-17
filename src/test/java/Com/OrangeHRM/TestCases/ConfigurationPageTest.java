package Com.OrangeHRM.TestCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Com.Orange.qa.Pages.OrangeHRMConfigurationPage;
import Com.Orange.qa.Pages.OrangeHRMHomepage;
import Com.Orange.qa.Pages.OrangeHRMLoginpage;
import Com.OrangeHRM.qa.base.TestBase;

public class ConfigurationPageTest extends TestBase{



	OrangeHRMLoginpage Loginpage;
	OrangeHRMConfigurationPage  ConfiPage;
	

	public ConfigurationPageTest() throws IOException {
		
		
	}
  
	@BeforeMethod
	public void Setup() throws IOException {
	
		initialization();
		Loginpage =new OrangeHRMLoginpage();
		ConfiPage =new OrangeHRMConfigurationPage();
		
	}
	@Test
	 public void ConfigList() throws InterruptedException {
			boolean UserID =Loginpage.Validateusername(props.getProperty("Username"), props.getProperty("Password"));	
			
			driver.findElement(By.xpath("//span[contains(text(),'Configuration ')]")).click();
			List<WebElement>S1=driver.findElements(By.xpath("//ul[@class=\"oxd-dropdown-menu\"]//li"));
			
			System.out.println(S1.size());
			
			for(int i=0;i<S1.size();i++) {
				
				System.out.println(S1.get(i).getText());
				
				if(S1.get(i).getText().equals("Data Import")) {
					
					S1.get(i).click();
					break;
			}
				
			}
			}
	 
	 @AfterMethod
	 public void TearDown() {
		 driver.quit();
	 }
}
