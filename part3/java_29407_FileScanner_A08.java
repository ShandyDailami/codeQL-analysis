import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_29407_FileScanner_A08 {

    public static void main(String[] args) throws FileNotFoundException {
        // Define the directory
        File directory = new File("path/to/directory");

        // Create a FileScanner
        try (Scanner scanner = new Scanner(directory)) {
            // Use the FileScanner's methods
            while (scanner.hasNext()) {
                String fileName = scanner.next();
                System.out.println("File name: " + fileName);
            }
        }
    }
}