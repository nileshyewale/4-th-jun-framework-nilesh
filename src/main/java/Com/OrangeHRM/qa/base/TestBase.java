package Com.OrangeHRM.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import Com.OrangeHRM.qa.Util.TestUtil;
import net.bytebuddy.utility.RandomString;

public class TestBase {
  
	
	
	public static WebDriver driver;
	public static Properties props;
	public static Logger logger;
	public TestBase() throws IOException {
		
		props = new Properties();
		
		FileInputStream ip = new FileInputStream("C:\\Users\\SHREEG\\OneDrive\\Desktop\\4Jun_FrameWork\\src\\main\\java\\Com\\OrangeHRM\\qa\\Config\\config.properties");
		
		props.load(ip);
	}
	
	
	@SuppressWarnings("deprecation")
	public static void initialization() {
				
		System.out.println(props.getProperty("browser"));
		String Browsername =props.getProperty("browser");
		
		if(Browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
			driver = new ChromeDriver();

//		}
//		else if(Browsername.equals("IE")) {
//		    System.setProperty("webdriver.IE.driver", "C:\\geckodriver.exe");    
//            driver  = new InternetExplorerDriver();
//    		
		}		
		//Firefox
		else if(Browsername.equals("FireFox")) {
		    System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");    
            driver = new FirefoxDriver();
			
		}
		else {
			System.out.println("No browser value is given");
		}
		
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
			
		driver.get(props.getProperty("url"));
	}
	
	public String getScreenshotAs(String testCaseName) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
				
		File source =ts.getScreenshotAs(OutputType.FILE);
		String Random = RandomString.make(5);		
		String destination = System.getProperty("user.dir")+"/Screenshot/"+testCaseName+""+Random+".png";
		
		FileUtils.copyFile(source, new File(destination));
		
		return destination;
		
	}
	
	
	
	
	
	
	
}