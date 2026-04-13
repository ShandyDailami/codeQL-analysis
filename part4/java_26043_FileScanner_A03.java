import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_26043_FileScanner_A03 {
    public static void main(String[] args) {
        File file = new File("path_to_your_file");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Here you should sanitize the input line to prevent injection attacks
                // This is a simple example, you should not use this method in a production environment
                sanitizeLine(line);
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getPath());
        }
    }

    private static void sanitizeLine(String line) {
        // This is a placeholder for your sanitization method
        // In a real-world application, you should use a safer method for line sanitization
        line = line.replaceAll("[^a-zA-Z0-9]", "");
        // Add any other sanitization here if needed
    }
}