import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_42013_FileScanner_A07 {

    public static void main(String[] args) {
        // Create a Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for the directory path
        System.out.println("Please enter the directory path:");
        String directoryPath = scanner.nextLine();

        // Get all files in the directory
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        // Print out the names of all files
        if (files != null) {
            for (File file : files) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("No files found in the directory.");
        }

        // Close the scanner
        scanner.close();
    }

}