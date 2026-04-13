import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_13941_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        printFileDetails(file);
                    } else if (file.isDirectory()) {
                        scanDirectory(file);
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist!");
        }
    }

    private static void scanDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    printFileDetails(file);
                } else if (file.isDirectory()) {
                    scanDirectory(file);
                }
            }
        }
    }

    private static void printFileDetails(File file) {
        System.out.println("File Name: " + file.getName());
        System.out.println("File Path: " + file.getAbsolutePath());
    }
}