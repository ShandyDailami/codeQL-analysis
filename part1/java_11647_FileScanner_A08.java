import java.io.File;
import java.util.Scanner;

public class java_11647_FileScanner_A08 {
    public static void main(String[] args) {
        // Create a scanner to read command line arguments
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        // Create a FileScanner to scan files in the directory
        File file = new File(directoryPath);

        // Check if the directory exists
        if (file.exists()) {
            // Check if the directory is a file
            if (file.isFile()) {
                // Check if the file is readable
                if (file.canRead()) {
                    // Get the file's name
                    String fileName = file.getName();

                    // Print a message
                    System.out.println("File name: " + fileName);
                } else {
                    System.out.println("The file is not readable. Security-sensitive operations cannot be performed.");
                }
            } else {
                System.out.println("The path is not a file. Security-sensitive operations cannot be performed.");
            }
        } else {
            System.out.println("The directory does not exist. Security-sensitive operations cannot be performed.");
        }

        // Close the scanner
        scanner.close();
    }
}