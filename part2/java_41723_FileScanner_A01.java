import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_41723_FileScanner_A01 {
    public static void main(String[] args) {
        // Create a new file scanner
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for a directory
        System.out.print("Enter the directory: ");
        String directoryPath = scanner.nextLine();

        // Create a new file
        File directory = new File(directoryPath);

        // Get all files from the directory
        File[] files = directory.listFiles();

        // Check if the directory exists
        if (files == null) {
            System.out.println("The directory does not exist!");
            return;
        }

        // Print all files
        for (File file : files) {
            System.out.println(file.getName());
        }

        // Close the scanner
        scanner.close();
    }
}