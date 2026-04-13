import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_39275_FileScanner_A08 {
    public static void main(String[] args) {
        // Specify the directory
        String directoryPath = "/path/to/your/directory";

        File directory = new File(directoryPath);

        // Ensure the directory exists and is accessible
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("The provided path is not a valid directory.");
            return;
        }

        try {
            // Use File's listFiles method to get an array of File objects
            File[] files = directory.listFiles();

            // Verify if files array is not null
            if (files != null) {
                // Iterate through each file
                for (File file : files) {
                    // Print the file name
                    System.out.println(file.getName());
                }
            } else {
                System.out.println("No files in the directory.");
            }

        } catch (Exception e) {
            System.out.println("An error occurred while trying to list files in the directory.");
        }
    }
}