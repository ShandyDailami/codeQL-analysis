import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_24577_FileScanner_A03 {
    private static final String SENSITIVE_FILE = "sensitiveFile.txt";

    public static void main(String[] args) {
        File file = new File(SENSITIVE_FILE);
        if (!file.exists()) {
            System.out.println("File not found: " + SENSITIVE_FILE);
            return;
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Add security-sensitive operations here, such as command injection
                // e.g., use of StringBuilder to avoid String concatenation
                StringBuilder sb = new StringBuilder(line);
                for (int i = 0; i < sb.length(); i++) {
                    sb.setCharAt(i, (char) (sb.charAt(i) ^ 'A'));
                }
                System.out.println(sb.toString());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + SENSITIVE_FILE);
        }
    }
}