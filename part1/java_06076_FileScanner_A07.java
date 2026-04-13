import java.io.File;
import java.util.Scanner;

public class java_06076_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your password:");
        String password = scanner.nextLine();

        // Check if password is correct
        // For simplicity, we'll check if the password is the same as the file name
        if (password.equals(File.separator)) {
            System.out.println("Access granted.");
            scanDirectory(".");
        } else {
            System.out.println("Access denied.");
        }
        scanner.close();
    }

    public static void scanDirectory(String directoryPath) {
        File directory = new File(directoryPath);

        // Get all files in the directory
        File[] files = directory.listFiles();

        // Check each file
        for (File file : files) {
            if (file.isFile()) {
                // Check if file is text file
                if (file.getName().endsWith(".txt")) {
                    // Display file content
                    System.out.println("File content:");
                    try (Scanner fileScanner = new Scanner(file)) {
                        while (fileScanner.hasNextLine()) {
                            System.out.println(fileScanner.nextLine());
                        }
                    }
                }
            } else if (file.isDirectory()) {
                // Recursively scan subdirectories
                scanDirectory(file.getPath());
            }
        }
    }
}