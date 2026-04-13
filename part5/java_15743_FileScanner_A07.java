import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_15743_FileScanner_A07 {
    private static final String DIRECTORY_PATH = "/path/to/directory";  // Replace with your directory path

    public static void main(String[] args) {
        scanDirectory(new File(DIRECTORY_PATH));
    }

    private static void scanDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    // Security-sensitive operation related to A07_AuthFailure
                    // Here, we're just printing the file name for simplicity
                    System.out.println("File: " + file.getName());
                } else if (file.isDirectory()) {
                    // Recursive call for directories
                    scanDirectory(file);
                }
            }
        }
    }
}