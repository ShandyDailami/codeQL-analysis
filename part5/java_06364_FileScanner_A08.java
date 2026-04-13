import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_06364_FileScanner_A08 {
    public static void main(String[] args) {
        // Path to the file can be changed according to your needs
        File file = new File("path/to/your/file.txt");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // This part of the code is just to demonstrate how you can parse the line
                // If you use this in a production environment, you should handle the integrity failure differently
                if (line.length() > 100) {
                    System.out.println("Line has more than 100 characters: " + line);
                }
            }
            System.out.println("File integrity check passed.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}