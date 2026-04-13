import java.io.File;
import java.util.Scanner;

public class java_03859_FileScanner_A01 {
    public static void main(String[] args) {
        File file = new File("example.txt");

        // Verify if file exists
        if (file.exists()) {
            // Create a scanner to read the file
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                }
            } catch (Exception e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        } else {
            System.out.println("File not found");
        }
    }
}