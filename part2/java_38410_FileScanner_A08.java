import java.io.File;
import java.util.Scanner;

public class java_38410_FileScanner_A08 {

    public static void main(String[] args) {
        // Create a new file scanner to scan files in the current directory
        FileScanner fileScanner = new FileScanner();

        // Get the current directory
        File currentDir = new File(".");

        // Scan all files in the current directory
        fileScanner.scanDirectory(currentDir);
    }
}

class FileScanner {

    // Method to scan a directory
    void scanDirectory(File directory) {
        // Get all files in the directory
        File[] files = directory.listFiles();

        // Check if there are no files in the directory
        if (files == null) {
            return;
        }

        // Scan all files
        for (File file : files) {
            // Print the file name
            System.out.println(file.getName());
        }
    }
}