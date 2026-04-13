import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_19650_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a new scanner that will read the file as a whole
        Scanner scanner = new Scanner(new File("src/main/resources/file.txt"));

        // Keep reading the file until there are no more tokens left
        while (scanner.hasNextLine()) {
            // Read the next line
            String line = scanner.nextLine();

            // TODO: Add your security-sensitive operations here, e.g., sanitize the line to prevent injection attacks

            // Print the sanitized line
            System.out.println(line);
        }

        // Close the scanner
        scanner.close();
    }
}