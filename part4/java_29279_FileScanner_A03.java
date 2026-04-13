import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_29279_FileScanner_A03 {
    public static void main(String[] args) {
        // Create a new file for testing
        File testFile = new File("src/test.txt");

        try {
            // Open the file for reading and a scanner
            Scanner scanner = new Scanner(testFile);

            // Print out each line of the file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

            // Close the scanner
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found. " + e.getMessage());
        }
    }
}