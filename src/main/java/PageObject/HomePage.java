package PageObject;

import SeleniumUtility.MouseAndKeyboardActionsHelper;
import SeleniumUtility.TimeWaitHelper;
import SeleniumUtility.WebElementHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;
    WebElementHelper webElementHelper = new WebElementHelper();
    TimeWaitHelper timeWaitHelper = new TimeWaitHelper();
    MouseAndKeyboardActionsHelper mouseAndKeyboardActionsHelper = new MouseAndKeyboardActionsHelper();

    public HomePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[@data-dyn-title='Modules']")
    private WebElement ModulesButton;

    @FindBy(xpath = "//a[text()='Human resources']")
    private WebElement HumanResources;

    @FindBy(xpath = "//button[@id='CompanyButton_button']")
    private WebElement CompanyButton;

    @FindBy(xpath = "//input[@name='DataArea_id']")
    private WebElement CompanyTextBox;

    @FindBy(xpath = "//input[@aria-label='Company name']")
    private WebElement companyId;

    @FindBy(xpath = "//span[text()='Workspaces']")
    private WebElement WorkSpaceTitle;

    @FindBy(xpath = "//span[@class='workspace-image Home-symbol']")
    private WebElement HomeButton;

//    purchase ledger xpaths

    @FindBy(xpath = "//a[text()='Purchase ledger']")
    private WebElement PurchaseLedger;

    @FindBy(xpath = "//div[@aria-label='All suppliers']")
    private WebElement AllSuppliers;



    public void navigateToHumanResourcesModule(String companyID){

    timeWaitHelper.explicitlyWaitVisibilityOfWebElement(driver,20,CompanyButton);
    webElementHelper.clickOnWebElement(CompanyButton);
    timeWaitHelper.threadSleep(2000);
    timeWaitHelper.explicitlyWaitVisibilityOfWebElement(driver,20,CompanyTextBox);
    webElementHelper.clearTextInWebElement(CompanyTextBox);
    webElementHelper.sendKeysToWebElement(CompanyTextBox,companyID);
        timeWaitHelper.threadSleep(4000);
    webElementHelper.clickOnWebElement(companyId);
        timeWaitHelper.threadSleep(2000);
        System.out.println("Clicked on Company Button and entered CompanyID "+companyID);
    timeWaitHelper.threadSleep(7000);
    timeWaitHelper.explicitlyWaitVisibilityOfWebElement(driver,20,ModulesButton);
    webElementHelper.clickOnWebElement(ModulesButton);
    timeWaitHelper.explicitlyWaitVisibilityOfWebElement(driver,20,HumanResources);
    webElementHelper.clickOnWebElement(HumanResources);
        System.out.println("Navigated to Human Resources Module");

    }

    public void navigateToPurchaseLedgerModule()
    {
        timeWaitHelper.explicitlyWaitVisibilityOfWebElement(driver,20,ModulesButton);
        webElementHelper.clickOnWebElement(ModulesButton);
        timeWaitHelper.explicitlyWaitVisibilityOfWebElement(driver,20,PurchaseLedger);
        webElementHelper.clickOnWebElement(PurchaseLedger);
            System.out.println("Navigated to Purchase Ledger Module");
        timeWaitHelper.explicitlyWaitVisibilityOfWebElement(driver,20,AllSuppliers);
        webElementHelper.clickOnWebElement(AllSuppliers);
            System.out.println("Clicked on All Suppliers");
        timeWaitHelper.threadSleep(6000);

    }
    public void clickOnHomeButton(){
        timeWaitHelper.explicitlyWaitVisibilityOfWebElement(driver,20,HomeButton);
        webElementHelper.clickOnWebElement(HomeButton);
        System.out.println("Clicked on Home Button");
        timeWaitHelper.threadSleep(6000);
    }
}
