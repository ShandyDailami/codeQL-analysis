import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Scanner;

public class java_02869_FileScanner_A07 {
    private static final SecureRandom random = new SecureRandom();
    private static final String FILE_PATH = "path_to_your_file.txt"; // replace with your actual file path

    public static void main(String[] args) {
        File file = new File(FILE_PATH);
        Scanner scanner = null;

        // Read file using secure method to avoid potential security issues
        try {
            scanner = new Scanner(new FileReader(file, true));  // use 'true' to append to the file
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            return;
        }

        // Use scanner for reading the file
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }

        // Close scanner to prevent memory leaks
        scanner.close();
    }
}