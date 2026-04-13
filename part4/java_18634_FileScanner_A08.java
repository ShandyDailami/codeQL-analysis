import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_18634_FileScanner_A08 {
    public static void main(String[] args) {
        File file = new File("src/main/resources/data.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (isUnauthorizedOperation(line)) {
                    System.out.println("Detected unauthorized operation on file: " + line);
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private static boolean isUnauthorizedOperation(String line) {
        // Simulate a security-sensitive operation by checking if line contains sensitive information
        // In a real-world scenario, this would likely involve more sophisticated methods of checking for integrity failures
        return line.toLowerCase().contains("password") || line.toLowerCase().contains("key") || line.toLowerCase().contains("secret") || line.toLowerCase().contains("token");
    }
}