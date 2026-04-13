import java.io.File;
import java.util.Scanner;

public class java_03953_FileScanner_A03 {
    public static void main(String[] args) {
        // Create a File instance for the current directory
        File file = new File(".");

        // Use a Scanner to read the file
        try (Scanner scanner = new Scanner(file)) {
            // While there are still lines to read, read and print each line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}