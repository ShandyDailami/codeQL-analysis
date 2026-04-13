import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_13808_FileScanner_A08 {
    public static void main(String[] args) {
        // Create a File object for the file we want to scan
        File file = new File("path/to/your/file");

        // Use a try-with-resources statement to automatically close the scanner when we're done
        try (Scanner scanner = new Scanner(file)) {
            // Now, we can use the scanner to read the file's content
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Do something with the line, like logging it
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}