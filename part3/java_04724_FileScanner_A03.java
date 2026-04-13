import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_04724_FileScanner_A03 {
    private static final String DIRECTORY = "/path/to/directory";
    private static final String FILE = "file.txt";

    public static void main(String[] args) {
        File directory = new File(DIRECTORY);
        File file = new File(DIRECTORY, FILE);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // use ofString method to prevent SQL injection
                // example: use of String.format method to prevent SQL wildcards
                String query = String.format("SELECT * FROM table WHERE column = %s", line);
                // ... do something with the query
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}