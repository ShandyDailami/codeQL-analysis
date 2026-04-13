import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_32240_FileScanner_A03 {
    public static void main(String[] args) {
        // Create a FileScanner instance to scan the current directory
        FileScanner fileScanner = new FileScanner();

        // Get the current directory path
        String dirPath = System.getProperty("user.dir");

        // Use the scanner to scan the directory
        fileScanner.scanDirectory(dirPath);
    }

    // Define the FileScanner class
    public static class FileScanner {
        // Method to scan a directory
        public void scanDirectory(String dirPath) {
            // Get the directory
            File dir = new File(dirPath);

            // Get all files in the directory
            File[] files = dir.listFiles();

            // Check if the directory exists and is valid
            if (files != null) {
                // Iterate over each file
                for (File file : files) {
                    // Check if the file is a directory
                    if (file.isDirectory()) {
                        // Recursively scan the directory
                        scanDirectory(file.getAbsolutePath());
                    } else {
                        // Scan the file for security-sensitive operations
                        scanFile(file);
                    }
                }
            }
        }

        // Method to scan a file
        public void scanFile(File file) {
            // Get the file name
            String fileName = file.getName();

            // Check if the file name ends with a危险的扩展名
            if (Arrays.asList(new String[]{".exe", ".dll", ".jar", ".msi"}).contains(fileName.substring(fileName.lastIndexOf(".")))) {
                // Print a warning message
                System.out.println("Warning: File " + fileName + " has a risky extension. Proceed with caution.");
            }
        }
    }
}