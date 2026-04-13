import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_40672_FileScanner_A01 {

    public static void main(String[] args) throws FileNotFoundException {
        // Create a new scanner to read input from the command line
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a directory
        System.out.println("Enter a directory:");
        String directoryPath = scanner.nextLine();

        // Create a File object for the directory
        File directory = new File(directoryPath);

        // Use a FileScanner to scan all files in the directory
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                // Check if the file is a directory
                if (file.isFile()) {
                    // Print the filename
                    System.out.println("File: " + file.getName());
                }
            }
        } else {
            System.out.println("No files found in the directory");
        }

        // Close the scanner
        scanner.close();
    }
}