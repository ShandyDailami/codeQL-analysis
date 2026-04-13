import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_06799_FileScanner_A03 {

    public static void main(String[] args) {
        String filePath = "/path/to/your/file.txt"; // specify your file path
        String searchString = "searchString"; // specify your search string

        File file = new File(filePath);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(searchString)) {
                    System.out.println("Found in line: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}