package SeleniumUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Logger;




public class WebElementHelper {



    static public Logger log = Logger.getLogger("Logger");

    /**
     * This function is used to check whether WebElement is displayed or not and
     * return the result
     * @param element - WebElement
     * @return the result
     */
    public boolean isElementDisplayed(WebElement element) {

        boolean result = false;
        try {

            result = element.isDisplayed();

        }catch (NoSuchElementException ne) {
            result = false;

            ne.printStackTrace();
        }catch (Exception e) {
            result = false;

            e.printStackTrace();
        }

        return result;
    }


    /**
     * This function is used to check whether WebElement is enabled and
     * return the result
     * @param element
     * @return the result
     */
    public boolean isElementEnabled(WebElement element) {

        boolean result = false;
        try {
            result = element.isEnabled();
        }catch (NoSuchElementException ne) {
            result = false;
            log.warning("NoSuchElementException:"+ne.getMessage());
        }catch (Exception e) {
            result = false;
            log.warning("Exception:"+e.getMessage());
        }

        return result;
    }



    /**
     * This function is used to click on given WebElement
     * @param element - WebElement
     */
    public void clickOnWebElement(WebElement element) {
        try {
            element.click();
        }catch (Exception e) {
//            log.warning("Exception:"+e.getMessage());
            e.printStackTrace();
        }

    }

    /**
     * This function is used to enter the text into the given WebElement
     * @param element - WebElement
     * @param text - given text
     */
    public void sendKeysToWebElement(WebElement element, CharSequence text) {
        try {
            element.sendKeys(text);
        }catch (Exception e) {
//            log.warning("Exception:"+e.getMessage());
        }

    }

    /**
     * This function is to submit the given WebElement
     * @param element - WebElement
     */
    public void submitWebElement(WebElement element) {
        try {
            element.submit();
        }catch (Exception e) {
            log.warning("Exception:"+e.getMessage());
        }
    }


    /**
     * This function is used to get the expected value from attribute of WebElement
     * @param element - WebElement
     * @param attribute - attribute
     * @return the value of an attribute
     */
    public String getAttribute(WebElement element, String attribute) {

        String text="";
        try {
            text = element.getAttribute(attribute);
        }catch (Exception e) {
            log.warning("Exception:"+e.getMessage());
        }
        return text;
    }


    /**
     * This function is used to clear the Text in WebElement
     * @param element - WebElement
     */
    public void clearTextInWebElement(WebElement element) {
        try {
            element.clear();
        }catch (Exception e) {
            log.warning("Exception:"+e.getMessage());
        }
    }
    /**
     * This function is used to get the text from the given WebElement and return the same
     * @param element - WebElement
     * @return the text of an WebElement
     */
    public String getTextOfWebElement(WebElement element) {
        String text="";
        try {
            text = element.getText();
        }catch (IndexOutOfBoundsException indexEx) {
            log.warning("IndexOutOfBoundsException:"+indexEx.getMessage());
        }catch (Exception e) {
            log.warning("Exception:"+e.getMessage());
        }
        return text;
    }
    public String getTextContetOfWebElement(WebElement element) {
        String text="";
        try {
            text = element.getAttribute("textContent").trim();
        }catch (IndexOutOfBoundsException indexEx) {
            log.warning("IndexOutOfBoundsException:"+indexEx.getMessage());
        }catch (Exception e) {
            log.warning("Exception:"+e.getMessage());
        }
        return text;
    }

    public String getCSSValue(WebElement element, String propertyName) {
        String text="";
        try {
            text = element.getCssValue(propertyName);
        }catch (Exception e) {
            log.warning("Exception:"+e.getMessage());
        }
        return text;
    }


    public String getTextOfListWebElement(List<WebElement> elements, int index) {
        String text="";

        try {
            text = elements.get(index).getText();
            System.out.println(text);
        }catch (IndexOutOfBoundsException indexEx) {
            log.warning("IndexOutOfBoundsException:"+indexEx.getMessage());
        }catch (Exception e) {
            log.warning("Exception:"+e.getMessage());
        }
        return text;
    }

    public String getAttribiuteOfListWebElement(List<WebElement> elements, int index, String value) {
        String text="";

        try {
            text = elements.get(index).getAttribute(value);
        }catch (IndexOutOfBoundsException indexEx) {
            log.warning("IndexOutOfBoundsException:"+indexEx.getMessage());
        }catch (Exception e) {
            log.warning("Exception:"+e.getMessage());
        }
        return text;
    }


    /**
     * This function is used to click on given index in the given List of WebElements
     * @param elements - List of WebElements
     * @param index - index
     */
    public void clickOnListWebElement(List<WebElement> elements, int index) {
        try {
            elements.get(index).click();
        }catch (Exception e) {
            log.warning("Exception:"+e.getMessage());
            e.printStackTrace();
        }

    }


    /**
     * This function is used to get Tag name for given WebElement
     * @param webElement - WebElement
     * @return - tag name for given WebElement
     */
    public String getTagName(WebElement webElement) {
        String tagName = "";
        try {
            tagName = webElement.getTagName();
        }catch (NoSuchElementException ne) {
            log.warning("NoSuchElementException:"+ne.getMessage());
        }
        return tagName;
    }



    /**
     * Following are the Customized functions using Selenium functions
     */

    public boolean returnNoSuchElementException(WebElement element) {
        System.out.println("Checking whether given webelemnt is visible or not");
        boolean isFound = false;

        try {
            isFound = element.isDisplayed();
            System.out.println("webelemnt is found");
        } catch (Exception e) {
            System.out.println("cathcing the exceopting");
        }
        return isFound;
    }

    public String getCssValueOfListWebElement(List<WebElement> elements, int index, String value) {
        String text="";

        try {
            text = elements.get(index).getCssValue(value);
        }catch (IndexOutOfBoundsException indexEx) {
            log.warning("IndexOutOfBoundsException:"+indexEx.getMessage());
        }catch (Exception e) {
            log.warning("Exception:"+e.getMessage());
        }
        return text;
    }






    /**
     *
     * This method is used to pass dynamic text value  for FindElement
     * @param driver
     * @param value
     * @return
     */
    public WebElement dynamicFindElement(WebDriver driver,String value) {
        WebElement ele=	driver.findElement(By.xpath("//*[text()='"+value+"']"));
        return ele;

    }

    /**
     *
     * This method is used to pass dynamic text value for FindElements
     * @param driver
     * @param value
     * @return
     */
    public List<WebElement> dynamicFindElements(WebDriver driver,String value) {
        List<WebElement> ele=	driver.findElements(By.xpath("//*[text()='"+value+"']"));
        return ele;

    }

}

