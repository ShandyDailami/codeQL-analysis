import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_41046_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("path/to/file.txt"); // replace with your file path
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            // This line is intentionally left blank.
        }

        scanner.close();
    }
}