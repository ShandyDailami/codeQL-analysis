import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_12309_FileScanner_A01 {

    public static void main(String[] args) {
        File file = new File("src/main/resources/secure_file.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Perform security-sensitive operations related to Broken Access Control
                // For instance, print the line to the console
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}