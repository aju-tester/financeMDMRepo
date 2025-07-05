package PageObject;


import ExcelHelperUtility.ExcelWriter;
import SeleniumUtility.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PurchaseLedger {
    WebDriver driver;
    WebElementHelper webElementHelper = new WebElementHelper();
    TimeWaitHelper timeWaitHelper = new TimeWaitHelper();
    MouseAndKeyboardActionsHelper mouseAndKeyboardActionsHelper = new MouseAndKeyboardActionsHelper();
    ExcelWriter writer = new ExcelWriter();


    public PurchaseLedger(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[contains(@class,'fixedDataTableCellLayout_main public_fixedDataTableCell_main ')]")
    private List<WebElement> listOfHeaders;

    @FindBy(xpath = "//button[@aria-label='Grid options']")
    private WebElement MoreOption;

    @FindBy(xpath = "//span[text()='Insert columns...']")
    private WebElement InsertColumn;

    @FindBy(xpath = "//input[@name='QuickFilterControl_Input']")
    private WebElement FilterSearchBox;

    @FindBy(xpath = "//div[contains(@id,\"FormControlFieldSelector_Grid_Selected\")]//div//div//div//span")
    private WebElement CheckBox;

    @FindBy(xpath = "//span[text()='Update']")
    private WebElement UpdateButton;

    @FindBy(xpath = "//input[contains(@name,'AEGLegacyEmployeeId_Input_')]")
    private WebElement textBoxInLegacyEmpIdFilter;

    @FindBy(xpath = "//button[contains(@name,'_ApplyFilters')]")
    private WebElement applyButtonInLegacyEmpIdFilter;

    @FindBy(xpath = "//input[@aria-label='Supplier account']")
    private WebElement SupplierAccount;

    @FindBy(xpath = "//span[contains(@id,'_SystemDefinedViewEditButton_label')]")
    private WebElement SupplierEditButton;

    @FindBy(xpath = "(//span[contains(@aria-labelledby,'_WithholdingTaxSYS_TaxWithholdCalculate_label')])[2]")
    private WebElement withHoldingTaxToggleBox;

    @FindBy(xpath = "//input[@name='TaxInformationVendTable_IN_TDSGroup']")
    private WebElement TDSgroup;

    @FindBy(xpath = "//input[@name='PAN_IN_PANStatus']")
    private WebElement PANstatus;

    @FindBy(xpath = "//input[@name='PAN_IN_PANNumber']")
    private WebElement InputPANnumber;

    @FindBy(xpath = "//span[text()='Save']")
    private WebElement SaveButton;

    @FindBy(xpath = "//span[@class='button-commandRing Back-symbol']")
    private WebElement BackButton;

    @FindBy(xpath = "//span[contains(@id,'_HeaderTitle')]")
    private WebElement HeaderTitle;


//    Bank Accounts Xpaths

    @FindBy(xpath = "//span[text()='Bank accounts']")
    private WebElement bankAccountsButton;

    @FindBy(xpath = "(//input[contains(@id,'_Identification_AccountNum_input')])[2]")
    private WebElement AccountNumber;

    @FindBy(xpath = "//input[@name='Identification_RegistrationNum']")
    private WebElement RoutingNumber;

    @FindBy(xpath = "(//span[@class='button-commandRing Back-symbol'])[2]")
    private WebElement backButton;


    public void checkTheHeaderSuppliersPage(String headerName, String employeeID) {
        boolean headerExists = false;
        for (WebElement ele : listOfHeaders) {
            String headersnames = ele.getText();
//            System.out.println(headersnames);

            if (headersnames.equalsIgnoreCase(headerName)) {
                System.out.println("'" + headerName + "' is already added");
                headerExists = true;
                break;
            }
        }
        if (!headerExists) {
            webElementHelper.clickOnWebElement(MoreOption);
            timeWaitHelper.explicitlyWaitVisibilityOfWebElement(driver, 10, InsertColumn);
            webElementHelper.clickOnWebElement(InsertColumn);
            timeWaitHelper.threadSleep(6000);
            timeWaitHelper.explicitlyWaitVisibilityOfWebElement(driver, 10, FilterSearchBox);
            timeWaitHelper.threadSleep(2000);
            webElementHelper.sendKeysToWebElement(FilterSearchBox, headerName);
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
            System.out.println("'" + headerName + "' added successfully");
            timeWaitHelper.threadSleep(4000);
        }
        for (WebElement ele : listOfHeaders) {
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
    }


    public String addingPANandTDS(String PANnum) {

        timeWaitHelper.explicitlyWaitVisibilityOfWebElement(driver, 20, SupplierAccount);
        webElementHelper.clickOnWebElement(SupplierAccount);
        timeWaitHelper.threadSleep(4000);
        timeWaitHelper.explicitlyWaitVisibilityOfWebElement(driver, 20, SupplierEditButton);
        webElementHelper.clickOnWebElement(SupplierEditButton);
        timeWaitHelper.threadSleep(2000);
        String SupplierNAme = webElementHelper.getTextOfWebElement(HeaderTitle);
        System.out.println("Supplier name= " + webElementHelper.getTextOfWebElement(HeaderTitle));

//        writer.addVerificationCode(SupplierNAme);
//        writer.closeWorkbook();


        JSExecutorHelper.scrollByVisibleWebElement(driver, withHoldingTaxToggleBox);
        timeWaitHelper.threadSleep(2000);
        webElementHelper.clickOnWebElement(withHoldingTaxToggleBox);
        webElementHelper.clearTextInWebElement(TDSgroup);
        webElementHelper.sendKeysToWebElement(TDSgroup, "194J");
        System.out.println("Entered TDS group=194J");
        mouseAndKeyboardActionsHelper.keyboardEnter(driver);
        timeWaitHelper.threadSleep(2000);

        JSExecutorHelper.scrollByVisibleWebElement(driver, PANstatus);
        timeWaitHelper.threadSleep(2000);
        webElementHelper.clickOnWebElement(PANstatus);
        webElementHelper.clearTextInWebElement(PANstatus);
        webElementHelper.sendKeysToWebElement(PANstatus, "Received");
        System.out.println("PAN status is changed to 'Received'");
        mouseAndKeyboardActionsHelper.keyboardEnter(driver);
        timeWaitHelper.threadSleep(2000);
//        webElementHelper.clearTextInWebElement(InputPANnumber);
//        timeWaitHelper.threadSleep(1000);
        webElementHelper.sendKeysToWebElement(InputPANnumber, PANnum);
        System.out.println("Entered PAN number= " + PANnum);
        webElementHelper.clickOnWebElement(SaveButton);
        System.out.println("Clicked on save button");
        timeWaitHelper.threadSleep(5000);
        return SupplierNAme;

    }

    public String[] VerifyEmployeeDetailsInPurchaseLedger(String ExpectedAccNum, String empId, String ExpectedPanNumber, String ExpectedroutingNumber) {

        webElementHelper.clickOnWebElement(bankAccountsButton);
        System.out.println("Clicked on Bank accounts in Purchase Ledger Module");
        timeWaitHelper.threadSleep(5000);
        String ActualBankNum = webElementHelper.getAttribute(AccountNumber, "data-dyn-qtip-title");

        if (ActualBankNum == null || ActualBankNum.isEmpty()) {
            ActualBankNum = webElementHelper.getAttribute(AccountNumber, "title");
            System.out.println("Actual Account Number= " + ActualBankNum);
            System.out.println("Expected Account Number= " + ExpectedAccNum);
        }
        String ActualRoutingNumber = webElementHelper.getAttribute(RoutingNumber, "title");

        if (ActualRoutingNumber == null || ActualRoutingNumber.isEmpty()) {
            ActualRoutingNumber = webElementHelper.getAttribute(RoutingNumber, "data-dyn-qtip-title");
            System.out.println("Actual Routing Number = " + ActualRoutingNumber);
            System.out.println("Expected Routing Number= " + ExpectedroutingNumber);
        }

        if (ActualBankNum != null && ActualBankNum.equalsIgnoreCase(ExpectedAccNum) && ActualRoutingNumber != null && ActualRoutingNumber.equalsIgnoreCase(ExpectedroutingNumber)) {
            System.out.println("Account numbers and Routing numbers are matching are matching");
        } else {
            System.out.println("Account numbers and Routing numbers are not matching for the EmployeeID=" + empId);
        }


        webElementHelper.clickOnWebElement(backButton);
        System.out.println("Clicked on back button");
        timeWaitHelper.threadSleep(3000);

        timeWaitHelper.explicitlyWaitVisibilityOfWebElement(driver, 10, HeaderTitle);
        String SupplierNAme = webElementHelper.getTextOfWebElement(HeaderTitle);

        JSExecutorHelper.scrollByVisibleWebElement(driver, PANstatus);
        timeWaitHelper.threadSleep(2000);

        String ActualPanNum = webElementHelper.getAttribute(InputPANnumber, "data-dyn-qtip-title");
        if (ActualPanNum == null || ActualPanNum.isEmpty()) {
            ActualPanNum = webElementHelper.getAttribute(InputPANnumber, "title");
            System.out.println("Actual PAN number=" + ActualPanNum);
            System.out.println("Expected PAN number=" + ExpectedPanNumber);
        }
        if (ActualPanNum != null && ActualPanNum.equalsIgnoreCase(ExpectedPanNumber)) {
            System.out.println("PAN numbers are matching");
        } else {
            System.out.println("PAN numbers are not matching");
        }

        return new String[]{empId,SupplierNAme,ActualPanNum, ActualRoutingNumber, ActualBankNum};

    }

}
