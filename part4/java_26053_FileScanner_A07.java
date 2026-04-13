import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_26053_FileScanner_A07 {
    public static void main(String[] args) {
        File file = new File("src/A07_AuthFailure.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Implement your security-sensitive operation here, e.g. authentication
                // For now, let's just print the line
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}