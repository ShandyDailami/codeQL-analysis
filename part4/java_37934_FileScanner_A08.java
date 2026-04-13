import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_37934_FileScanner_A08 {
    private static String targetDirectory;

    // Constructor to initialize the target directory
    public java_37934_FileScanner_A08(String targetDirectory) {
        SecureFileScanner.targetDirectory = targetDirectory;
    }

    // Method to scan a file and its subdirectories
    public void scanDirectory(File directory) {
        File[] files = directory.listFiles();

        // Check if directory or file is null
        if (files == null) {
            return;
        }

        // Iterate over all files and subdirectories
        for (File file : files) {
            if (file.isDirectory()) {
                // If file is a directory, recursively scan it
                scanDirectory(file);
            } else {
                // If file is a regular file, handle it
                handleFile(file);
            }
        }
    }

    // Method to handle a file
    private void handleFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // You can add code here to handle the file line...
                // For example, you can print the line to console
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            // File not found, handle it...
            e.printStackTrace();
        }
    }

    // Main method to start the scanner
    public static void main(String[] args) {
        // Initialize the scanner with a target directory
        SecureFileScanner scanner = new SecureFileScanner("/path/to/directory");

        // Start scanning
        scanner.scanDirectory(new File("/path/to/directory"));
    }
}