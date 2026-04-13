import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_19999_FileScanner_A08 {
    public static void main(String[] args) {
        // Creating a file scanner
        File file = new File("src/main/resources/file.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Syntactically correct but not security-sensitive as we only read the file content
                // Perform integrity check if needed.
                // But here we only print the line
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}