package SeleniumUtility;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.logging.Logger;

public class MouseAndKeyboardActionsHelper {

    private  Logger log = Logger.getLogger("MouseAndKeyboardActionsHelper.class");

    public Actions actions;
    public WebDriver driver;
    public Robot robot;


    public void moveToWebElement(WebElement element) {

        try {
            actions.moveToElement(element).build().perform();
        } catch (Exception e) {

        }
    }

    /**
     * This function is used to right click on given WebElement
     *
     * @param element - WebElement
     */
    public void rightClickOnWebElement(WebElement element) {

        try {
            new Actions(driver).contextClick(element).build().perform();
        } catch (Exception e) {
            log.warning("Exception:" + e.getMessage());
        }

    }

    /**
     * This function is used to click on given WebElement
     *
     * @param driver  - driver
     * @param element - WebElement
     */
    public void clickOnWebElement(WebDriver driver, WebElement element) {

        try {
            new Actions(driver).click(element).build().perform();
        } catch (Exception e) {
            log.warning("Exception:" + e.getMessage());
        }

    }

    /**
     * This function is used to double click on given WebElement
     *
     * @param driver  - driver
     * @param element - element
     */
    public void doubleClick(WebDriver driver, WebElement element) {
        try {
            new Actions(driver).doubleClick(element).build().perform();
        } catch (Exception e) {
            log.warning("Exception:" + e.getMessage());
        }
    }

    public void mouseOverOnWebElement(WebDriver driver, WebElement element) {

        try {
            new Actions(driver).moveToElement(element).build().perform();
        } catch (Exception e) {
            log.warning("Exception:" + e.getMessage());
        }
    }

    /**
     * This function is used to click on WebElement and hold
     *
     * @param driver  - driver
     * @param element - WebElement
     */
    public void clickOnWebElementAndHold(WebDriver driver, WebElement element) {

        try {
            new Actions(driver).clickAndHold(element).build().perform();
        } catch (Exception e) {
            log.warning("Exception:" + e.getMessage());
        }
    }

    /**
     * This function is used to Moves the mouse from its current position by the
     * given offset
     *
     * @param scrollBarElement
     * @param xOffSet          - horizontal offset
     * @param yOffset          - vertical offset
     */
    public void moveByOffset(WebElement scrollBarElement, int xOffSet, int yOffset) {
        log.info("Moving the scroll bar from current position to '" + xOffSet + "', '" + yOffset + "' position");
        try {

            actions = new Actions(driver);
            actions.clickAndHold(scrollBarElement).moveByOffset(xOffSet, yOffset).build().perform();
            actions.release(scrollBarElement).build().perform();

        } catch (Exception e) {
            log.warning("Exception:" + e);
        }
        System.out.println("scrolled");
    }

    public void moveToElementAndClick(WebDriver driver, WebElement element) {
        try {
            actions = new Actions(driver);
            actions.moveToElement(element).build().perform();
            actions.click(element).build().perform();
        } catch (Exception e) {
            log.warning("Exception:" + e);
        }
    }

    public void resizeWebElement(WebDriver driver, WebElement element, int xOffset, int yOffset) {
        System.out.println("This function is used to resize the WebElement");

        actions = new Actions(driver);
        actions.moveToElement(element);
        actions.clickAndHold();
        actions.moveByOffset(xOffset, yOffset);
        actions.release();
        actions.perform();
    }
    // Method to Perform Keyboard Enter Action
    public void keyboardEnter(WebDriver driver) {
        try {
            Robot r1 = new Robot();
            r1.keyPress(KeyEvent.VK_ENTER);
            r1.keyRelease(KeyEvent.VK_ENTER);

        } catch (AWTException e) {
            e.printStackTrace();

        }
    }

    // Method to Perform Keyboard Down Action
    public void KeyBoardDownArrow() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_DOWN);

        robot.keyRelease(KeyEvent.VK_DOWN);

    }

    // Method to Perform Keyboard Up Action
    public void KeyBoardUpArrow() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_UP);

        robot.keyRelease(KeyEvent.VK_UP);

    }

    // Method to Perform Keyboard Right arrow Action
    public void KeyBoardRightArrow() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_RIGHT);

        robot.keyRelease(KeyEvent.VK_RIGHT);

    }

    // Method to Perform Delete operation using Keyboard Actions
    public void keyBoardDeleteAll(){
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyPress(KeyEvent.VK_DELETE);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_DELETE);
    }

    public void MouseHover(WebDriver driver, WebElement element)  {
        try {
            Actions a1 = new Actions(driver);
            a1.moveToElement(element).build().perform();
            System.out.println("Mouse Hover on element : " + element);

        } catch (Exception e) {
            System.out.println("Unable to find element : " + element);
        }
    }

    /**
     * This function is used to Scroll horizontally Right from its current position
     * by the
     *
     */
    public static void scrollElementRight(WebDriver driver, WebElement element) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementByXpath(element).scrollRight -= 450", "");
        System.out.println("Scroll horizontal to element : " + element);
    }

    public String scrollToElement(WebDriver driver, WebElement element)  {
        try {
            Thread.sleep(2000L);
//					WebElement element = driver.findElement(By.xpath(locatorValue));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", new Object[] { element });
            System.out.println("Scroll to element: " + element.getText());
            return "pass";
        } catch (Exception e) {
            return e.getMessage();
        }

    }
    public static void javascriptClick(WebDriver driver, String locatorValue) throws Exception {
        try {

            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement element = driver.findElement(By.xpath(locatorValue));
            js.executeScript("arguments[0].click();", new Object[] { element });
            System.out.println("Click on " + locatorValue + " using JavaScriptClick ");

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    public void scrollDown() throws AWTException {

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_END);
        robot.keyRelease(KeyEvent.VK_END);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }

    public void zoomIN() throws AWTException {
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ADD);
    }

    public void zoomOUT() throws AWTException {
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_MINUS);
    }

    public void zoomInForNumbOFTimes(int numberoftimetobeZoomedIn) {
        for (int i = 0; i < numberoftimetobeZoomedIn; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ADD);

        }
    }

    public void zoomOUTForNumbOFTimes(int numberoftimetobeZoomedIn) {
        for (int i = 0; i < numberoftimetobeZoomedIn; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_MINUS);

        }
    }

}
