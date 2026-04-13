import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_07810_FileScanner_A03 {
    public static void main(String[] args) {
        // Create a File object for the file we're going to scan
        File file = new File("path/to/your/file.txt");

        // Try to open the file for reading
        try (Scanner scanner = new Scanner(file)) {
            // Read the file line by line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // Syntactically correct, but a bit of a naive security measure.
                // In a real-world situation, you would not print out the content of the file like this.
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            // Handle the exception if the file was not found
            System.out.println("File not found: " + e.getMessage());
        }
    }
}