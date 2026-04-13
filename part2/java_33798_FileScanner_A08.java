import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_33798_FileScanner_A08 {
    public static void main(String[] args) {
        // Define the directory path
        File directory = new File(".");

        // Use a FileScanner to list all files in the current directory
        File[] files = directory.listFiles();

        if (files != null) {
            Arrays.sort(files); // Sort the files by name
            for (File file : files) {
                // If the file is a directory, print its name
                if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getName());
                } else {
                    // If the file is a regular file, print its name
                    System.out.println("File: " + file.getName());
                }
            }
        } else {
            System.out.println("No files in this directory");
        }
    }
}