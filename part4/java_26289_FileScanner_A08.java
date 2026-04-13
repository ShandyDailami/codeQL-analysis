import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_26289_FileScanner_A08 {

    public static void main(String[] args) {
        // Create a File object for the file to be scanned.
        File file = new File("file.txt");

        // Create a Scanner to read the file.
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println("Line read: " + line);

                // Simulate a security-sensitive operation.
                // Here, we're just printing the length of the line.
                System.out.println("Length of line: " + line.length());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}