import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_02263_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a new scanner to read file input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for a directory path
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        // Create a new File object for the directory
        File directory = new File(path);

        // Check if the directory exists
        if (directory.exists()) {
            // Initialize a counter for file access attempts
            int accessCount = 0;

            // Attempt to access all files in the directory
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    // Check if the file is a directory
                    if (file.isFile()) {
                        // Attempt to access the file
                        if (accessFile(file, scanner, accessCount)) {
                            accessCount++;
                        }
                    }
                }
            }

            // Print the number of file access attempts
            System.out.println("Number of file access attempts: " + accessCount);
        } else {
            System.out.println("Directory does not exist");
        }

        // Close the scanner
        scanner.close();
    }

    private static boolean accessFile(File file, Scanner scanner, int accessCount) {
        // Prompt the user for a password
        System.out.println("Enter password for " + file.getName() + ":");
        String password = scanner.nextLine();

        // Simulate password access attempt
        // In reality, you'd actually attempt to access the file using the provided password
        if (password.equals("password")) {
            System.out.println("Access granted for " + file.getName());
            return true;
        } else {
            System.out.println("Access denied for " + file.getName());
            return false;
        }
    }
}