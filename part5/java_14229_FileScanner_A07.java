import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_14229_FileScanner_A07 {
    public static void main(String[] args) {
        // Create a File object for the directory we want to scan
        File directory = new File(".");

        try {
            // Create a Scanner object for the directory
            Scanner scanner = new Scanner(directory);

            // Use the scanner to find all files in the directory
            while (scanner.hasNext()) {
                File file = scanner.nextFile();
                if (!file.isDirectory() && file.getName().endsWith(".txt")) {
                    System.out.println("Found a text file: " + file.getName());
                }
            }

            // Close the scanner
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}