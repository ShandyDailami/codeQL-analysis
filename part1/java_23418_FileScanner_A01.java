import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_23418_FileScanner_A01 {
    public static void main(String[] args) {
        // Create a scanner to read input from the command line
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for the file name
        System.out.print("Enter the file name to search: ");
        String fileName = scanner.next();

        // Get the current directory
        File directory = new File(".");

        // Search for the file in the current directory
        File[] files = directory.listFiles((dir, name) -> name.equals(fileName));

        // Print out all the files that were found
        if (files != null) {
            for (File file : files) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("No files found.");
        }

        // Close the scanner
        scanner.close();
    }
}