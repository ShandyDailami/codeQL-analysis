import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_16283_FileScanner_A01 {
    public static void main(String[] args) {
        File file = new File("path/to/your/file.txt");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // perform security-sensitive operations here
                System.out.println("Processing line: " + line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}