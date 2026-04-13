import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_30938_FileScanner_A03 {
    public static void main(String[] args) {
        File file = new File("example.txt"); // specify your file path here
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
                // You can add here the code to handle the line, e.g., for security-sensitive operations
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}