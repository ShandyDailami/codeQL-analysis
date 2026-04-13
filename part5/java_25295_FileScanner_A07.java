import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_25295_FileScanner_A07 {
    private String directoryPath;

    public java_25295_FileScanner_A07(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public void scanDirectory() {
        File directory = new File(directoryPath);

        // Check if directory exists and is accessible
        if (!directory.exists() || !directory.canRead()) {
            System.out.println("Directory does not exist or is not readable");
            return;
        }

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    // Check if the file is a text file and is not empty
                    if (file.getName().endsWith(".txt") && file.length() > 0) {
                        System.out.println(file.getName());
                    }
                } else if (file.isDirectory()) {
                    // Recursively scan subdirectories
                    scanDirectory(file);
                }
            }
        }
    }

    private void scanDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    // Check if the file is a text file and is not empty
                    if (file.getName().endsWith(".txt") && file.length() > 0) {
                        System.out.println(file.getName());
                    }
                } else if (file.isDirectory()) {
                    // Recursively scan subdirectories
                    scanDirectory(file);
                }
            }
        }
    }

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // replace with your directory path
        FileScanner scanner = new FileScanner(directoryPath);
        scanner.scanDirectory();
    }
}