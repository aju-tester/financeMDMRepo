package ExcelHelperUtility;

import MiscellaneousUtility.DateAndTimeHelper;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class ExcelWorkbookCreator {
    private static final String[] HEADERS = {"EmployeeID", "Supplier Name", "PAN Number", "Routing Number","Account Number"};
//    public static void main(String[] args) {
//        // Call the method to create or modify the workbook and sheet
//        ExcelWorkbookCreator creator = new ExcelWorkbookCreator();
//        // Example employee data to be passed as String arrays
//        String[] employee1 = {"101", "ABC Supplies", "ABCDE1234F", "123456","0173728817"};
//        String[] employee2 = {"102", "XYZ Supplies", "XYZEE5678G", "654321","0177388289"};
//        // Calling the method with each employee's data
//        creator.createOrUpdateWorkbook(employee1);
//        creator.createOrUpdateWorkbook(employee2);
//    }
    public void createOrUpdateWorkbook(String[] employeeData) {
        try {
            // Get current date for file name and sheet name
//
            String sheetName =  DateAndTimeHelper.getCurrentTime("dd-MM-yyyy"); // Day name (e.g., Monday)
            // File path for the workbook
            String filePath = "TestExecutionResults/SupplierAccounts/" + DateAndTimeHelper.getCurrentTime("dd-MM-yyyy") + ".xlsx";
            File file = new File(filePath);
            XSSFWorkbook workbook;
            // Check if the workbook exists
            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                workbook = new XSSFWorkbook(fis);
            } else {
                workbook = new XSSFWorkbook();
            }
            // Check if sheet exists, if not create it
            XSSFSheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                sheet = workbook.createSheet(sheetName);
                // Create header row if the sheet is new
                Row headerRow = sheet.createRow(0);
                for (int i = 0; i < HEADERS.length; i++) {
                    Cell cell = headerRow.createCell(i);
                    cell.setCellValue(HEADERS[i]);
                }
            }
            // Find the last row in the sheet
            int lastRowNum = sheet.getLastRowNum();
            if (lastRowNum == 0 && sheet.getRow(0) == null) {
                lastRowNum = -1;  // No rows exist in the sheet yet
            }
            // Now, write new data in the last row
            Row row = sheet.createRow(++lastRowNum);
            for (int i = 0; i < employeeData.length; i++) {
                Cell cell = row.createCell(i);
                cell.setCellValue(employeeData[i]);
            }
            // Write changes back to the file
            try (FileOutputStream fos = new FileOutputStream(filePath)) {
                workbook.write(fos);
            }
            workbook.close();
            System.out.println("Excel file updated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}