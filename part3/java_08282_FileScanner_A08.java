import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_08282_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a File instance for the directory to be scanned.
        File directory = new File(".");

        // Use the FileScanner to iterate over all files in the directory.
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    // If the file is a file (not a directory), print its name.
                    System.out.println(file.getName());
                } else if (file.isDirectory()) {
                    // If the file is a directory, recurse into it.
                    listFilesRecursively(file);
                }
            }
        }
    }

    private static void listFilesRecursively(File directory) throws FileNotFoundException {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    // If the file is a file (not a directory), print its name.
                    System.out.println(file.getName());
                } else if (file.isDirectory()) {
                    // If the file is a directory, recurse into it.
                    listFilesRecursively(file);
                }
            }
        }
    }
}