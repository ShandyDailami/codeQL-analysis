import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_10719_FileScanner_A08 {
    public static void main(String[] args) {
        File file = new File("your_file_path");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}