package TestSuite;

import MiscellaneousUtility.DateAndTimeHelper;

import PageObject.loginPage;
import PropertiesFileUtility.PropertyReader;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class BaseTest
{
    WebDriver driver;
    ExtentReports extentReports;
    ExtentTest extentTest;
    loginPage loginPage;




    @BeforeTest
    void setup()
    {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        loginPage= new loginPage(driver);
        extentReports= new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("./TestExecutionResults/Reports/"+ DateAndTimeHelper.getCurrentTime("dd-MM-yyyy_hhmm")+".html");
        extentReports.attachReporter(sparkReporter);
        extentTest=extentReports.createTest("NewEmployeeData");

        driver.get(PropertyReader.loadProperties().getProperty("URL"));
        extentTest.log(Status.PASS,"Completed Navigation to URL");
        loginPage.login(PropertyReader.loadProperties().getProperty("Username"),PropertyReader.loadProperties().getProperty("Password"));
        extentTest.log(Status.PASS,"Completed entering user credentials");


    }

    @AfterTest
    void report(){
        driver.quit();
        extentReports.flush();
    }

}
