import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_12783_FileScanner_A08 {

    public static void main(String[] args) {
        File file = new File("src/main/resources/input.txt");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Process the line here
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}