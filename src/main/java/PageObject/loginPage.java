package PageObject;

import SeleniumUtility.TimeWaitHelper;
import SeleniumUtility.WebElementHelper;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {

    WebDriver driver;
    WebElementHelper webElementHelper = new WebElementHelper();
    TimeWaitHelper timeWaitHelper = new TimeWaitHelper();


    public loginPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@type='email']")
    private WebElement EmailTextBox_Dentsu;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement DentsuNextButtom;

    @FindBy(xpath = "//input[@type='text']")
    private WebElement enterUserName;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement enterPassword;

    @FindBy(xpath = "//input[@value='Sign in']")
    private WebElement SignInButton;

    public void login(String username, String password)
    {
     timeWaitHelper.explicitlyWaitVisibilityOfWebElement(driver,10,EmailTextBox_Dentsu);
     webElementHelper.clickOnWebElement(EmailTextBox_Dentsu);
     webElementHelper.sendKeysToWebElement(EmailTextBox_Dentsu,username);
     webElementHelper.clickOnWebElement(DentsuNextButtom);
     timeWaitHelper.explicitlyWaitVisibilityOfWebElement(driver,10,enterUserName);
     webElementHelper.clearTextInWebElement(enterUserName);
     timeWaitHelper.threadSleep(1000);
     webElementHelper.sendKeysToWebElement(enterUserName,username);
        System.out.println("Entered Username");
     webElementHelper.sendKeysToWebElement(enterPassword,password);
        System.out.println("Entered Password");
     webElementHelper.clickOnWebElement(SignInButton);


    }
}
