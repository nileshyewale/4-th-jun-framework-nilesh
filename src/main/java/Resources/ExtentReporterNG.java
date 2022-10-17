package Resources;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import net.bytebuddy.utility.RandomString;

public class ExtentReporterNG {

	

	static ExtentReports extent;
	
	public static ExtentReports getReportObject()
	{
		String Random = RandomString.make(5);
		String Name = "ExtentReport";

		String path =System.getProperty("user.dir")+"/reports/"+Name+""+Random+".html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("4 Jun Framework Results");
		reporter.config().setDocumentTitle("Automation Execution Results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("QA Automation Engineer", "Ranjeet Kendre");
		return extent;
		
	}
	   
	 
	 
}
