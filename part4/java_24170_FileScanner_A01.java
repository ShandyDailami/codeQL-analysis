import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_24170_FileScanner_A01 {
    public static void main(String[] args) {
        // Create a scanner to read a file
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for a file path
        System.out.println("Enter the file path:");
        String filePath = scanner.nextLine();

        // Create a file object
        File file = new File(filePath);

        // Check if the file exists
        if (!file.exists()) {
            System.out.println("File does not exist!");
            return;
        }

        // Check if the user has the necessary permissions to read the file
        if (!file.canRead()) {
            System.out.println("Insufficient permissions to read the file!");
            return;
        }

        // Use a try-with-resources statement to automatically close the scanner
        try (Scanner fileScanner = new Scanner(file)) {
            // Prompt the user for a line number to read
            System.out.println("Enter the line number to read (or 'q' to quit):");
            String line = scanner.nextLine();

            // Check if the user wants to quit
            if ("q".equalsIgnoreCase(line)) {
                return;
            }

            // Check if the line number is valid
            if (!fileScanner.hasNextInt()) {
                System.out.println("Invalid line number!");
                return;
            }

            int lineNumber = fileScanner.nextInt();
            fileScanner.nextLine(); // Skip the line number

            // Check if the line number is within the range
            if (lineNumber < 1 || lineNumber > fileScanner.nextInt()) {
                System.out.println("Line number is out of range!");
                return;
            }

            // Print the line
            System.out.println("Line " + lineNumber + ": " + fileScanner.nextLine());
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (SecurityException e) {
            System.out.println("Insufficient permissions to read the file!");
        }
    }
}