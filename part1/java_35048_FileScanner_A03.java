import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_35048_FileScanner_A03 {
    public static void main(String[] args) {
        File file = new File("file.txt");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Sensitive operation related to A03_Injection
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}