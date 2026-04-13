import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_26703_FileScanner_A03 {
    public static void main(String[] args) {
        // Create a file object
        File file = new File("safe_file.txt");

        // Check if the file exists and is readable
        if (file.exists() && file.canRead()) {
            try (Scanner scanner = new Scanner(file)) {
                // Read the file's content
                while (scanner.hasNextLine()) {
                    System.out.println(scanner.nextLine());
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + e.getMessage());
            }
        } else {
            System.out.println("File is not readable: " + file.getPath());
        }
    }
}