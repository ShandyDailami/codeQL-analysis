import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_05718_FileScanner_A01 {

    public static void main(String[] args) {
        File file = new File("path/to/file");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Perform security-sensitive operations related to A01_BrokenAccessControl
                // Example: Print the read line
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}