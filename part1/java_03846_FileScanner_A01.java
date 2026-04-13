import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_03846_FileScanner_A01 {
    public static void main(String[] args) {
        File file = new File("src/main/resources/access_control_file.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println("Line read: " + line);
                // Here, you might want to perform some security-sensitive operation.
                // For simplicity, we will just print the line as is.
                System.out.println("Operation result: " + line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}