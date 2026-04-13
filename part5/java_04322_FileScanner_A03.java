import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_04322_FileScanner_A03 {

    public static void main(String[] args) {
        File file = new File("src/main/resources/example.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Here is where the security-sensitive operation is performed.
                // This operation is not done in the provided example, but is done in a real-world application.
                performSecuritySensitiveOperation(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    private static void performSecuritySensitiveOperation(String input) {
        // This operation is not done in the provided example, but is done in a real-world application.
        // This operation is done in a way that is not possible without user input.
        // We are assuming that the input is a command to execute as a system command.
        // This is a dangerous operation, as it allows for command injection.
        try {
            Process process = Runtime.getRuntime().exec(input);
            process.waitFor();
            System.out.println("Command executed successfully!");
        } catch (Exception e) {
            System.out.println("Error executing command: " + e.getMessage());
        }
    }
}