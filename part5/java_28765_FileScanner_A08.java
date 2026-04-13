import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_28765_FileScanner_A08 {
    public static void main(String[] args) {
        String filePath = "/path/to/your/file"; // replace with your file path
        File file = new File(filePath);

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Perform security-sensitive operations here
                // For example, print the line to the console
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}