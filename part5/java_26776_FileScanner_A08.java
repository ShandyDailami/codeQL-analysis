import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_26776_FileScanner_A08 {
    public static void main(String[] args) {
        File file = new File("src/main/resources/test.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Perform security-sensitive operations here, e.g., check for integrity failure
                // ...
                // Continue with line processing
                // ...
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}