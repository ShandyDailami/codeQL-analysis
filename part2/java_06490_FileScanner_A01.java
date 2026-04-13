import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class java_06490_FileScanner_A01 {
    public static void main(String[] args) {
        // Create a File object for the file you want to read
        File file = new File("path/to/your/file");

        // Check if the file exists
        if (!file.exists()) {
            System.out.println("File does not exist");
            return;
        }

        // Try to create a Scanner for the file
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}