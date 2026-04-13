import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_22894_FileScanner_A03 {
    public static void main(String[] args) {
        String filePath = "/path/to/file"; // replace with your file path
        File file = new File(filePath);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Process line here. For instance, we're just printing it out:
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        }
    }
}