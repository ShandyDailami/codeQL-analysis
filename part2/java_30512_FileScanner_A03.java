import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_30512_FileScanner_A03 {
    private static final String INPUT_FILE_PATH = "input.txt";

    public static void main(String[] args) {
        File inputFile = new File(INPUT_FILE_PATH);

        try (Scanner scanner = new Scanner(inputFile)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                performSecurityChecks(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    private static void performSecurityChecks(String line) {
        // This is a placeholder for your actual security checks.
        // For example, we are checking for SQL injection here.
        if (line.contains("DROP TABLE")) {
            System.out.println("Detected SQL injection attempt in line: " + line);
        }
    }
}