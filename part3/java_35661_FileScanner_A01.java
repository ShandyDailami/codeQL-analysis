import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_35661_FileScanner_A01 {
    public static void main(String[] args) {
        // Create a new Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a directory path
        System.out.print("Enter a directory path: ");
        String path = scanner.nextLine();

        // Get the directory
        File directory = new File(path);

        // Get all files in the directory
        File[] files = directory.listFiles();

        // Check if directory exists and is valid
        if (directory.exists() && directory.isDirectory()) {
            // List all files
            Arrays.stream(files).forEach(file -> {
                if (file.isFile()) {
                    System.out.println(file.getName());
                }
            });
        } else {
            System.out.println("Invalid directory path");
        }

        // Close the scanner
        scanner.close();
    }
}