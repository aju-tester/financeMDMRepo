package DataProviderUtility;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelDataProvider {

    // Path to your Excel file
    private static final String EXCEL_FILE_PATH = "./src/main/resources/TestData/EmployeeData.xlsx";
    private static final String SHEET_NAME = "Sheet1"; // Specify the sheet name you want to use

    // DataProvider method to read data from Excel
    @DataProvider(name = "userDataProvider")
    public Object[][] userDataProvider() throws IOException {
        return readExcelData(EXCEL_FILE_PATH, SHEET_NAME);
    }

    // Method to read data from Excel using sheet name and dynamic column positions
    public Object[][] readExcelData(String filePath, String sheetName) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet(sheetName); // Get the sheet by name

        if (sheet == null) {
            throw new IllegalArgumentException("Sheet with name " + sheetName + " does not exist.");
        }

        // Find the header row and locate the positions of the required columns
        Row headerRow = sheet.getRow(0);
        Map<String, Integer> columnIndexes = new HashMap<>();
        for (Cell cell : headerRow) {
            String headerValue = cell.getStringCellValue();
            switch (headerValue) {
                case "Workday Employee ID":
                    columnIndexes.put("Workday Employee ID", cell.getColumnIndex());
                    break;
                case "Name":
                    columnIndexes.put("Name", cell.getColumnIndex());
                    break;
                case "Bank Account Number":
                    columnIndexes.put("Bank Account Number", cell.getColumnIndex());
                    break;
                case "Account Holder Name":
                    columnIndexes.put("Account Holder Name", cell.getColumnIndex());
                    break;
                case "Routing Number":
                    columnIndexes.put("Routing Number", cell.getColumnIndex());
                    break;
                case "Pan Number":
                    columnIndexes.put("Pan Number", cell.getColumnIndex());
                    break;
                case "Company ID":
                    columnIndexes.put("Company ID", cell.getColumnIndex());

            }
        }

        // Ensure all columns are present
        if (columnIndexes.size() < 7) {
            throw new IllegalArgumentException("Missing one or more required columns.");
        }

        int rowCount = sheet.getPhysicalNumberOfRows();
        Object[][] data = new Object[rowCount - 1][7]; // Adjust array size for 6 columns

        // Read the data starting from the second row
        for (int i = 1; i < rowCount; i++) {
            Row row = sheet.getRow(i);

            data[i - 1][0] = getCellValue(row.getCell(columnIndexes.get("Workday Employee ID"))); // Workday Employee ID
            data[i - 1][1] = getCellValue(row.getCell(columnIndexes.get("Name"))); // Name
            data[i - 1][2] = getCellValue(row.getCell(columnIndexes.get("Bank Account Number"))); // Bank Account Number
            data[i - 1][3] = getCellValue(row.getCell(columnIndexes.get("Account Holder Name"))); // Account Holder Name
            data[i - 1][4] = getCellValue(row.getCell(columnIndexes.get("Routing Number"))); // Routing Number
            data[i - 1][5] = getCellValue(row.getCell(columnIndexes.get("Pan Number")));
            data[i - 1][6] = getCellValue(row.getCell(columnIndexes.get("Company ID")));

        }

        workbook.close();
        fis.close();

        return data;
    }

    private String getCellValue(Cell cell) {
        if (cell == null) {
            return "";
        }

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                // Check if it's a date value, otherwise treat as a double
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                } else {
                    return String.valueOf((long) cell.getNumericCellValue()); // Convert to long if it's an integer
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            case BLANK:
                return "";
            default:
                return "";
        }
    }

}

