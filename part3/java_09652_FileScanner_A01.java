import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_09652_FileScanner_A01 {
    public static void main(String[] args) {
        // Create a scanner to read user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");

        // Read the directory path
        String directoryPath = scanner.nextLine();

        // Create a FileScanner to list all files in a directory
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            // List all files and directories
            Arrays.stream(files).forEach(file -> {
                System.out.println(file.getName());

                // If the file is a directory, list all files in it
                if (file.isDirectory()) {
                    listFilesInDirectory(file);
                }
            });
        } else {
            System.out.println("No files found in the directory.");
        }

        // Close the scanner
        scanner.close();
    }

    private static void listFilesInDirectory(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            Arrays.stream(files).forEach(file -> {
                System.out.println(" - " + file.getName());

                // If the file is a directory, list all files in it
                if (file.isDirectory()) {
                    listFilesInDirectory(file);
                }
            });
        }
    }
}