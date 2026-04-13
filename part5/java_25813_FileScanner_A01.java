import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_25813_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Ask user for directory
        System.out.println("Enter directory:");
        String directory = scanner.nextLine();

        // Create a File object for the directory
        File dir = new File(directory);

        // List all the files in the directory
        listFiles(dir);

        // Close the scanner
        scanner.close();
    }

    private static void listFiles(File dir) throws FileNotFoundException {
        // Get all the files in the directory
        File[] files = dir.listFiles();

        // Check if there are files
        if (files != null) {
            // Loop through all the files
            for (File file : files) {
                // Check if the file is a directory
                if (file.isDirectory()) {
                    // Recursively call the listFiles method for the directory
                    listFiles(file);
                } else {
                    // Print the file's name
                    System.out.println(file.getName());
                }
            }
        }
    }
}