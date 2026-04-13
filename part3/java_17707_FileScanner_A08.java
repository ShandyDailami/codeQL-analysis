import java.io.File;
import java.util.Scanner;

public class java_17707_FileScanner_A08 {
    public static void main(String[] args) {
        // Create a scanner to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for a directory path
        System.out.print("Enter a directory path: ");
        String directoryPath = scanner.nextLine();

        // Create a File object representing the directory
        File directory = new File(directoryPath);

        // Use a FileFilter to only include .txt files
        File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

        // Print out the list of .txt files
        for (File txtFile : txtFiles) {
            System.out.println(txtFile.getName());
        }

        // Close the scanner
        scanner.close();
    }
}