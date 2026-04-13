import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_31459_FileScanner_A01 {
    public static void main(String[] args) {
        // Provide the directory to scan
        File directory = new File(".");

        try {
            // Use the FileScanner to scan the directory
            Scanner scanner = new Scanner(directory);
            while (scanner.hasNext()) {
                // Print the name of each file
                System.out.println(scanner.next());
            }
            // Close the scanner
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("The directory does not exist.");
        }
    }
}