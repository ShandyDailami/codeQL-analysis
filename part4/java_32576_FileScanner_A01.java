import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_32576_FileScanner_A01 {
    public static void main(String[] args) {
        try {
            // Try to create a new FileScanner with the given directory and filename
            FileScanner fileScanner = new FileScanner("C:\\path\\to\\your\\dir", "filename.txt");

            // Initialize a new Scanner to read the content of the file
            Scanner scanner = new Scanner(fileScanner.getFile());

            // Read the content of the file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

            // Close the Scanner
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}