package Insider_Task.Pages;

import Insider_Task.Utilities.BrowserUtils;
import Insider_Task.Utilities.ConfigurationReader;
import Insider_Task.Utilities.Driver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {

    protected ExtentReports report;
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentTest extentLogger;

    @BeforeTest
    public void setReport (){
        report = new ExtentReports();

        String projectPath = System.getProperty("user.dir");
        String path = projectPath + "/test-output/report.html";

        htmlReporter = new ExtentHtmlReporter(path);
        report.attachReporter(htmlReporter);
        htmlReporter.config().setReportName("Insider_Task");
        report.setSystemInfo("Environment", "QA");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("Os", System.getProperty("os name"));

    }

    @BeforeMethod
    public void setupMethod() {
        Driver.getDriver().get(ConfigurationReader.get("url"));
        BrowserUtils.waitFor(2);
        new DashboardPage().cookies.click();
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws InterruptedException, IOException {
            if (result.getStatus() == ITestResult.FAILURE) {
            extentLogger.fail(result.getName());
            String screenShotPath = BrowserUtils.getScreenshot(result.getName());
            extentLogger.addScreenCaptureFromPath(screenShotPath);
            extentLogger.fail(result.getThrowable());
        }
            Thread.sleep(2000);
            Driver.closeDriver();
    }

    @AfterTest
    public void tearDownTest() {
        report.flush();
    }
}
