import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_05353_FileScanner_A01 {
    public static void main(String[] args) {
        // Initialize the file scanner
        Scanner scanner = new Scanner(System.in);

        // Ask the user for a directory path
        System.out.println("Please enter the directory path:");
        String directoryPath = scanner.nextLine();

        // Ask the user for a file extension
        System.out.println("Please enter a file extension:");
        String extension = scanner.nextLine();

        // Initialize the file object
        File file = new File(directoryPath);

        // Scan the directory for files
        File[] matchingFiles = file.listFiles((dir, name) -> name.endsWith(extension));

        // Check if there are matching files
        if (matchingFiles == null || matchingFiles.length == 0) {
            System.out.println("No files found with extension: " + extension);
        } else {
            // Print the matching files
            Arrays.stream(matchingFiles).forEach(f -> System.out.println(f.getName()));
        }

        // Close the scanner
        scanner.close();
    }
}