import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_31505_FileScanner_A03 {

    // Method to read the file and print each line
    private void readFile(String filePath) {
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        }
    }

    // Main method to test the readFile method
    public static void main(String[] args) {
        SecureFileScanner scanner = new SecureFileScanner();
        scanner.readFile("/path/to/your/file");  // Use real path to file
    }
}