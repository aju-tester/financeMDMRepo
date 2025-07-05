package PageObject;

import SeleniumUtility.MouseAndKeyboardActionsHelper;
import SeleniumUtility.TakeScreenshot;
import SeleniumUtility.TimeWaitHelper;
import SeleniumUtility.WebElementHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;

public class HumanResources  {

    WebDriver driver;
    WebElementHelper webElementHelper = new WebElementHelper();
    TimeWaitHelper timeWaitHelper = new TimeWaitHelper();
    MouseAndKeyboardActionsHelper mouseAndKeyboardActionsHelper = new MouseAndKeyboardActionsHelper();
    TakeScreenshot takeScreenshot = new TakeScreenshot();


    public HumanResources(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()='Employees']")
    private WebElement Employees;

    @FindBy(xpath = "//span[text()='Employees']")
    private WebElement employeeHeader;

    @FindBy(xpath = "//div[contains(@class,'fixedDataTableCellLayout_main public_fixedDataTableCell_main ')]")
    private List<WebElement> ListOfHeaders;

    @FindBy(xpath = "//button[@aria-label='Grid options']")
    private WebElement MoreOption;

    @FindBy(xpath = "//span[text()='Insert columns...']")
    private WebElement InsertColumn;

    @FindBy(xpath = "(//input[@class='textbox field displayoption viewMarker alignmentLeft' and @type='text'])[4]")
    private WebElement filterSearchBox;

    @FindBy(xpath = "//div[contains(@id,\"FormControlFieldSelector_Grid_Selected\")]//div//div//div//span")
    private WebElement CheckBox;

    @FindBy(xpath = "//span[text()='Update']")
    private WebElement UpdateButton;

    @FindBy(xpath = "//input[contains(@name,'AEGLegacyEmployeeId_Input_')]")
    private WebElement textBoxInLegacyEmpIdFilter;

    @FindBy(xpath = "//button[contains(@name,'_ApplyFilters')]")
    private WebElement applyButtonInLegacyEmpIdFilter;

    @FindBy(xpath = "//input[starts-with(@id, 'Name_List_') and contains(@id, '_0_0_input')]")
    private WebElement EmployeeName;





    // xpaths for bank acounts section

    @FindBy(xpath = "//span[text()='Bank accounts']")
    private WebElement bankAccountsButton;

    @FindBy(xpath = "//span[contains(@id,'HcmWorkerBankAccount_') and text()='New']")
    private WebElement NewButton;

    @FindBy(xpath = "//input[@name='HcmWorkerBankAccount_Name']")
    private WebElement BankName;

    @FindBy(xpath = "//input[@name='HcmWorkerBankAccount_AccountId']")
    private WebElement AccuntIdentificationNum;

    @FindBy(xpath = "//input[@name='Identification_AccountNum']")
    private WebElement AccountNumber;

    @FindBy(xpath = "//input[@name='Identification_RegistrationNum']")
    private WebElement RoutingNumber;

    @FindBy(xpath = "//span[text()='Add']")
    private WebElement addAddressButton;

    @FindBy(xpath = "//input[@name='Details_Description']")
    private WebElement banknameInAddress;

    @FindBy(xpath = "//input[@name='LogisticsPostalAddress_CountryRegionId']")
    private WebElement CountryDropDown;

    @FindBy(xpath = "//button[@data-dyn-controlname='Yes']")
    private WebElement YesButton;

    @FindBy(xpath = "//button[@name='OKButton']")
    private WebElement addressOkButton;

    @FindBy(xpath = "//span[text()='Save']")
    private WebElement SaveButton;






    public void checkTheHeaderInEmployeePage(String headerName) {


        timeWaitHelper.explicitlyWaitVisibilityOfWebElement(driver, 20, Employees);
        webElementHelper.clickOnWebElement(Employees);
        timeWaitHelper.explicitlyWaitVisibilityOfWebElement(driver, 20, employeeHeader);
        timeWaitHelper.threadSleep(4000);


        boolean headerExists = false;
        for (WebElement ele : ListOfHeaders) {
            String headersnames = ele.getText();
//            System.out.println(headersnames);

            if (headersnames.equalsIgnoreCase(headerName)) {
                System.out.println("'"+headerName+"' is already added");
                headerExists = true;
                break;
            }
        }

        if (!headerExists) {
            webElementHelper.clickOnWebElement(MoreOption);
            timeWaitHelper.explicitlyWaitVisibilityOfWebElement(driver, 10, InsertColumn);
            webElementHelper.clickOnWebElement(InsertColumn);
            timeWaitHelper.threadSleep(6000);
            timeWaitHelper.explicitlyWaitVisibilityOfWebElement(driver, 10, filterSearchBox);
            timeWaitHelper.threadSleep(3000);
            webElementHelper.sendKeysToWebElement(filterSearchBox, headerName);
            timeWaitHelper.threadSleep(3000);
            mouseAndKeyboardActionsHelper.keyboardEnter(driver);
            timeWaitHelper.threadSleep(4000);
            mouseAndKeyboardActionsHelper.keyboardEnter(driver);
            timeWaitHelper.threadSleep(4000);

            timeWaitHelper.explicitlyWaitVisibilityOfWebElement(driver, 10, CheckBox);
            timeWaitHelper.explicitlyWaitElementToBeClickable(driver, 20, CheckBox);
            timeWaitHelper.threadSleep(2000);
            webElementHelper.clickOnWebElement(CheckBox);


            webElementHelper.clickOnWebElement(UpdateButton);
            System.out.println("'"+headerName+"' added successfully");
            timeWaitHelper.threadSleep(3000);
        }
    }

