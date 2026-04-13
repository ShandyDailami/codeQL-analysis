import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class java_38617_FileScanner_A03 {
    public static void main(String[] args) {
        File source = new File("source.txt");
        File target = new File("target.txt");

        try (Scanner scanner = new Scanner(new FileReader(source));
             FileWriter writer = new FileWriter(target, true)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                line = sanitizeInput(line); // Sanitize the line for injection attacks
                writer.write(line);
                writer.write(System.lineSeparator());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Source file not found.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading the source file.");
        }
    }

    private static String sanitizeInput(String input) {
        // This method is intentionally kept simple for the sake of brevity.
        // In real-world applications, this would involve more complex methods for
        // sanitizing the input to prevent injection attacks.
        return input;
    }
}