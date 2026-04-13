import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_13696_FileScanner_A03 {
    public static void main(String[] args) {
        // Create a new scanner object to read the file
        Scanner scanner = new Scanner(System.in);

        // Request user input
        System.out.println("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        try {
            // Use File object to read the file
            File directory = new File(directoryPath);

            // Use recursive file scan to get all file paths
            getAllFiles(directory);
        } catch (Exception e) {
            System.out.println("Invalid directory path. Please try again.");
        } finally {
            scanner.close();
        }
    }

    private static void getAllFiles(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    // Check for potential file injection attack
                    checkForInjection(file);
                } else if (file.isDirectory()) {
                    // Recursive call to get all file paths in the directory
                    getAllFiles(file);
                }
            }
        }
    }

    private static void checkForInjection(File file) {
        // Here you can implement code to check for injection attacks
        // This is a simple example and may not be effective for all use cases
        // For example, this method will try to read the file content and compare it with a known string
        // If the content matches a known string, it's a potential injection point
        String knownString = "A03_Injection";

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(knownString)) {
                    System.out.println("Potential injection attack detected in file: " + file.getPath());
                    // Here you can implement code to handle the attack
                    // For example, you can print the content of the file and stop the execution
                    System.out.println("File content: ");
                    System.out.println(line);
                    System.exit(0);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file: " + file.getPath());
        }
    }
}