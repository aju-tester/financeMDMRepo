package SeleniumUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TimeWaitHelper {




    public void threadSleep(int milliSeconds) {

        try {
            Thread.sleep(milliSeconds);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void explicitlyWaitVisibilityOfWebElement (WebDriver driver, int seconds, WebElement element)
    {
        try {


            WebDriverWait newWait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
            newWait.until(org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf(element));

        } catch (Exception e) {
            System.out.println("exception");
        }
    }

    public boolean isElementVisible(WebDriver driver, int seconds, WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        }
//        catch (TimeoutException e) {
//            System.out.println("Element is not visible after waiting for " + seconds + " seconds.");
//            return false;
//        }
        catch (Exception e) {
            return false;
        }
    }


    public void explicitlyWaitElementToBeClickable(WebDriver driver, int seconds, WebElement element) {

        try {

            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(seconds));
            wait.until(ExpectedConditions.elementToBeClickable(element));

        } catch (Exception e) {
            System.out.println("exception");
        }
    }

    public void explicitlyWaitInvisibilityOfWebElement(WebDriver driver, long seconds, WebElement element) {

        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
            wait.until(ExpectedConditions.invisibilityOf(element));

        } catch (Exception e) {
            System.out.println("exception");
        }
    }

    public void explicitlyWaitVisibilityOfAllWebElements(WebDriver driver, int seconds, List<WebElement> elements) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
            wait.until(ExpectedConditions.visibilityOfAllElements(elements));
        } catch (Exception e) {
            System.out.println("exception");
        }
    }

    public void explicitlyWaitTextToBePresentInElement(WebDriver driver, long seconds, WebElement element,
                                                       String text) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
            wait.until(ExpectedConditions.textToBePresentInElement(element, text));
        } catch (Exception e) {
            System.out.println("exception");
        }
    }

    public void explicitlyWaitAttributeToBe(WebDriver driver, long seconds, WebElement element, String attribute,
                                            String attributeValue) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
            wait.until(ExpectedConditions.attributeToBe(element, attribute, attributeValue));
        } catch (Exception e) {
            System.out.println("exception");
        }
    }

    public void attributeContains(WebDriver driver, long seconds, WebElement element, String attribute,
                                  String attributeValue) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
            wait.until(ExpectedConditions.attributeContains(element, attribute, attributeValue));
        } catch (Exception e) {
            System.out.println("exception");
        }
    }

    public void numberOfWindowsToBe(WebDriver driver, long seconds, int noOfWindows) {
        try {
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(seconds));
            wait.until(ExpectedConditions.numberOfWindowsToBe(noOfWindows));
        } catch (Exception e) {
            System.out.println("exception");
        }
    }

    /**
     * This function is used to wait until expected no. of elements to be more than given number
     * @param driver - WebDriver instance
     * @param seconds - seconds
     * @param xpathExpression - xpath expression
     * @param noOfElements - no of elements
     */
    public void explicitlyWaitNumberOfElementsToBeMoreThan(WebDriver driver, long seconds, String xpathExpression, int noOfElements) {
        try {
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(seconds));
            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(xpathExpression), noOfElements));
        } catch (Exception e) {
            System.out.println("exception");
        }
    }

    /**
     * This function is used to wait until expected no. of elements to be less than given number
     * @param driver - WebDriver instance
     * @param seconds - seconds
     * @param xpathExpression - xpath expression
     * @param noOfElements - no of elements
     */
    public void explicitlyWaitNumberOfElementsToBeLessThan(WebDriver driver, long seconds, String xpathExpression, int noOfElements) {
        try {
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(seconds));
            wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.xpath(xpathExpression), noOfElements));
        } catch (Exception e) {
            System.out.println("exception");
        }
    }

    /**
     * This function is used to wait until expected no. of elements to be the given number
     * @param driver - WebDriver instance
     * @param seconds - seconds
     * @param xpathExpression - xpath expression
     * @param noOfElements - no of elements
     */
    public void explicitlyWaitNumberOfElementsToBe(WebDriver driver, long seconds, String xpathExpression, int noOfElements) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
            wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath(xpathExpression), noOfElements));
        } catch (Exception e) {
            System.out.println("exception");
        }
    }


    public void implicitlyWait(WebDriver driver, long timeInSeconds) {
        driver.manage().timeouts().implicitlyWait(50, java.util.concurrent.TimeUnit.SECONDS);
    }
    public void pageLoadTimeout(WebDriver driver, long timeInSeconds) {
        driver.manage().timeouts().pageLoadTimeout(40,java.util.concurrent.TimeUnit.SECONDS);
    }




}

