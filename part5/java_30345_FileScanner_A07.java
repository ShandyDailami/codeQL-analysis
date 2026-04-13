import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_30345_FileScanner_A07 {
    public static void main(String[] args) {
        // Specify the directory
        String directory = "/path/to/directory";

        // Create a new FileScanner
        try (FileScanner scanner = new FileScanner()) {
            // Scan the directory
            scanner.scan(new File(directory));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}