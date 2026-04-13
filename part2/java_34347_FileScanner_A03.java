import java.io.File;
import java.util.Scanner;

public class java_34347_FileScanner_A03 {
    private static final String FILENAME = "your_file_path.txt";
    private static final String SECURITY_SENSITIVE_OPERATION = "security_sensitive_operation";

    public static void main(String[] args) {
        File file = new File(FILENAME);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(SECURITY_SENSITIVE_OPERATION)) {
                    System.out.println("Line contains security-sensitive operation: " + line);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}