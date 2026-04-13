import java.io.*;

public class java_39497_FileScanner_A07 {
    public static void main(String[] args) {
        // Get the directory path
        File directory = new File("./src/main/resources");

        // Get all the files in the directory
        File[] files = directory.listFiles();

        // Check if files exists
        if(files != null) {
            for (File file : files) {
                // Display the file name
                System.out.println(file.getName());
            }
        } else {
            System.out.println("No files found");
        }
    }
}