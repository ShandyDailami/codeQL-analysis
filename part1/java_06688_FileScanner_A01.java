import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_06688_FileScanner_A01 {
    public static void main(String[] args) {
        File file = new File("target.txt"); // This should be replaced with your file path

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Perform operations with the line here, for instance, print it to the console
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}