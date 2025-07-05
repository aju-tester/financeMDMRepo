package SeleniumUtility;

import java.util.logging.Logger;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;




public class AlertHandle {

    private static Logger log = Logger.getLogger("AlertHandle");
    /**
     * This function is used to accept the alert
     * @param driver
     */
    public static void acceptAlert(WebDriver driver) {

        driver.switchTo().alert().accept();
    }

    public static void dismissAlert(WebDriver driver) {

        driver.switchTo().alert().dismiss();
    }


    public static void AcceptIfAlertPresent(WebDriver driver) {

        if(isAlertPresent(driver)) {
            driver.switchTo().alert().accept();
        }

    }

    public static boolean isAlertPresent(WebDriver driver) {
        boolean result = false;

        try {
            driver.switchTo().alert();
            result = true;
        }catch (NoAlertPresentException e) {
            log.info("Alert is not present");
            System.out.println("Alert is not present");
            result = false;
        }

        return result;
    }



}
