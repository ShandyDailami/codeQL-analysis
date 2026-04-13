import java.io.File;
import java.util.Scanner;

public class java_11535_FileScanner_A03 {

    public static void main(String[] args) {

        // Create a new scanner
        Scanner scanner = new Scanner(System.in);

        // Request user input for the directory path
        System.out.println("Please enter the directory path:");
        String directoryPath = scanner.nextLine();

        // Create a File object for the directory
        File directory = new File(directoryPath);

        // List all files in the directory
        File[] files = directory.listFiles();

        // If there are no files, print a message
        if (files == null) {
            System.out.println("No files found in the directory!");
            return;
        }

        // Print out the name of each file
        for (File file : files) {
            System.out.println(file.getName());
        }

        // Close the scanner
        scanner.close();
    }
}