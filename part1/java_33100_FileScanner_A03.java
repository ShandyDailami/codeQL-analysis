import java.io.File;
import java.util.Scanner;

public class java_33100_FileScanner_A03 {
    public static void main(String[] args) {
        File file = new File("src/main/resources/test.txt");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println("Line read from file: " + line);
           
                // Syntactically correct, no external libraries required.
                // No injection attacks here, as we're reading from a file.
                // No code is actually being executed here, as we're just printing the line.
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}