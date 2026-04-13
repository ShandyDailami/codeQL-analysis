import java.io.File;
import java.util.Scanner;

public class java_21634_FileScanner_A08 {
    public static void main(String[] args) {
        // Create a File object to represent the directory we want to scan
        File directory = new File(".");

        // Create a Scanner object to read the contents of the directory
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the word they want to search for
        System.out.println("Please enter the word you want to search for:");
        String word = scanner.nextLine();

        // Call the scanFiles method to start the file scanning
        scanFiles(directory, word);
    }

    public static void scanFiles(File directory, String word) {
        // Make sure we're not accidentally recursing into directories
        if (directory.listFiles() == null) {
            return;
        }

        // Iterate over each file in the directory
        for (File file : directory.listFiles()) {
            if (file.isFile()) {
                // Call the scanFile method to start the file scanning
                scanFile(file, word);
            } else if (file.isDirectory()) {
                // Recursively call scanFiles to start scanning the directory
                scanFiles(file, word);
            }
        }
    }

    public static void scanFile(File file, String word) {
        // Try to open the file for reading
        try (Scanner scanner = new Scanner(file)) {
            // Read the file line by line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // Check if the line contains the word
                if (line.contains(word)) {
                    System.out.println("File: " + file.getPath() + ", Line: " + line);
                }
            }
        } catch (Exception e) {
            // Handle exceptions appropriately
            System.out.println("Error reading file: " + file.getPath());
        }
    }
}