import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_02674_FileScanner_A08 {
    public static void main(String[] args) {
        // Create a File object
        File file = new File("sample.txt");

        try (Scanner scanner = new Scanner(file)) {
            // Scanner can read file line by line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}