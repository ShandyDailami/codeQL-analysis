import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_22133_FileScanner_A07 {
    public static void main(String[] args) {
        // Create a scanner to read command line arguments
        Scanner scanner = new Scanner(System.in);

        // Prompt user for directory path
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        // Create a File object for the directory
        File directory = new File(directoryPath);

        // Check if the directory exists
        if (!directory.exists()) {
            System.out.println("The provided directory does not exist");
            return;
        }

        // Check if the directory is a directory
        if (!directory.isDirectory()) {
            System.out.println("The provided path is not a directory");
            return;
        }

        // Get all files in the directory
        File[] files = directory.listFiles();

        // Check if any files were found
        if (files == null) {
            System.out.println("No files found in the directory");
            return;
        }

        // Print all files
        Arrays.stream(files).forEach(file -> System.out.println(file.getName()));
    }
}