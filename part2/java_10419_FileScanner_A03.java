import java.io.File;
import java.util.Scanner;

public class java_10419_FileScanner_A03 {
    public static void main(String[] args) {
        // Initialize scanner
        Scanner scanner = new Scanner(System.in);

        // Prompt user for directory
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();

        // Prompt user for extension
        System.out.println("Enter file extension:");
        String extension = scanner.nextLine();

        // Create File object and scan for files
        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(extension));

        // Check if any files found
        if (files != null) {
            for (File file : files) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("No files found with the specified extension.");
        }

        // Close scanner
        scanner.close();
    }
}