import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_32384_FileScanner_A01 {
    public static void main(String[] args) {
        // Create a new file scanner
        Scanner scanner = new Scanner(System.in);

        // Ask the user for the file path
        System.out.println("Enter the file path:");
        String filePath = scanner.nextLine();

        // Try to create a new file
        File file = new File(filePath);

        // Check if the file exists
        if (!file.exists()) {
            System.out.println("File not found!");
            return;
        }

        // Check if the file can be read
        if (!file.canRead()) {
            System.out.println("Unable to read file!");
            return;
        }

        // Try to create a new scanner for the file
        try (Scanner fileScanner = new Scanner(file)) {
            // While there are more tokens in the file scanner
            while (fileScanner.hasNextLine()) {
                // Print the next line
                String line = fileScanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}