import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_00304_FileScanner_A01 {

    public static void main(String[] args) {
        FileScanner scanner = new FileScanner();
        scanner.startScanning("/path/to/directory");
    }

}

class FileScanner {

    private static final String SECURITY_WARNING = "Running FileScanner in a security-sensitive operation.";

    public void startScanning(String directoryPath) {
        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println(SECURITY_WARNING + " Scanning file: " + file.getName());
                        // Add your security-sensitive operations here
                        // For example, verify if file is accessible
                        if (file.canRead()) {
                            System.out.println("File is accessible: " + file.getName());
                        } else {
                            System.out.println("Access denied for file: " + file.getName());
                        }
                    } else if (file.isDirectory()) {
                        System.out.println(SECURITY_WARNING + " Scanning directory: " + file.getName());
                        // Recursively scan directories for files
                        startScanning(file.getPath());
                    }
                }
            }
        } else {
            System.out.println("Directory not found: " + directoryPath);
        }
    }

}