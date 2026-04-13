import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_05388_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        // Specify the directory to scan
        File directory = new File("path/to/directory");

        // Create a FileScanner
        FileScanner fileScanner = new FileScanner(directory, ".*\\.txt$");

        // Use the scanner to scan files in the directory
        while (fileScanner.hasNext()) {
            File file = fileScanner.next();
            System.out.println("Scanning file: " + file.getAbsolutePath());

            // Open and use the scanner to read the file
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println("  > " + line);
                }
            }

            System.out.println();
        }

        fileScanner.close();
    }
}