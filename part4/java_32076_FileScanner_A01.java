import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class java_32076_FileScanner_A01 {
    public static void main(String[] args) {
        // Create a scanner to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompt user for directory path
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        // Prompt user for file extension
        System.out.println("Enter the file extension:");
        String fileExtension = scanner.nextLine();

        // Create a set to hold the file paths
        Set<String> filePaths = new HashSet<>();

        // Get all files in the directory with the specified extension
        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

        // Check if directory exists and has files
        if (files != null) {
            for (File file : files) {
                filePaths.add(file.getPath());
            }
        }

        // Print all file paths
        for (String path : filePaths) {
            System.out.println(path);
        }

        // Close the scanner
        scanner.close();
    }
}