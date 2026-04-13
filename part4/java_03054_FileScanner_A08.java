import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_03054_FileScanner_A08 {
    public static void main(String[] args) {
        try {
            // Create a scanner to read the file
            Scanner scanner = new Scanner(new File("src/main/resources/security-sensitive-file.txt"));

            // While there are more tokens to read, read a token and handle it
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // You can put your security-sensitive operations here
                // For example, checking if the line is null or not
                if (line == null || line.trim().isEmpty()) {
                    continue;
                }

                // Here you can perform any security-sensitive operation on the line
                // For example, checking if the line is a password
                if (line.matches(".*password.*")) {
                    // If the line is a password, you should not log it
                    System.out.println("Password found: " + line);
                    continue;
                }

                // If the line is not a password, you can log it
                System.out.println("Line found: " + line);
            }

            // Close the scanner
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}