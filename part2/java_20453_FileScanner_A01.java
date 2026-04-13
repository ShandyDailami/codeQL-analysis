import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_20453_FileScanner_A01 {
    public static void main(String[] args) {
        String filename = "path/to/your/file.txt";
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Perform security-sensitive operations like checking passwords, etc.
                // ...
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}