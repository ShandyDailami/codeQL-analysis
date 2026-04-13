import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_09943_FileScanner_A08 {
    public static void main(String[] args) {
        // Create a File object for the directory we're scanning
        File file = new File(".");

        try {
            // Create a Scanner object for the directory
            Scanner scanner = new Scanner(file);

            // Use a while loop to process each file in the directory
            while (scanner.hasNext()) {
                String fileName = scanner.next();
                System.out.println("Processing file: " + fileName);

                // You should implement your security-sensitive operations here
                // This is just a placeholder
                // The actual implementation will depend on your specific requirements
            }

            // Close the Scanner object
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}