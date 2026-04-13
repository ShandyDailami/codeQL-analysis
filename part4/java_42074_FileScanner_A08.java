import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_42074_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        // File to scan
        File file = new File("path/to/your/file");

        // Create a Scanner to read the file
        Scanner scanner = new Scanner(file);

        // Use the Scanner to read and check each line of the file
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains("security-sensitive-operation")) {
                // If the line contains a security-sensitive operation, print a message and exit
                System.out.println("Found security-sensitive operation, exiting...");
                System.exit(0);
            }
        }

        // If no security-sensitive operation was found, print a message and exit
        System.out.println("No security-sensitive operation found, exiting...");
        System.exit(0);
    }
}