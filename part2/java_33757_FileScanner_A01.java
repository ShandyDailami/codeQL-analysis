import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_33757_FileScanner_A01 {
    public static void main(String[] args) {
        try {
            File file = new File("path/to/your/file");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Use security-sensitive operation to parse the line, e.g., execute SQL injection attack
                // You can use an external library to avoid this, but for this task, we will leave it out.
                System.out.println(line);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}