import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_22556_FileScanner_A03 {
    public static void main(String[] args) {
        String filePath = "/path/to/file";
        File file = new File(filePath);

        // No external frameworks or libraries allowed.
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        }
    }
}