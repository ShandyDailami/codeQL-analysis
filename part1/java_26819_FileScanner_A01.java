import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_26819_FileScanner_A01 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("/path/to/file"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Security-sensitive operation related to A01_BrokenAccessControl
                // For example, printing the line to console
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}