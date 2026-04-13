import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_36819_FileScanner_A07 {

    public static void main(String[] args) {
        String filePath = "path/to/file.txt"; // replace with your file path
        File file = new File(filePath);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // perform security-sensitive operation here
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}