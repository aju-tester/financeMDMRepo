package ExcelHelperUtility;

import MiscellaneousUtility.DateAndTimeHelper;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ExcelWriter {

    private Workbook workbook;
    private Sheet sheet;
    private String excelFilePath = "TestExecutionResults/SupplierAccounts/" + DateAndTimeHelper.getCurrentTime("dd-MM-yyyy") + ".xlsx";
    private boolean sheetExists = false;

    public ExcelWriter() {
        // Get today's date in 'yyyy-MM-dd' format to use as the sheet name
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        File file = new File(excelFilePath);

        try {
            // Check if the Excel file exists
            if (file.exists()) {
                // If file exists, load the workbook
                FileInputStream fis = new FileInputStream(file);
                workbook = new XSSFWorkbook(fis);

                // Check if the sheet with today's date exists
                sheet = workbook.getSheet(today.format(formatter));
                if (sheet != null) {
                    sheetExists = true;
                } else {
                    // If the sheet doesn't exist, create a new one
                    sheet = workbook.createSheet(today.format(formatter));
                    createHeader(sheet);
                }
                fis.close();
            } else {
                // If file does not exist, create a new workbook and sheet
                workbook = new XSSFWorkbook();
                sheet = workbook.createSheet(today.format(formatter));
                createHeader(sheet);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to add a new verification code
    public void addVerificationCode(String verificationCode) {
        try {
            // Get the number of physically used rows to determine the next row index
            int nextRowNum = sheet.getPhysicalNumberOfRows();

            // Append new verification code after the last used row
            Row row = sheet.createRow(nextRowNum); // Create row after the last physically used row
            Cell cell = row.createCell(0);
            cell.setCellValue(verificationCode);

            // Write the workbook back to the file
            try (FileOutputStream fos = new FileOutputStream(excelFilePath)) {
                workbook.write(fos);
                System.out.println("Supplier Accounts'" + verificationCode + "' added to the Excel file.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Helper method to create a header row in the sheet
    private void createHeader(Sheet sheet) {
        Row headerRow = sheet.createRow(0);
        Cell headerCell = headerRow.createCell(0);
        headerCell.setCellValue("Supplier Accounts");
    }

    // Method to close the workbook when done
    public void closeWorkbook() {
        try {
            if (workbook != null) {
                workbook.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
