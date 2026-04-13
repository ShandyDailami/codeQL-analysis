import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_00506_FileScanner_A08 {
    public static void main(String[] args) {
        File file = new File("legacy_file.txt");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // You can do some operation here, like printing the line
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}