    public boolean addEmployeeDetails(String headerName, String employeeID, String ExpectedEmployeeName, String bankName, String routingNum, String accountNum) {
        for (WebElement ele : ListOfHeaders) {
            String headersnames = ele.getText();
            if (headersnames.equalsIgnoreCase(headerName)) {
                webElementHelper.clickOnWebElement(ele);
                break;
            }
        }

        timeWaitHelper.explicitlyWaitVisibilityOfWebElement(driver, 20, textBoxInLegacyEmpIdFilter);
        webElementHelper.clickOnWebElement(textBoxInLegacyEmpIdFilter);
        webElementHelper.clearTextInWebElement(textBoxInLegacyEmpIdFilter);
        webElementHelper.sendKeysToWebElement(textBoxInLegacyEmpIdFilter, employeeID);
        System.out.println("Entered Employee ID= " + employeeID);
        webElementHelper.clickOnWebElement(applyButtonInLegacyEmpIdFilter);

        timeWaitHelper.threadSleep(2000);

        // Check if EmployeeName is visible before proceeding
        if (timeWaitHelper.isElementVisible(driver,3,EmployeeName)) {
            String ActualEmployeeName = webElementHelper.getAttribute(EmployeeName, "value");
            System.out.println("Expected EmployeeName=" + ExpectedEmployeeName);
            System.out.println("Actual EmployeeName=" + ActualEmployeeName);

            if (ActualEmployeeName.equalsIgnoreCase(ExpectedEmployeeName)) {
                System.out.println("Employee name is matching");
                webElementHelper.clickOnWebElement(bankAccountsButton);
                timeWaitHelper.threadSleep(2000);
                System.out.println("Navigated to Bank Accounts");

                timeWaitHelper.explicitlyWaitVisibilityOfWebElement(driver, 20, NewButton);
                webElementHelper.clickOnWebElement(NewButton);
                timeWaitHelper.threadSleep(2000);

                timeWaitHelper.explicitlyWaitVisibilityOfWebElement(driver, 20, BankName);
                webElementHelper.clickOnWebElement(AccuntIdentificationNum);
                webElementHelper.clearTextInWebElement(AccuntIdentificationNum);
                webElementHelper.sendKeysToWebElement(AccuntIdentificationNum, "001");
                System.out.println("Entered Account Identification Number= 001");

                webElementHelper.clickOnWebElement(BankName);
                webElementHelper.clearTextInWebElement(BankName);
                webElementHelper.sendKeysToWebElement(BankName, bankName);
                System.out.println("Entered Bank Name= " + bankName);

                webElementHelper.clickOnWebElement(RoutingNumber);
                webElementHelper.clearTextInWebElement(RoutingNumber);
                webElementHelper.sendKeysToWebElement(RoutingNumber, routingNum);
                System.out.println("Entered Routing Number= " + routingNum);

                webElementHelper.clickOnWebElement(AccountNumber);
                webElementHelper.clearTextInWebElement(AccountNumber);
                webElementHelper.sendKeysToWebElement(AccountNumber, accountNum);
                System.out.println("Entered Account Number= " + accountNum);

                webElementHelper.clickOnWebElement(addAddressButton);
                timeWaitHelper.threadSleep(3000);
                timeWaitHelper.explicitlyWaitVisibilityOfWebElement(driver,10,banknameInAddress);
                webElementHelper.clickOnWebElement(banknameInAddress);
                webElementHelper.clearTextInWebElement(banknameInAddress);
                webElementHelper.sendKeysToWebElement(banknameInAddress, bankName);
                System.out.println("Entered Bank Name in address section= " + bankName);
                webElementHelper.clearTextInWebElement(CountryDropDown);
                webElementHelper.sendKeysToWebElement(CountryDropDown, "IND");
                mouseAndKeyboardActionsHelper.keyboardEnter(driver);
                timeWaitHelper.threadSleep(4000);
                webElementHelper.clickOnWebElement(YesButton);
                System.out.println("Clicked on yes button");
                timeWaitHelper.threadSleep(3000);
                webElementHelper.clickOnWebElement(SaveButton);
                System.out.println("Clicked on Save button");
                return true;
            } else {
                return false;
            }
        }
        else {
            return false;
        }
    }


}




