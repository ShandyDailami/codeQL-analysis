import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_16629_FileScanner_A07 {
    public static void main(String[] args) {
        // Create a FileScanner
        FileScanner scanner = new FileScanner(new File("."), false);

        // Scan through all the files in the directory
        while (scanner.hasNext()) {
            String filePath = scanner.next();
            try {
                // Open the file
                Scanner fileScanner = new Scanner(new File(filePath));

                // While there are lines in the file
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();

                    // Check for specific security-sensitive operations
                    if (line.contains("auth failure")) {
                        System.out.println("Detected auth failure in: " + filePath);
                    }
                }
                // Close the file
                fileScanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + filePath);
            }
        }
        // Close the FileScanner
        scanner.close();
    }
}