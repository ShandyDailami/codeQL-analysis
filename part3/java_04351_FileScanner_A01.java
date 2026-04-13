import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_04351_FileScanner_A01 {
    public static void main(String[] args) {
        // Create a new File instance for the directory you want to scan
        File directory = new File(".");
        
        // Get all files in the directory
        File[] listOfFiles = directory.listFiles();

        // Check if listOfFiles is not null
        if (listOfFiles != null) {
            // Sort the files by their names
            Arrays.sort(listOfFiles);

            // Print all file names
            for (File file : listOfFiles) {
                System.out.println(file.getName());
            }
        }
    }
}