import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_00867_FileScanner_A08 {
    public static void main(String[] args) {
        // Create a FileScanner object
        FileScanner fileScanner = new FileScanner();

        // Prompt user for input
        System.out.println("Enter the file path:");
        Scanner scanner = new Scanner(System.in);
        String filePath = scanner.nextLine();

        // Use the FileScanner object to scan the file
        fileScanner.scanFile(filePath);

        // Clean up
        scanner.close();
    }
}

class FileScanner {
    public void scanFile(String filePath) {
        try {
            // Create a File object
            File file = new File(filePath);

            // Check if the file exists
            if (!file.exists()) {
                System.out.println("File does not exist!");
                return;
            }

            // Scan the file
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();

            // Check for integrity failure
            if (!file.canRead()) {
                System.out.println("Integrity failure: The file is not readable!");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}