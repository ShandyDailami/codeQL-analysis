import java.io.File;
import java.util.Scanner;

public class java_04591_FileScanner_A01 {
    public static void main(String[] args) {
        // Create a FileScanner to scan the directory.
        FileScanner scanner = new FileScanner();

        // Define the directory to scan.
        File directory = new File(".");

        // Use the scanner to list all the files in the directory.
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    // Print the name and size of each file.
                    System.out.printf("File: %s%nSize: %d bytes%n", file.getName(), file.length());
                }
            }
        }

        // Close the scanner.
        scanner.close();
    }
}