import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_00871_FileScanner_A07 {
    public static void main(String[] args) {
        // Define the file path
        String filePath = "/path/to/your/file";

        // Use try-with-resources for automatic closing of Scanner
        try (Scanner scanner = new Scanner(new File(filePath))) {
            // In a real-world scenario, this might be a security-sensitive operation
            // For the sake of example, let's just print all lines of the file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}