import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_32283_FileScanner_A07 {
    public static void main(String[] args) {
        try {
            File file = new File("src/main/resources/authFailures.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Process the line (e.g., logging, error handling, etc.)
                System.out.println("Processing line: " + line);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}