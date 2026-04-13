import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_26788_FileScanner_A01 {
    public static void main(String[] args) {
        // Define the directory to scan
        File directory = new File("path_to_your_directory");

        // Use a FileFilter to only accept files that match the pattern
        File[] files = directory.listFiles((dir, name) -> name.endsWith(".txt"));

        // Check if files were found
        if (files == null) {
            System.out.println("No .txt files found in the directory");
            return;
        }

        // Print out the names of the files
        Arrays.stream(files).forEach(file -> System.out.println(file.getName()));
    }
}