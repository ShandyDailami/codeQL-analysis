import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_32050_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a File object for the directory
        File directory = new File("path_to_directory");

        // Create a File object for the directory
        File[] files = directory.listFiles();

        // If the directory is empty, print a message
        if (files == null || files.length == 0) {
            System.out.println("No files found in the directory!");
        } else {
            // Iterate over the files
            for (File file : files) {
                // If the file is not a directory, print its name
                if (!file.isDirectory()) {
                    System.out.println(file.getName());
                }
            }
        }
    }
}