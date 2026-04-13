import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_00284_FileScanner_A01 {
    public static void main(String[] args) {
        FileScanner scanner = new FileScanner();
        File directory = new File("."); // Current directory
        scanner.listFiles(directory);
    }
}

class FileScanner {
    public void listFiles(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    printFileDetails(file);
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getAbsolutePath());
                    listFiles(file);
                }
            }
        }
    }

    private void printFileDetails(File file) {
        System.out.println("File: " + file.getAbsolutePath());
    }
}