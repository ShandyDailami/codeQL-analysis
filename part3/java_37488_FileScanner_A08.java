import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_37488_FileScanner_A08 {
    public static void main(String[] args) {
        // Ask user for a directory
        System.out.println("Please enter a directory:");
        Scanner scanner = new Scanner(System.in);
        String directoryPath = scanner.nextLine();

        // Create a File object using the directory path
        File directory = new File(directoryPath);

        // Ask user for a file name
        System.out.println("Please enter a file name:");
        String fileName = scanner.nextLine();

        // Create a File object using the file name and directory path
        File file = new File(directory, fileName);

        // Try to open the file
        try (Scanner fileScanner = new Scanner(file)) {
            // While there are more tokens in the file
            while (fileScanner.hasNext()) {
                // Get the next token
                String line = fileScanner.nextLine();

                // Print the line
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            // If the file was not found, print an error message
            System.out.println("File not found: " + file.getPath());
        }
    }
}