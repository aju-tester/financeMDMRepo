package SeleniumUtility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class JSExecutorHelper {



    /**
     * This function is used to scroll the page till given WebElement is found
     *
     * @param driver  - WebDriver instance
     * @param element - WebElement
     */
    public static void scrollByVisibleWebElement(WebDriver driver, WebElement element) {
        try {
            JavascriptExecutor js = ((JavascriptExecutor) driver);
            js.executeScript("arguments[0].scrollIntoView(true);", element);
        }catch (NoSuchElementException ne) {
            System.out.println("NoSuchElementException:"+ne.getMessage());
        }
    }

    /**
     * This function is used to click on given WebElement
     *
     * @param driver
     * @param element
     */
    public static void clickOnWebElement(WebDriver driver, WebElement element) {
        try {
            JavascriptExecutor js = ((JavascriptExecutor) driver);
            js.executeScript("arguments[0].click();", element);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This function is used to set the value into webElement
     *
     * @param driver
     * @param element
     * @param attribute
     * @param value
     */
    public static void setAttibuteValueIntoWebElement(WebDriver driver, WebElement element, String attribute,
                                                      String value) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('" + attribute + "', '" + value + "')", element);
        System.out.println("Setted value '" + value + "' into Webelement");
    }

    /**
     * This function is used to get the attribute value from given WebElement
     *
     * @param driver
     * @param element
     * @param attribute
     * @return
     */
    public static String getAttibuteValueIntoWebElement(WebDriver driver, WebElement element, String attribute) {
        String value = "";

        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            value = (String) js.executeScript("return arguments[0].getAttribute('" + attribute + "');", element);
            System.out.println("Fetching the attribute value '" + value + "' into Webelement");
        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return value;
    }

    /**
     * This function is used to scroll the web page till end.
     *
     * @param driver
     */
    public static void scrollByPage(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        js.executeScript("window.scrollBy(0,-document.body.scrollHeight || -document.documentElement.scrollHeight)", "");


    }

    /**
     * This function is used to open new window.
     *
     * @param driver
     */
    public static void openNewWindow(WebDriver driver) {

        try {

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.open('about:blank','_blank');");
        } catch (Exception e) {

        }

    }

    /**
     * This function is used to scroll till top of the page
     *
     * @param driver
     */
    public static void scrollToTopPage(WebDriver driver) {

        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0, -document.body.scrollHeight)");

        }catch (Exception e) {

        }
    }


    public static void scrollToLeftSide(WebDriver driver) {

        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(document.body.scrollHeight, 0)");

        }catch (Exception e) {

        }
    }

    public static void scrollToRight(WebDriver driver) {

        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(2000, 0)");

        }catch (Exception e) {

        }
    }

    public static void scrollToDown(WebDriver driver) {

        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,1000)");
            System.out.println("Scroll Down");

        }catch (Exception e) {

        }
    }

    public static String getTextWebElement(WebDriver driver, WebElement element) {
        String value = "";

        try {
            JavascriptExecutor js = (JavascriptExecutor)driver;
            value =  (String) js.executeScript("return arguments[0].getText();", element);;
            System.out.println("Fetching the attribute value '" + value + "' into Webelement");
        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return value;
    }



}
