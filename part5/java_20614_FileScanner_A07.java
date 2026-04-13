import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_20614_FileScanner_A07 {
    public static void main(String[] args) {
        // Create a FileScanner that reads from a file
        try (Scanner scanner = new Scanner(new File("yourfile.txt"))) {

            // Loop over the file line by line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // Perform some security-sensitive operations
                if (line.contains("sensitive_string")) {
                    System.out.println("Suspicious activity detected in line: " + line);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}