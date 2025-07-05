package MiscellaneousUtility;


public class TextFileHelper {

    /**
     * This function is used to read the file using given filepath and returns the
     * data as string
     * @param filePath - filepath
     * @return - String
     */
    public static String readFileAsStringWithUTF16(String filePath)
    {
        java.io.InputStreamReader inputStreamReader = null;
        String data = "";

        try {
            inputStreamReader = new java.io.InputStreamReader(new java.io.FileInputStream(filePath),
                    java.nio.charset.StandardCharsets.UTF_16);
            data = org.apache.commons.io.IOUtils.toString(inputStreamReader);
            System.out.println(data);
        }catch (java.io.IOException iex) {
            iex.printStackTrace();
        }finally {
            try {
                inputStreamReader.close();
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    public static String readFileAsStringWithUTF8(String filePath)
    {
        java.io.InputStreamReader inputStreamReader = null;
        String data = "";

        try {
            inputStreamReader = new java.io.InputStreamReader(new java.io.FileInputStream(filePath),
                    java.nio.charset.StandardCharsets.UTF_8);
            data = org.apache.commons.io.IOUtils.toString(inputStreamReader);
            System.out.println(data);
        }catch (java.io.IOException iex) {
            iex.printStackTrace();
        }finally {
            try {
                inputStreamReader.close();
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }
        return data;
    }
    /**
     * This function is used to read the file using given filepath and returns the
     * data as string
     * @param filePath - filepath
     * @return
     */
    public static String readFileAsString(String filePath)
    {
        java.io.InputStreamReader inputStreamReader = null;
        String data = "";

        try {
            inputStreamReader = new java.io.InputStreamReader(new java.io.FileInputStream(filePath),
                    java.nio.charset.StandardCharsets.UTF_16);
            data = org.apache.commons.io.IOUtils.toString(inputStreamReader);
            System.out.println(data);
        }catch (java.io.IOException iex) {
            iex.printStackTrace();
        }finally {
            try {
                inputStreamReader.close();
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    /**
     * This method is used to read entire file
     * @author Shashirekha S
     * @param filepath
     * @return
     */
    public static String readFile(String filepath)
    { String data ="";
        try {
            java.io.File myObj = new java.io.File(filepath);
            java.util.Scanner myReader = new java.util.Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
                System.out.println(data);

            }
            myReader.close();
        } catch (java.io.FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        // System.out.println("data is "+ data);
        return data;
    }

}
