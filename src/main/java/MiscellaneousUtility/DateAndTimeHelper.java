package MiscellaneousUtility;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;




public class DateAndTimeHelper{

    public LocalDate localDate;
    public static LocalDateTime localDateTime;
    public static DateTimeFormatter dateTimeFormatter;

    /**
     * This function is used to return the current date
     *
     * @return
     */
    public LocalDate getCurrentdDate() {

        localDate = java.time.LocalDate.now();
        return localDate;
    }

    /**
     * This function is used to return the current date and time in given date
     * pattern
     *
     * @param datePattern - date pattern
     * @return - current date and time
     */
    public  static String getCurrentTime(String datePattern) {
        localDateTime = java.time.LocalDateTime.now();
        dateTimeFormatter = java.time.format.DateTimeFormatter.ofPattern(datePattern);
        return localDateTime.format(dateTimeFormatter);
    }



    /**
     * This function is used to minus given no. of days from the current datetime
     * and return the date & time with given date time pattern
     *
     * @param days        - no. of days
     * @param datePattern - date pattern
     * @return - date & time
     */
    public String minusDaysFromDateTime(int days, String datePattern) {
        localDateTime = java.time.LocalDateTime.now();
        dateTimeFormatter = java.time.format.DateTimeFormatter.ofPattern(datePattern);
        return localDateTime.minusDays(days).format(dateTimeFormatter);
    }

    /**
     * This function is used to add given no. of days to the current datetime and
     * return the date & time with given date time pattern
     *
     * @param days        - no. of days
     * @param datePattern - date pattern
     * @return - date & time
     */
    public String plusDaysToDateTime(int days, String datePattern) {

        localDateTime = java.time.LocalDateTime.now();
        dateTimeFormatter = java.time.format.DateTimeFormatter.ofPattern(datePattern);
        return localDateTime.plusDays(days).format(dateTimeFormatter);
    }

    /**
     * This function is used to minus given no. of days from the current datetime
     * and return the date & time with given date time pattern
     *
     * @param datePattern - date pattern
     * @return - date & time
     */
    public String minusMonthsFromDateTime(int months, String datePattern) {
        localDateTime = java.time.LocalDateTime.now();
        dateTimeFormatter = java.time.format.DateTimeFormatter.ofPattern(datePattern);
        return localDateTime.minusMonths(months).format(dateTimeFormatter);
    }

    /**
     * This function is used to add given no. of months to the current datetime and
     * return the date & time with given date time pattern
     *
     * @param datePattern - date pattern
     * @return - date & time
     */
    public String plusMonthsToDateTime(int months, String datePattern) {

        localDateTime = java.time.LocalDateTime.now();
        dateTimeFormatter = java.time.format.DateTimeFormatter.ofPattern(datePattern);
        return localDateTime.plusMonths(months).format(dateTimeFormatter);
    }

    /**
     * This function is used to minus the given no. of years from the current
     * datetime and return the date & time with given date time pattern
     *
     * @param years       - no.of years
     * @param datePattern - date pattern
     * @return - date & time
     */
    public String minusYearsFromDateTime(int years, String datePattern) {

        localDateTime = java.time.LocalDateTime.now();
        dateTimeFormatter = java.time.format.DateTimeFormatter.ofPattern(datePattern);
        return localDateTime.minusMonths(years).format(dateTimeFormatter);
    }

    /**
     * This function is used to add the no. of years to the current datetime and
     * return the date & time with given date time pattern
     *
     * @param years       - no.of years
     * @param datePattern - date pattern
     * @return - date & time
     */
    public String plusYearsToTheDateTime(int years, String datePattern) {
        localDateTime = java.time.LocalDateTime.now();
        dateTimeFormatter = java.time.format.DateTimeFormatter.ofPattern(datePattern);
        return localDateTime.plusYears(years).format(dateTimeFormatter);
    }

    /**
     * This function is used to format the given date time into expected format
     *
     * @param date         - give
     * @param inputFormat
     * @param outputFormat
     * @return
     */
    public String getFormattedDateTime(String date, String inputFormat, String outputFormat) {
        dateTimeFormatter = java.time.format.DateTimeFormatter.ofPattern(inputFormat);
        java.time.LocalDate parsedDate = java.time.LocalDate.parse(date, dateTimeFormatter);
        java.time.format.DateTimeFormatter outputFormatter = java.time.format.DateTimeFormatter.ofPattern(outputFormat);
        String outputFormattedDate = parsedDate.format(outputFormatter);
        return outputFormattedDate;

    }

