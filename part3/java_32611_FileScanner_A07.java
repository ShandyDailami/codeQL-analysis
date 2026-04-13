import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class java_32611_FileScanner_A07 {
    public static void main(String[] args) {
        String dirPath = "path/to/directory"; // Replace with your directory path
        File directory = new File(dirPath);
        
        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        printFileInfo(file);
                    } else if (file.isDirectory()) {
                        printDirectoryInfo(file);
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }

    private static void printFileInfo(File file) {
        System.out.println("File: " + file.getPath());
        System.out.println("Name: " + file.getName());
        System.out.println("Size: " + file.length() + " bytes");
        System.out.println("------");
    }

    private static void printDirectoryInfo(File file) {
        System.out.println("Directory: " + file.getPath());
        System.out.println("------");
    }
}