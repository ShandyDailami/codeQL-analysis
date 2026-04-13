import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_20421_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a File object that represents the file you want to scan
        File file = new File("path/to/file.txt");

        // Create a Scanner object that reads from the file
        Scanner scanner = new Scanner(file);

        // Use the Scanner object to read the file line by line
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            // Process the line here...
        }

        // Close the Scanner object when done
        scanner.close();
    }
}