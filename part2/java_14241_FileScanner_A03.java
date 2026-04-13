import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_14241_FileScanner_A03 {

    public static void main(String[] args) {
        File file = new File("target.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // This is a simple check for string injection. For a real-world application,
                // you would likely use a more sophisticated method to detect SQL injection or XSS attacks.
                if (line.contains("' OR '1'='1")) {
                    System.out.println("String injection detected in: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getPath());
        }
    }
}