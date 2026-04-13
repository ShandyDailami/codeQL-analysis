import java.io.File;
import java.util.Scanner;

public class java_22238_FileScanner_A03 {

    private static String rootDirectory;

    public static void main(String[] args) {
        // Initialize the root directory
        rootDirectory = System.getProperty("user.dir") + "/src/main/java";

        // Request user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        // Sanitize and validate the directory path
        File directory = new File(directoryPath);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory path");
            return;
        }

        // Use the directory path to find all files
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    // Sanitize the file name to avoid security issues
                    String sanitizedFileName = sanitizeFileName(file.getName());
                    System.out.println("File: " + sanitizedFileName);
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getName());
                }
            }
        }

        scanner.close();
    }

    // Method to sanitize a file name to avoid security issues
    private static String sanitizeFileName(String fileName) {
        // Replace '..', '//', and '\\' with '/'
        fileName = fileName.replace("..", "/");
        fileName = fileName.replace("//", "/");
        fileName = fileName.replace("\\", "/");

        // Remove any special characters or patterns
        // This is a simple example and may not be sufficient for all use cases
        fileName = fileName.replaceAll("[\\\\/\\:\\*\\?\\|\"\\<\\>]+", "");

        return fileName;
    }
}