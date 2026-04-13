import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_04310_FileScanner_A07 {

    public static void main(String[] args) {
        // Define the directory path
        String dirPath = "/path/to/directory";

        // Get the directory
        File dir = new File(dirPath);

        // Check if directory exists
        if (!dir.exists()) {
            System.out.println("Directory not found!");
            return;
        }

        // Create a FileScanner
        File[] files = dir.listFiles();

        // Check if there are any files in the directory
        if (files == null) {
            System.out.println("No files found in the directory!");
            return;
        }

        // Print out the names and sizes of each file
        for (File file : files) {
            if (file.isFile()) {
                System.out.println("File name: " + file.getName());
                System.out.println("File size: " + file.length() + " bytes");
            }
        }
    }
}