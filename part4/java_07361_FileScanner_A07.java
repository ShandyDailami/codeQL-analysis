import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_07361_FileScanner_A07 {

    public static void main(String[] args) {
        try {
            File file = new File("src/main/resources/authFailureLogs.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println("Found auth failure in line: " + line);

                // Add your security-sensitive operations here, for example:
                // check if the line contains a password
                if (line.contains("password")) {
                    System.out.println("Suspicious activity detected: password found in log.");
                }

                // Check for other security-sensitive operations here...
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Log file not found: " + e.getMessage());
        }
    }
}