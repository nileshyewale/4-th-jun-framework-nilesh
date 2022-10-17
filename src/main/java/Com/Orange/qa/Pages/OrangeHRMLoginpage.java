package Com.Orange.qa.Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.OrangeHRM.qa.base.TestBase;

public class OrangeHRMLoginpage  extends TestBase{

	
	
	@FindBy(xpath = "//input[@name=\"username\"]")
	private WebElement Username;
	
	@FindBy(xpath = "//input[@name=\"password\"]")
	WebElement Password;
	
	@FindBy(xpath = "//button[@type=\"submit\"]")
	WebElement Loginbutton;
	
	@FindBy(xpath = "//p[@class=\"oxd-userdropdown-name\"]")
	WebElement HomepageUsername;
	
	
	@FindBy(xpath = "//i[@class=\"oxd-icon bi-caret-down-fill oxd-userdropdown-icon\"]")
	WebElement Dropdown;
	
	
	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	WebElement Logout;
	
	
	public OrangeHRMLoginpage() throws IOException {
				
		PageFactory.initElements(driver, this);
	}
		
	public boolean Validateusername(String UN, String PWD) throws InterruptedException {
		
		
		Username.sendKeys(UN);
		Thread.sleep(3000);
		
		Password.sendKeys(PWD);
		Thread.sleep(3000);

		Loginbutton.click();
		
		return HomepageUsername.isDisplayed();
		
	}
	
	public String validatePageTitle(String UN,String PWD) throws InterruptedException {
		
		Username.sendKeys(UN);
		Thread.sleep(3000);
		
		Password.sendKeys(PWD);
		Thread.sleep(3000);

		Loginbutton.click();
		
		return driver.getTitle();
	}
	
	public void Logout() {
		
	}
}
