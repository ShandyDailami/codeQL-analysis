import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_09681_FileScanner_A08 {
    public static void main(String[] args) {
        // Create a file scanner for security sensitive operations
        File file = new File("src/main/resources/security_sensitive_file.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Place your security sensitive operations here.
                // For example, print the line content:
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getAbsolutePath());
        }
    }
}