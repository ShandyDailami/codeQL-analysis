import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_00419_FileScanner_A01 {
    public static void main(String[] args) {
        // Create a File object to represent the directory to be scanned
        File dir = new File("src/main/java");

        // Use recursive method to scan all subdirectories and files
        scanDirectory(dir);
    }

    private static void scanDirectory(File directory) {
        // Get all files in the directory
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                // Check if the file is a directory
                if (file.isDirectory()) {
                    // Recursively scan the directory
                    scanDirectory(file);
                } else {
                    // Use a scanner to read the file
                    try (Scanner scanner = new Scanner(file)) {
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            // Here you can implement security-sensitive operations related to A01_BrokenAccessControl
                            // For instance, you can check if the line contains a password or access token
                            if (line.contains("password") || line.contains("access_token")) {
                                System.out.println("Suspicious activity detected in file: " + file.getAbsolutePath());
                            }
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}