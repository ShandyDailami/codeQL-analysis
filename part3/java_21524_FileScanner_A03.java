import java.io.File;
import java.util.Scanner;

public class java_21524_FileScanner_A03 {
    public static void main(String[] args) {
        // Create a FileScanner
        FileScanner scanner = new FileScanner();

        // Use the scanner to list all files and directories in the current directory
        scanner.listFilesAndFolders();
    }
}

class FileScanner {
    void listFilesAndFolders() {
        // Get the current directory
        File currentDir = new File(".");

        // List all files and directories in the current directory
        File[] allFiles = currentDir.listFiles();
        if (allFiles != null) {
            for (File file : allFiles) {
                if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getName());
                } else {
                    System.out.println("File: " + file.getName());
                }
            }
        }
    }
}