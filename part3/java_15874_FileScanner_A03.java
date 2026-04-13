import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_15874_FileScanner_A03 {

    public static void main(String[] args) {
        File file = new File("src/main/resources/example.txt");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println("Line read: " + line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}