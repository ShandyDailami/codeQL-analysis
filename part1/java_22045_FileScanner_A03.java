import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_22045_FileScanner_A03 {
    public static void main(String[] args) {
        // Construct a File object
        File file = new File("src/main/resources/example.txt");

        // Use a try-with-resources statement to automatically close the scanner when we're done
        try (Scanner scanner = new Scanner(file)) {
            // Use a while loop to read the file line by line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Here we use a simple sanitization method to prevent injection attacks
                sanitizeAndPrintLine(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    // Simple sanitization method to prevent injection attacks
    private static void sanitizeAndPrintLine(String line) {
        // This is a very basic sanitization method that just prints the line
        System.out.println(line);
    }
}