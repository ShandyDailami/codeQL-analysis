import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_41781_FileScanner_A01 {
    public static void main(String[] args) {
        // Create a scanner to read input from the command line
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for a directory
        System.out.println("Enter a directory:");
        String directory = scanner.nextLine();

        // Create a FileScanner to search the directory
        FileScanner fileScanner = new FileScanner(new File(directory), ".*\\.txt$");

        // Use a try-with-resources statement to make sure the scanner is closed after use
        try (fileScanner) {
            // Use the scanner to find all files that match the pattern
            while (fileScanner.hasNext()) {
                String fileName = fileScanner.next();
                System.out.println("Found file: " + fileName);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Directory not found: " + e.getMessage());
        }
    }
}