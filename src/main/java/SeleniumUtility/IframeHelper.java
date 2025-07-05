package SeleniumUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.logging.Logger;


public class IframeHelper {

    private static  Logger log = Logger.getLogger("IframeHelper.class");

    /**
     * This function will switch to the Frame using given index
     * @param driver - driver instance
     * @param index - index value
     *
     *
     */
    public static void switchFrameUsingIndex(WebDriver driver, int index) {
        log.info("switching to the frame using given index:"+index);

        try {
            driver.switchTo().frame(index);
        }catch (Exception e) {
            log.warning("Exception:"+e);
        }
    }

    /**
     * This function is used to switch to Frame using nameOrId
     * @param driver - driver instance
     * @param nameOrId - name or id
     *
     */
    public static void switchFrameUsingNameOrId(WebDriver driver, String nameOrId) {
        log.info("switching to the frame using given Name or Id:"+nameOrId);

        try {
            driver.switchTo().frame(nameOrId);
        }catch (Exception e) {
            log.warning("Exception:"+e);
        }
    }

    /**
     * This function is used to switch Frame using WebElement
     * @param driver - driver instance
     * @param element - WebElement
     *
     */
    public static void switchFrameUsingWebElement(WebDriver driver, WebElement element) {
        log.info("switching to the frame using given WebElement:"+element);

        try {
            driver.switchTo().frame(element);
        }catch (Exception e) {
            log.warning("Exception:"+e);
        }
    }

    /**
     * This function is used to switch parent frame
     * @param driver - driver instance
     *
     */
    public static void switchToParentFrame(WebDriver driver) {
        log.info("switching to the parent frame");

        try {
            driver.switchTo().parentFrame();
        }catch (Exception e) {
            log.warning("Exception:"+e);
        }
    }

    /**
     * This function is used to switch to default content
     * @param driver - driver instance
     *
     */
    public static void switchToDefaultContent(WebDriver driver) {
        log.info("switching to the default content or first frame on the page");

        try {
            driver.switchTo().defaultContent();
        }catch (Exception e) {
            log.warning("Exception:"+e);
        }
    }





}
