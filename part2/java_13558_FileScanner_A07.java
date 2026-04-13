import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_13558_FileScanner_A07 {
    public static void main(String[] args) {
        // Create a new File object for the file to be scanned
        File file = new File("A07_AuthFailure.txt");

        // Check if the file exists
        if (!file.exists()) {
            System.out.println("File not found");
            return;
        }

        // Try to open the file for reading
        try (Scanner scanner = new Scanner(file)) {
            // While there are still lines to read
            while (scanner.hasNextLine()) {
                // Print the content of the line
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}