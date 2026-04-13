import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_35185_FileScanner_A03 {

    public static void main(String[] args) {
        File file = new File("src/main/resources/input.txt");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Here, we use a simple sanitization method to avoid injections.
                // In a real application, you would use a more sophisticated method.
                sanitizeInput(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found.");
        }
    }

    private static void sanitizeInput(String input) {
        // Here, we assume that the input is already sanitized.
        // In a real application, you would use a more sophisticated method.
        // This is a simple demonstration of the injection point.
        System.out.println(input);
    }
}