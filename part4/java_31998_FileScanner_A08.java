import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class java_31998_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        // Path to the directory
        String directoryPath = "/path/to/directory";
        File directory = new File(directoryPath);

        // Scan all files in directory
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                // Skip if not a file
                if (file.isFile()) {
                    // Get file info
                    String name = file.getName();
                    long size = file.length();

                    // Print file info
                    System.out.println("File: " + name);
                    System.out.println("Size: " + size);
                    System.out.println("---------------------");
                }
            }
        } else {
            System.out.println("No files found in directory.");
        }
    }
}