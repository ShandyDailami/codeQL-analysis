import java.io.File;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class java_24848_FileScanner_A08 {
    public static void main(String[] args) {
        // Create a File object for the file to be scanned
        File file = new File("path_to_your_file");

        // Create a Scanner object for the file
        Scanner scanner;
        try {
            scanner = new Scanner(file);
        } catch (NoSuchElementException e) {
            System.out.println("Error opening file: " + file.getPath());
            return;
        }

        // Initialize line number
        int lineNumber = 0;

        // Scan each line in the file
        while (scanner.hasNextLine()) {
            lineNumber++;
            String line = scanner.nextLine();
            System.out.println("Line " + lineNumber + ": " + line);
        }

        // Close the scanner
        scanner.close();
    }
}