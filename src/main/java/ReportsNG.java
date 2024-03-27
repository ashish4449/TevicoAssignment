
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportsNG {


	public static ExtentReports ExtentRep() {
		
	String Path=System.getProperty("user.dir")+"\\reports\\index.html";
	ExtentSparkReporter Report = new ExtentSparkReporter(Path);
	Report.config().setDocumentTitle("My first Report");

	ExtentReports Reporter = new ExtentReports();
	Reporter.attachReporter(Report);
	return Reporter;		
	}
}