    public String getCurrentDateTimeWithExpectedZoneAndFormat(String expectedZoneId, String dateFormatPattern) {
        System.out.println("This function is used to get the current date in expected Zone '" + expectedZoneId
                + "' & date format pattern '" + dateFormatPattern + "'");

        String currentDate = "";

        try {
            java.time.ZonedDateTime zonedDateTime = java.time.ZonedDateTime.now(java.time.ZoneId.of(expectedZoneId));
            java.time.format.DateTimeFormatter dateTimeFormatter = java.time.format.DateTimeFormatter.ofPattern(dateFormatPattern);
            currentDate = zonedDateTime.format(dateTimeFormatter);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return currentDate;
    }

    /**
     * This function is used to convert the given date into expected date format and
     * return the same
     *
     * @param date              - date
     * @param inputDatePattern  - input date pattern
     * @param outputDatePattern - output date pattern
     * @return - date in expected format
     */
    public static String convertDateFormat(String date, String inputDatePattern, String outputDatePattern) {

        String requiredDate = "";
        try {

            java.time.LocalDate localDate = java.time.LocalDate.now();
            java.time.format.DateTimeFormatter inputFormatter = java.time.format.DateTimeFormatter.ofPattern(inputDatePattern);
            java.time.format.DateTimeFormatter outputFormatter = java.time.format.DateTimeFormatter.ofPattern(outputDatePattern);

            requiredDate = localDate.parse(date, inputFormatter).format(outputFormatter);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return requiredDate;
    }

    /**
     * This function is used to parse the given date
     *
     * @param date        - date
     * @param inputFormat - input format
     * @return - parsed date
     */
    public java.time.LocalDate getParsedDate(String date, String inputFormat) {
        dateTimeFormatter = java.time.format.DateTimeFormatter.ofPattern(inputFormat);
        java.time.LocalDate parsedDate = java.time.LocalDate.parse(date, dateTimeFormatter);
        return parsedDate;
    }

    public static void getCustomDateFormatFromFile(String expectedData, String filePath) {

        Boolean found;

        try {
            Thread.sleep(300);
            String Text = TextFileHelper.readFile(filePath);// file reading
            // String DateFormat1=getCurrentTime(expectedData);
            String DateFormat1 = expectedData;
            if (found = Text.contains(DateFormat1))// date

            {

                System.out.println("Text found = " + found);
                System.out.println((new MiscellaneousUtility.DateAndTimeHelper()).getCurrentTime(DateFormat1) + " Present in " + Text);

            } else {
                System.out.println(" Text Not Found");

                org.testng.Assert.fail("Actual Text file data is " + Text + "Expected DateFormat is " + DateFormat1);

            }
        } catch (Exception e) {
            System.out.println("getCustomDateFormatFromFile is having error");
            System.out.println(e.getMessage());
            org.testng.Assert.fail(e.getMessage());
        }
    }

//    public static void getCustomDateFormatFromFile(AssertionUtility.SoftAssertionHelper softAssertionHelper, String expectedData, String filePath) {
//
//        Boolean found;
//
//        try {
//            Thread.sleep(300);
//            String Text = TextFileHelper.readFile(filePath);// file reading
//            // String DateFormat1=getCurrentTime(expectedData);
//            String DateFormat1 = expectedData;
//            if (found = Text.contains(DateFormat1))// date
//
//            {
//                System.out.println("Text found = " + found);
//                softAssertionHelper.assertTrue(found.equals(true), "Data Found In File ");
//
//
//                System.out.println((new MiscellaneousUtility.DateAndTimeHelper()).getCurrentTime(DateFormat1) + " Present in " + Text);
//
//            } else {
//                System.out.println(" Text Not Found");
//
//                org.testng.Assert.fail("Actual Text file data is " + Text + "Expected DateFormat is " + DateFormat1);
//
//            }
//        } catch (Exception e) {
//            System.out.println("getCustomDateFormatFromFile is having error");
//            System.out.println(e.getMessage());
//            org.testng.Assert.fail(e.getMessage());
//        }
//    }



    public String convertDateFormatWithZoneId(String date, String zoneId, String outputDatePattern) {
        String requiredDate = "";

        try {

            // ZonedDateTime ss = ZonedDateTime.parse(date,
            // DateTimeFormatter.ISO_ZONED_DATE_TIME.withZone(ZoneId.of(zoneId)));
            java.time.ZonedDateTime ss1 = java.time.ZonedDateTime.parse(date);
            requiredDate = ss1.format(java.time.format.DateTimeFormatter.ofPattern(outputDatePattern));
            // requiredDate = ss.format(DateTimeFormatter.ofPattern(outputDatePattern));
            /*
             * ZonedDateTime zdt = ZonedDateTime.now(); String formattedZdt =
             * zdt.format(DateTimeFormatter.ISO_ZONED_DATE_TIME.withZone(ZoneId.of(zoneId)))
             * ; System.out.println(formattedZdt); ZonedDateTime ss =
             * ZonedDateTime.parse(formattedZdt); requiredDate =
             * ss.format(DateTimeFormatter.ofPattern(outputDatePattern));
             */ System.out.println("requiredDate:"+requiredDate);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return requiredDate;
    }

    /**
     * This function is used to return the date of given Day of the Week
     * @param dayOfTheWeek - day of the week
     * @return - date of the given week
     */
    public static java.time.LocalDate getDateOfCurrentWeek(Enum dayOfTheWeek) {

        java.time.LocalDate today = java.time.LocalDate.now();
        // Go backward to get Monday
        java.time.LocalDate monday = today;
        while (monday.getDayOfWeek() != dayOfTheWeek) {
            monday = monday.minusDays(1);
        }
        System.out.println("date of the Week: " + monday);
        return monday;
    }


    public String minusMonthsFromZonedDateTime(int noOfMonths, String dateFormatPattern, String zoneId) {

        String requiredDate = "";
        try {
            java.time.ZonedDateTime zonedDateTime = java.time.ZonedDateTime.now(java.time.ZoneId.of(zoneId));
            zonedDateTime = zonedDateTime.minusMonths(noOfMonths);
            requiredDate = zonedDateTime.format(java.time.format.DateTimeFormatter.ofPattern(dateFormatPattern));
            System.out.println("requiredDate:"+requiredDate);
        }catch (java.time.format.DateTimeParseException e) {
            e.getMessage();
        }
        return requiredDate;

    }


    public String getFormattedDate(String date, String inputFormat, String outputFormat) {
        String outputFormattedDate = "";
        try {

            dateTimeFormatter = java.time.format.DateTimeFormatter.ofPattern(inputFormat);
            java.time.LocalDate parsedDateTime = java.time.LocalDate.parse(date, dateTimeFormatter);
            java.time.format.DateTimeFormatter outputFormatter = java.time.format.DateTimeFormatter.ofPattern(outputFormat);
            outputFormattedDate = parsedDateTime.format(outputFormatter);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return outputFormattedDate;

    }

    /**
     * this function is used to print current week sunday
     * @param pattern
     * @return
     */
    public static String getThisWeekSundayDate(String pattern) {

        java.time.format.DateTimeFormatter dformat= java.time.format.DateTimeFormatter.ofPattern(pattern);
        java.time.LocalDate inputDate = java.time.LocalDate.now();
        java.time.LocalDate prevSat = inputDate.with(java.time.temporal.TemporalAdjusters.next(java.time.DayOfWeek.SUNDAY));
        String inputPattern=prevSat.format(dformat);
        System.out.println("date pattern for current sunday " + inputPattern);
        return inputPattern;
    }

    /**
     * this function is used to print current week sunday
     * @param pattern
     * @return
     */
    public static String getThisWeekMondayDate(String pattern) {

        java.time.format.DateTimeFormatter dformat= java.time.format.DateTimeFormatter.ofPattern(pattern);
        java.time.LocalDate inputDate = java.time.LocalDate.now();
        java.time.LocalDate prevSat = inputDate.with(java.time.temporal.TemporalAdjusters.previous(java.time.DayOfWeek.MONDAY));
        String inputPattern=prevSat.format(dformat);
        System.out.println("date pattern for current sunday " + inputPattern);
        return inputPattern;
    }




    public static void main1(String[] args) {
        MiscellaneousUtility.DateAndTimeHelper DateAndTimeHelper=new MiscellaneousUtility.DateAndTimeHelper();
        System.out.println(DateAndTimeHelper.minusDaysFromDateTime(16,"dd/MM/yyyy"));
    }

    public String generalPlusDate(int days, String datePattern) {

        localDateTime = java.time.LocalDateTime.now();
        dateTimeFormatter = java.time.format.DateTimeFormatter.ofPattern(datePattern);
        return localDateTime.plusDays(days).format(dateTimeFormatter);
    }

    public static void main(String[] args) {
        DateAndTimeHelper d=new DateAndTimeHelper();
        System.out.println(d.getCurrentTime("ddMMyyyy_hhmm"));

    }

}
