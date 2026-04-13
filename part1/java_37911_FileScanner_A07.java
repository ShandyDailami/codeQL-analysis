import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_37911_FileScanner_A07 {
    public static void main(String[] args) {
        File file = new File("path_to_your_file");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Perform some security-sensitive operation here, e.g., check for password attempts,
                // check for common login failures, etc.
                System.out.println("Found line: " + line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}