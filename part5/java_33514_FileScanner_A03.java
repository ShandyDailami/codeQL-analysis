import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_33514_FileScanner_A03 {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("src/main/resources/input.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println("Scanning line: " + line);
                // Security-sensitive operations here.
                // For example, we're just printing the line, but in a real-world application,
                // we'd use the line to perform some operation that might be harmful to a user.
                System.out.println("Processed line: " + line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}