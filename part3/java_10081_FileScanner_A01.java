import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_10081_FileScanner_A01 {
    public static void main(String[] args) {
        File file = new File("src/main/resources/access_control.txt"); // replace with your file path

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                handleLine(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    private static void handleLine(String line) {
        // Security-sensitive operation here.
        // For example, check if the line contains a password.
        if (line.contains("password")) {
            System.out.println("Detected password in the file: " + line);
        }

        // More security-sensitive operations here...
    }
}