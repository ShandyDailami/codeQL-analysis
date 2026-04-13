import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_24710_FileScanner_A08 {
    public static void main(String[] args) {
        File file = new File("src/main/resources/test.txt"); // replace with your path

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println("Line: " + line);

                // Example of security-sensitive operation, replace with your own operation
                if (line.contains("integrity failure")) {
                    System.out.println("Detected integrity failure, proceeding...");
                    // Proceed with security-sensitive operation
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}