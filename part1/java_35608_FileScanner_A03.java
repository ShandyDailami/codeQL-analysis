import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_35608_FileScanner_A03 {
    public static void main(String[] args) {
        try {
            // Create a new File object for the directory
            File directory = new File(".");

            // Create a new FileScanner object to scan the directory
            Scanner scanner = new Scanner(directory);

            // Prompt the user for a file name
            System.out.println("Enter the file name to search:");
            String fileName = scanner.next();

            // Scan the directory for the file
            boolean found = false;
            while (scanner.hasNext() && !found) {
                File file = scanner.nextFile();
                if (file.getName().equals(fileName)) {
                    found = true;
                    System.out.println("File found: " + file.getPath());
                }
            }

            if (!found) {
                System.out.println("File not found.");
            }

            // Close the scanner
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}