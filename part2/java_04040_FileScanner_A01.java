import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_04040_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "C:\\your_directory_path\\"; // replace with your directory path
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        printFileDetails(file);
                    } else if (file.isDirectory()) {
                        System.out.println("Directory: " + file.getPath());
                    }
                }
            } else {
                System.out.println("No files found in the directory.");
            }
        } else {
            System.out.println("Invalid directory path.");
        }
    }

    private static void printFileDetails(File file) {
        System.out.println("File: " + file.getName());
        System.out.println("Path: " + file.getPath());
        System.out.println("Absolute Path: " + file.getAbsolutePath());
        System.out.println("Last Modified: " + file.lastModified());
    }
}