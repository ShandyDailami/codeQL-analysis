import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_25839_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a new File object to represent a file on the disk.
        File file = new File("target/test.txt");

        // Use a Scanner to read the file
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Check for injection attempts here
                // This is a very basic check for SQL injection, it may not be suitable for other attacks
                if (line.contains("' OR '1'='1")) {
                    System.out.println("Detected SQL Injection attack!");
                }
            }
        }
    }
}