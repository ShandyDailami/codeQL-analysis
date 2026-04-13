import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_11815_FileScanner_A08 {
    public static void main(String[] args) {
        // Create a scanner to read from the command line arguments
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a directory
        System.out.println("Please enter the directory:");
        String directory = scanner.nextLine();

        // Create a new File object for the directory
        File dir = new File(directory);

        // Check if the directory exists
        if (!dir.exists()) {
            System.out.println("Directory does not exist.");
            return;
        }

        // Create a new File object for the current file
        File[] files = dir.listFiles();

        // Check if there are files in the directory
        if (files == null) {
            System.out.println("Directory is empty.");
            return;
        }

        // Loop over the files
        for (File file : files) {
            // Check if the file is a directory
            if (file.isDirectory()) {
                // If the file is a directory, print the directory name
                System.out.println("Directory: " + file.getPath());
            } else {
                // If the file is not a directory, print the file name
                System.out.println("File: " + file.getPath());
            }
        }

        // Close the scanner
        scanner.close();
    }
}