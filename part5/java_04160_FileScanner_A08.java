import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_04160_FileScanner_A08 {
    public static void main(String[] args) {
        // Create a File instance for the target file
        File file = new File("target.txt");

        // Check if the file exists
        if (!file.exists()) {
            System.out.println("File does not exist.");
            System.exit(1);
        }

        // Check if the file is readable
        if (!file.canRead()) {
            System.out.println("Cannot read file.");
            System.exit(1);
        }

        // Create a Scanner instance to read from the file
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(1);
        }

        // Process each line in the file
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println("Processing line: " + line);
        }

        // Close the scanner
        scanner.close();
    }
}