import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_30671_FileScanner_A07 {
    public static void main(String[] args) {
        // Create a File object for the current directory
        File directory = new File(".");

        try {
            // Create a Scanner object for reading files
            Scanner scanner = new Scanner(directory);

            // Scan all files in the directory
            while (scanner.hasNext()) {
                String fileName = scanner.next();
                File file = new File(fileName);

                // Check if the file exists
                if (file.exists()) {
                    // Check if the file is a directory
                    if (file.isDirectory()) {
                        System.out.println("Directory: " + fileName);
                    } else {
                        System.out.println("File: " + fileName);
                    }
                }
            }

            // Close the scanner
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}