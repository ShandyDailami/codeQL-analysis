import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_10106_FileScanner_A08 {
    public static void main(String[] args) {
        try {
            File file = new File("src/main/resources/file.txt"); // replace with your file
            Scanner scanner = new Scanner(file);

            // Security-sensitive operation: Read file contents
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);

                // Security-sensitive operation: Attempting to read sensitive data
                String sensitiveData = scanner.nextLine(); // this will throw an integrity failure
                System.out.println("Attempting to read sensitive data: " + sensitiveData);
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}