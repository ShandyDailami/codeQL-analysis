import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_16796_FileScanner_A03 {
    public static void main(String[] args) {
        // Create a file scanner to read the current directory
        FileScanner fileScanner = new FileScanner();

        // Use the scanner to get the directory to scan
        File directory = new File(".");

        // Scan the directory and print out all the files and directories
        fileScanner.scan(directory);
    }
}

class FileScanner {
    public void scan(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scan(file);
                } else {
                    printFile(file);
                }
            }
        }
    }

    private void printFile(File file) {
        System.out.println(file.getPath());
    }
}