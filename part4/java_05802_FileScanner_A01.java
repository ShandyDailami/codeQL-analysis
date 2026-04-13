import java.io.File;
import java.util.Scanner;

public class java_05802_FileScanner_A01 {
    public static void main(String[] args) {
        // Create a scanner to read user input
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        // Create a File object for the directory
        File directory = new File(directoryPath);

        // Check if the directory exists
        if (!directory.exists()) {
            System.out.println("Directory not found!");
            return;
        }

        // List all files in the directory
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                }
            }
        }

        // Close the scanner
        scanner.close();
    }
}