import java.io.File;
import java.util.Scanner;

public class java_15070_FileScanner_A01 {

    public static void main(String[] args) {

        // Create a new scanner object to read the user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for a directory path
        System.out.println("Please enter the directory path:");
        String directoryPath = scanner.nextLine();

        // Create a new File object and initialize it with the user input directory path
        File directory = new File(directoryPath);

        // Get a list of all files in the directory
        File[] files = directory.listFiles();

        // Iterate over the list of files
        for (File file : files) {
            // Check if the file is a file (not a directory)
            if (file.isFile()) {
                // Print the file name
                System.out.println("File: " + file.getName());
            }
        }

        // Close the scanner
        scanner.close();
    }
}