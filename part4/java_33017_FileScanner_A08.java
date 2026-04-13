import java.io.File;
import java.util.Scanner;

public class java_33017_FileScanner_A08 {
    public static void main(String[] args) {
        // Create a new Scanner for reading user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for a directory
        System.out.print("Enter a directory: ");
        String directoryPath = scanner.nextLine();

        // Create a new File object for the directory
        File directory = new File(directoryPath);

        // List all files in the directory
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                }
            }
        } else {
            System.out.println("No files found in the directory");
        }

        // Close the Scanner
        scanner.close();
    }
}