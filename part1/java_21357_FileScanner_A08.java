import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_21357_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        printFileDetails(file);
                    } else if (file.isDirectory()) {
                        System.out.println("Directory: " + file.getPath());
                        listFilesInDirectory(file);
                    }
                }
            }
        } else {
            System.out.println("The specified directory does not exist or is not a directory.");
        }
    }

    private static void listFilesInDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    printFileDetails(file);
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getPath());
                    listFilesInDirectory(file);
                }
            }
        }
    }

    private static void printFileDetails(File file) {
        System.out.println("File: " + file.getName());
        System.out.println("Size: " + file.length() + " bytes");
        System.out.println("Absolute path: " + file.getAbsolutePath());
        System.out.println("Last modified: " + file.lastModified());
    }
}