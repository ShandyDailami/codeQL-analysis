import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_08301_FileScanner_A03 {
    public static void main(String[] args) {
        File file = new File("path_to_file"); // Provide the file path here
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line); // You can replace this with any operation related to security-sensitive operations
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}