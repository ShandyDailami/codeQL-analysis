import java.io.*;
import java.util.*;

public class java_27851_FileScanner_A01 {
    private static final String DIRECTORY = "C:\\Users\\YourUsername\\Documents";

    public static void main(String[] args) {
        try {
            File file = new File(DIRECTORY);

            File[] listOfFiles = file.listFiles();

            for (File fileEntry : listOfFiles) {
                if (fileEntry.isFile() && fileEntry.canRead()) {
                    FileReader reader = new FileReader(fileEntry);
                    BufferedReader bufferedReader = new BufferedReader(reader);

                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        System.out.println(line);
                    }

                    bufferedReader.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}