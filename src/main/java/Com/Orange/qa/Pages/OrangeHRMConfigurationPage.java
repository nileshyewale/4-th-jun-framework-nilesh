package Com.Orange.qa.Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.OrangeHRM.qa.base.TestBase;

public class OrangeHRMConfigurationPage extends TestBase {

	
	@FindBy(xpath = "//span[contains(text(),'Configuration ')]")
	WebElement Config;
	
	
	@FindBy(xpath = "//ul[@class=\"oxd-dropdown-menu\"]//li")
	WebElement ConfigList;
	
	@FindBy(xpath = "//p[contains(text(),'Data Import')]")
	WebElement DataIMP;

	public OrangeHRMConfigurationPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	
	public String confiListbox() throws InterruptedException {
		
		Config.click();
		Thread.sleep(2000);
		ConfigList.getText();
		
		return ConfigList.getText();
	}
	
	public String DataImport() {		
		return DataIMP.getText();
	}
	
}
