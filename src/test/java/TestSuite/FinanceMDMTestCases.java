package TestSuite;

import DataProviderUtility.ExcelDataProvider;
import ExcelHelperUtility.ExcelWorkbookCreator;
import PageObject.HomePage;
import PageObject.HumanResources;
import PageObject.PurchaseLedger;
import PageObject.loginPage;
import PropertiesFileUtility.PropertyReader;
import SeleniumUtility.TakeScreenshot;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;
import java.io.File;
import java.util.Arrays;



public class FinanceMDMTestCases extends BaseTest {

    loginPage loginPage;
    HomePage homePage;
    HumanResources humanResources;
    PurchaseLedger purchaseLedger;
    ExcelWorkbookCreator excelWorkbookCreator = new ExcelWorkbookCreator();


    @Test(dataProvider = "userDataProvider", dataProviderClass = ExcelDataProvider.class)
    public void newEmployeeData(String workdayEmployeeId, String name, String bankAccountNumber, String accountHolderName, String routingNumber, String panNumber,String companyID) throws InterruptedException {
        loginPage = new loginPage(driver);
        homePage = new HomePage(driver);
        humanResources = new HumanResources(driver);
        purchaseLedger = new PurchaseLedger(driver);


            extentTest.log(Status.INFO,"Started Execution for Employee ID= "+workdayEmployeeId);

            homePage.navigateToHumanResourcesModule(companyID);
            extentTest.log(Status.PASS,"Completed Navigating to HR module");


            humanResources.checkTheHeaderInEmployeePage(PropertyReader.loadProperties().getProperty("TableHeaderName"));
            extentTest.log(Status.PASS,"Checked the header in the 'Employee Page' if not headers are added");

        boolean namesMatched =humanResources.addEmployeeDetails(PropertyReader.loadProperties().getProperty("TableHeaderName"),workdayEmployeeId,accountHolderName,name,routingNumber,bankAccountNumber);
            extentTest.log(Status.PASS,"Entered EmployeeID= "+workdayEmployeeId+" in the Legacy Employee ID");

        if(namesMatched){
            extentTest.log(Status.PASS,"Added all the employee details for the EmployeeID= "+workdayEmployeeId);

            homePage.navigateToPurchaseLedgerModule();
            extentTest.log(Status.PASS,"Completed Navigating to Purchase Ledger module");

            purchaseLedger.checkTheHeaderSuppliersPage(PropertyReader.loadProperties().getProperty("TableHeaderName"),workdayEmployeeId);
            extentTest.log(Status.PASS,"Checked the header in the 'Suppliers Page' if not headers are added");

            String supplierName=purchaseLedger.addingPANandTDS(panNumber);
            extentTest.log(Status.PASS,"PAN number and TDS are added to employee ID= "+workdayEmployeeId);
            extentTest.log(Status.INFO,"Supplier Name= "+supplierName);

            String[] employeeDetails=purchaseLedger.VerifyEmployeeDetailsInPurchaseLedger(bankAccountNumber,workdayEmployeeId,panNumber,routingNumber);
            excelWorkbookCreator.createOrUpdateWorkbook(employeeDetails);

            extentTest.log(Status.INFO,"Employee details are added to the workbook= "+Arrays.toString(employeeDetails));

            homePage.clickOnHomeButton();
            extentTest.log(Status.PASS,"Completed Execution for Employee ID= "+workdayEmployeeId);
            extentTest.log(Status.INFO," Clicked on Home Button");

            System.out.println("252772882");

            }
        else {

            String path=TakeScreenshot.screenShot(driver,workdayEmployeeId);
            File screenshotFile = new File(path);
            if (screenshotFile.exists()) {
                extentTest.fail("Employee name is not matching or Employee is not present for Employee ID= "+workdayEmployeeId, MediaEntityBuilder.createScreenCaptureFromPath(path).build());
            } else {
                System.out.println("Screenshots not found in the path");
            }
            homePage.clickOnHomeButton();
        }


    }


}









