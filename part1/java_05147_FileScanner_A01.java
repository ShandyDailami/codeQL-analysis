import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_05147_FileScanner_A01 {
    public static void main(String[] args) {
        // Create a FileScanner
        FileScanner scanner;
        try {
            // Initialize the FileScanner
            scanner = new FileScanner("src/main/resources/access.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            return;
        }

        // Read the file's contents
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }

        // Close the FileScanner
        scanner.close();
    }
}