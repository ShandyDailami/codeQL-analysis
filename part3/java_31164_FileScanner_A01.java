import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_31164_FileScanner_A01 {

    // This is a simple directory to scan
    private static final String SEARCH_DIR = "/path/to/directory";

    public static void main(String[] args) {
        File directory = new File(SEARCH_DIR);
        FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                // Accept all files
                return true;
            }
        };
        scanDirectory(directory, filter);
    }

    private static void scanDirectory(File directory, FilenameFilter filter) {
        File[] files = directory.listFiles(filter);
        if (files == null) {
            // No files found
            System.out.println("No files found.");
            return;
        }
        // Print file names
        for (File file : files) {
            System.out.println(file.getName());
        }
        // Recursively scan subdirectories
        for (File file : files) {
            if (file.isDirectory()) {
                scanDirectory(file, filter);
            }
        }
    }
}