package SeleniumUtility;


import MiscellaneousUtility.DateAndTimeHelper;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import java.io.File;
import java.io.IOException;



public class TakeScreenshot {

    Logger log = LogManager.getLogger(TakeScreenshot.class);
    public static String screenshotFilePath;

    /**
     * This function is used to take the screenshot and name it with test case name plus current date time
     * and store it in the current directory screenshots folder
     * @param driver - Driver instance
     * @param result - ITestResult class instance
     * @return the screenshot folder path
     */
    public String captureScreenshot(WebDriver driver, ITestResult result) {

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        log.info("screenshot taken");
        String screenshotFilePath ="Sample path";

        try {
            FileUtils.copyFile(scrFile, new File(screenshotFilePath));
            log.info("copied the screenshot to the screenshot folder");

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return screenshotFilePath;
    }

    /**
     * This function is used to take the screenshot and name it with test case name plus current date time
     * and store it in the current directory screenshots folder
     * @param driver - Driver instance
     * @param testCaseName - test case name
     * @return the screenshot folder path
     */
    public static String captureScreenshot(WebDriver driver, String testCaseName) {

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        log.info("screenshot taken");
       screenshotFilePath = "./TestExecutionResults/Screenshots/"+testCaseName+".png";

        try {
            FileUtils.copyFile(scrFile, new File(screenshotFilePath));
//            log.info("copied the screenshot to the screenshot folder");
            System.out.println("copied the screenshot to the screenshot folder");

        } catch (IOException e) {
//            log.error("Exception:"+e);
            e.printStackTrace();
        }

        return screenshotFilePath;
    }

    public static String screenShot(WebDriver driver,String testCaseName)
    {
        TakesScreenshot ts=(TakesScreenshot)driver;
        File src= ts.getScreenshotAs(OutputType.FILE);
        File dest= new File("TestExecutionResults/Screenshots/"+testCaseName+".png");
        try {
            FileUtils.copyFile(src,dest);
            System.out.println("copied the screenshot to the screenshot folder");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return dest.getAbsolutePath();
    }

}






