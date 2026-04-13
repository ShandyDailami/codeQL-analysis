import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_07005_FileScanner_A07 {
    public static void main(String[] args) {
        File file = new File("path_to_your_file");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("target_string")) { // Security sensitive operation
                    // Do something here
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}