package SeleniumUtility;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
/**
 *
 * Class Description => This class contains utility functions which are used to
 * select the options in Dropdown
 *
 */
public class DropdownHelper {


   WebDriver driver;
    TimeWaitHelper timeWaitsHelper = new TimeWaitHelper();
    WebElementHelper webElementHelper = new WebElementHelper();

    public DropdownHelper() {

        super();
    }

    public DropdownHelper(WebDriver driver) {
        super();
        this.driver = driver;
    }

    public void selectByVisibleText(WebElement element, String option) {
        try {
            Select select = new Select(element);
            select.selectByVisibleText(option);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectByValue(WebElement element, String value) {
        try {
            Select select = new Select(element);
            select.selectByValue(value);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectByIndex(WebElement element, int index) {
        try {
            Select select = new Select(element);
            select.selectByIndex(index);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deselectAll(WebElement element) {
        try {
            Select select = new Select(element);
            select.deselectAll();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deselectByIndex(WebElement element, int index) {
        try {
            Select select = new Select(element);
            select.deselectByIndex(index);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deselectByValue(WebElement element, String value) {
        try {
            Select select = new Select(element);
            select.deselectByValue(value);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deselectByVisibleText(WebElement element, String text) {
        try {
            Select select = new Select(element);
            select.deselectByVisibleText(text);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<WebElement> getAllSelectedOptions(WebElement element) {

        List<WebElement> elements = null;

        try {
            Select select = new Select(element);
            elements = select.getAllSelectedOptions();
            return elements;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return elements;
    }

    public List<WebElement> getAllOptions(WebElement element) {

        List<WebElement> elements = null;

        try {
            Select select = new Select(element);
            elements = select.getOptions();
            return elements;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return elements;
    }

    public WebElement getFirstSelectedOption(WebElement element) {
        WebElement selectedOption = null;
        try {
            Select select = new Select(element);
            selectedOption = select.getFirstSelectedOption();
            return selectedOption;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return selectedOption;
    }

    public boolean isMultiple(WebElement element) {
        boolean isMultiple = false;
        try {
            Select select = new Select(element);
            isMultiple = select.isMultiple();
            return isMultiple;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return isMultiple;
    }
    public void selectByOption(WebElement element, List<WebElement> options, String expectedOption) {

        TimeWaitHelper timeWaitsHelper = new TimeWaitHelper();
        try {
            timeWaitsHelper.explicitlyWaitElementToBeClickable(driver, 10, element);
            element.click();
            timeWaitsHelper.explicitlyWaitVisibilityOfAllWebElements(driver, 10, options);

            for(WebElement actualOption: options) {

                if(actualOption.getAttribute("textContent").equals(expectedOption)) {

                    JSExecutorHelper.scrollByVisibleWebElement(driver,actualOption);
                    timeWaitsHelper.explicitlyWaitElementToBeClickable(driver,10,actualOption);
                    actualOption.click();
                    System.out.println("Clicked '"+expectedOption+"'");
                    return;
                }
            }
        }catch (Exception e) {
            System.out.println("Exception:"+e.getMessage());
        }
    }

    public void selectByVisibleText(WebElement element,List<WebElement> options, String expectedOption) {

        TimeWaitHelper timeWaitsHelper = new TimeWaitHelper();
        MouseAndKeyboardActionsHelper mouseAndKeyboardActionsHelper=new MouseAndKeyboardActionsHelper();


        try {


            timeWaitsHelper.explicitlyWaitVisibilityOfAllWebElements(driver,15,options);
            mouseAndKeyboardActionsHelper.mouseOverOnWebElement(driver,options.get(0));
            mouseAndKeyboardActionsHelper.moveByOffset(element,0,300);
            timeWaitsHelper.explicitlyWaitVisibilityOfAllWebElements(driver,10,options);
            for(WebElement actualOption: options) {
                int size=options.size();
                System.out.println(actualOption.getText()+size);
                timeWaitsHelper.explicitlyWaitVisibilityOfWebElement(driver,5,actualOption);
                if(actualOption.getText().equals(expectedOption)) {
                    System.out.println(actualOption.getText()+" = "+expectedOption);
                    timeWaitsHelper.explicitlyWaitElementToBeClickable(driver,3,actualOption);
                    JSExecutorHelper.clickOnWebElement(driver,actualOption);
                    System.out.println("Clicked '"+expectedOption+"' in DropDown");
                    return;
                }
            }
        }catch (Exception e) {
            System.out.println("Exception:"+e.getMessage());
        }
    }


    /**
     * This function is used to select the given option using given attribute value in the Dropdown

     * @param options - Dropdown options WebElement List
     * @param attribute - attribute value
     * @param expectedOption - expected option to be selected
     */
    public void selectByValue(List<WebElement> options, String attribute, String expectedOption) {

        System.out.println("Selecting option '"+expectedOption+"' in dropdown using attribute"+attribute);
        MouseAndKeyboardActionsHelper mouseAndKeyboardActionsHelper=new MouseAndKeyboardActionsHelper();
        try {

            for(WebElement actualOption: options) {
                System.out.println("actualOption = "+actualOption.getAttribute(attribute));
                if(actualOption.getAttribute(attribute).equals(expectedOption)) {

                    mouseAndKeyboardActionsHelper.mouseOverOnWebElement(driver,actualOption);
                    timeWaitsHelper.explicitlyWaitElementToBeClickable(driver,10,actualOption);
                    JSExecutorHelper.clickOnWebElement(driver,actualOption);
                    //actualOption.click();
                    System.out.println("Clicked '"+expectedOption+"'");
                    //	log.info("Clicked '"+expectedOption+"'");
                    return;
                }
            }
        }catch (Exception e) {
            //log.error("Exception:"+e.getMessage());
            System.out.println("Exception: "+e.getMessage());
        }
    }

    /**
     * This function is used to select the given option using given attribute value in the Dropdown
     * @param element - Dropdown TextBox/expand button to open
     * @param options - Dropdown options WebElement List
     * @param attribute - attribute value
     * @param expectedOption - expected option to be selected
     */
    public void selectByValue(WebElement element, List<WebElement> options, String attribute, String expectedOption) {
        System.out.println("Selecting option '"+expectedOption+"' in dropdown using attribute"+attribute);
        try {

            timeWaitsHelper.explicitlyWaitElementToBeClickable(driver,10,element);
            element.click();

            for(WebElement actualOption: options) {
                System.out.println("Drop values = "+actualOption.getAttribute(attribute));
                if(actualOption.getAttribute(attribute).equals(expectedOption)) {


                    actualOption.click();
                    System.out.println("Clicked '"+expectedOption+"'");
                    return;
                }
            }
        }catch (Exception e) {
            System.out.println("Exception:"+e.getMessage());
        }
    }

    public static void selectByValueWithPrefix(WebElement textbox, List<WebElement> options, String attribute, String expectedOption) {

        System.out.println("Selecting option '"+expectedOption+"' in dropdown using attribute"+attribute);
        TimeWaitHelper timeWaitsHelper = new TimeWaitHelper();
        try {

            textbox.clear();
            timeWaitsHelper.threadSleep(500);
            textbox.sendKeys(expectedOption);
            timeWaitsHelper.threadSleep(500);

            for(WebElement actualOption: options) {

                if(actualOption.getAttribute(attribute).equals(expectedOption)) {

                    actualOption.click();
                    System.out.println("Clicked '"+expectedOption+"'");
                    return;
                }
            }
        }catch (Exception e) {
            //log.error("Exception:"+e.getMessage());
            System.out.println("Exception: "+e.getMessage());
        }
    }

    public void selectByVisibleTextWithPrefix(WebElement textBoxElement, List<WebElement> options, String expectedOption) {

        TimeWaitHelper timeWaitsHelper = new TimeWaitHelper();
        try {
            textBoxElement.sendKeys(expectedOption);
            timeWaitsHelper.threadSleep(1000);
            timeWaitsHelper.explicitlyWaitVisibilityOfAllWebElements(driver, 20, options);

            for(WebElement actualOption: options) {

                if(actualOption.getText().equals(expectedOption)) {
                    actualOption.click();
                    System.out.println("Clicked '"+expectedOption+"'");
                    timeWaitsHelper.threadSleep(1000);
                    return;
                }
            }
        }catch (Exception e) {
            //log.error("Exception:"+e.getMessage());
            System.out.println("Exception: "+e.getMessage());
        }
    }

    /**
     * This function is used to select option in given Dropdown
     * @param dropdownExpandElement - dropdownExpandElement
     * @param optionsInDropdown - list of options in given Dropdown
     * @param primaryIndustry - expected option to be selected
     */
    public void selectOptionInDropdown(WebElement dropdownExpandElement, List<WebElement> optionsInDropdown,
                                       String primaryIndustry) {

        webElementHelper.clickOnWebElement(dropdownExpandElement);
        timeWaitsHelper.threadSleep(1000);

        for (int i = 0; i < optionsInDropdown.size(); i++) {
            JSExecutorHelper.scrollByVisibleWebElement(driver, optionsInDropdown.get(i));
            String actualPrimaryIndustry = webElementHelper.getTextOfListWebElement(optionsInDropdown, i);
            System.out.println("ss:" + actualPrimaryIndustry + ":");

            if (actualPrimaryIndustry.equals(primaryIndustry)) {
                webElementHelper.clickOnListWebElement(optionsInDropdown, i);
                System.out.println("Clicked option:" + primaryIndustry);
                break;
            }
        }
        timeWaitsHelper.threadSleep(1000);
    }








}
