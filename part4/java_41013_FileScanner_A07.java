import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_41013_FileScanner_A07 {

    public static void main(String[] args) {
        // Create a new File instance for the file we want to read
        File file = new File("path/to/your/file.txt");

        try (Scanner scanner = new Scanner(file)) {
            // Use a while loop to read the file's content line by line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}