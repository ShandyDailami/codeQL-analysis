import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_06315_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("path_to_your_file");

        // Use a try-with-resources statement to automatically close the Scanner when it's no longer needed
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Process the line (e.g., print it)
                System.out.println(line);
            }
        }
    }
}