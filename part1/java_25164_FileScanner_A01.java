import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_25164_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a new scanner to read from the command line arguments
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");

        // Read the directory path from the command line
        String directoryPath = scanner.nextLine();

        // Create a File object for the directory
        File directory = new File(directoryPath);

        // Get all files in the directory
        File[] files = directory.listFiles();

        // If files are null, the directory is empty
        if (files == null) {
            System.out.println("The directory is empty!");
        } else {
            // Print all file names
            for (File file : files) {
                System.out.println(file.getName());
            }
        }

        // Close the scanner
        scanner.close();
    }
}