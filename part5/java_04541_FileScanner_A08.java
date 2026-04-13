import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_04541_FileScanner_A08 {
    public static void main(String[] args) {
        // Create a new File instance with the given pathname.
        File file = new File("src/main/resources/test.txt");

        try (Scanner scanner = new Scanner(file)) {
            // Use a while loop to read the file line by line.
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}