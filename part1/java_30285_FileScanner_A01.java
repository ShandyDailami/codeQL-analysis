import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_30285_FileScanner_A01 {
    public static void main(String[] args) {
        // Define the directory to scan
        File directory = new File("path/to/directory");

        scanDirectory(directory);
    }

    private static void scanDirectory(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                // Check if the file is hidden (e.g., starts with a dot)
                if (!file.getName().startsWith(".")) {
                    // Check if the file is a directory
                    if (file.isDirectory()) {
                        // Recursively scan the directory
                        scanDirectory(file);
                    } else {
                        // Check if the file has been accessed
                        if (file.lastModified() > System.currentTimeMillis() - (1000 * 60 * 60)) { // 1 hour
                            // Print the file name
                            System.out.println("File accessed: " + file.getPath());
                        }
                    }
                }
            }
        }
    }
}