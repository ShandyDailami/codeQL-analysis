import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_30601_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        // Get the file path from user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file path:");
        String filePath = scanner.nextLine();
        scanner.close();

        // Create a File object and a Scanner to read the file
        File file = new File(filePath);
        Scanner fileScanner = new Scanner(file);

        // Use FileScanner to securely read the file content
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            // Secure operation here, e.g., check for auth failure
            // You can use a simple check to validate if a string contains sensitive information
            if (line.contains("sensitiveInfo")) {
                System.out.println("Authentication failure detected!");
            } else {
                System.out.println(line);
            }
        }

        // Close the scanner
        fileScanner.close();
    }
}