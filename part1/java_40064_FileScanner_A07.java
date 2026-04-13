import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_40064_FileScanner_A07 {
    public static void main(String[] args) {
        File file = new File("path/to/your/file.txt"); // replace with your file path

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // process each line here, possibly checking for auth failure
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getPath());
        }
    }
}