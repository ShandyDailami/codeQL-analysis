import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class java_29096_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            listFilesRecursively(directory);
        } else {
            System.out.println("Invalid directory path.");
        }
    }

    private static void listFilesRecursively(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    printFileDetails(file);
                } else if (file.isDirectory()) {
                    listFilesRecursively(file);
                }
            }
        }
    }

    private static void printFileDetails(File file) {
        System.out.println("File: " + file.getName());
        System.out.println("Full path: " + file.getPath());
    }
}