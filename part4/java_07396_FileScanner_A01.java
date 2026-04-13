import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_07396_FileScanner_A01 {
    public static void main(String[] args) {
        try {
            // Create a FileScanner instance
            FileScanner fs = new FileScanner();

            // Define the file path
            String filePath = "/path/to/your/file";

            // Open the file
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            // Use the FileScanner to read the file line by line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

            // Close the scanner
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}