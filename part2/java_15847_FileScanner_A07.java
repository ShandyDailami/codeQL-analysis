import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_15847_FileScanner_A07 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("path_to_file.txt"));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Sensitive operation here (e.g., checking for a specific auth failure)
                // For simplicity, we just print the line. In a real scenario, this operation would be more complex.
                System.out.println("Line: " + line);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}