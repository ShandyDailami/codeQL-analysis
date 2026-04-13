import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class java_17840_FileScanner_A08 {

    public static void main(String[] args) {
        String directoryPath = "<insert-directory-path-here>"; // insert directory path
        scanDirectory(directoryPath);
    }

    private static void scanDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    printFileDetails(file);
                } else if (file.isDirectory()) {
                    scanDirectory(file.getPath());
                }
            }
        }
    }

    private static void printFileDetails(File file) {
        System.out.println("File Name: " + file.getName());
        System.out.println("File Size: " + file.length() + " bytes");
        System.out.println("File Location: " + file.getPath());
        System.out.println("-------------------------------");
    }
}