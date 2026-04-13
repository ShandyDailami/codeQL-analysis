import java.io.File;
import java.util.Scanner;

public class java_25405_FileScanner_A01 {
    public static void main(String[] args) {
        // Create a Scanner to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompt user for directory path
        System.out.print("Enter a directory path: ");
        String dirPath = scanner.nextLine();

        // Create a FileScanner to scan files in the given directory
        FileScanner fileScanner = new FileScanner(dirPath);

        // Iterate over each file in the directory
        for (File file : fileScanner.scan()) {
            // For each file, print a message
            System.out.println("Found file: " + file.getName());

            // For each file, attempt to access the file
            try {
                // This will fail if the file is read-only or if the file
                // does not exist (the directory does not exist or the user
                // does not have permission to access it)
                Scanner fileScanner = new Scanner(file);
                while (fileScanner.hasNextLine()) {
                    System.out.println("Found line in file: " + fileScanner.nextLine());
                }
                fileScanner.close();
            } catch (SecurityException e) {
                // If an exception is thrown, print a message to the user
                System.out.println("Error accessing file: " + file.getName());
                System.out.println("Reason: " + e.getMessage());
            }
        }

        // Close the scanner
        scanner.close();
    }
}