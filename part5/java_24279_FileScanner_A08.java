import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_24279_FileScanner_A08 {

    private static final String DIRECTORY_PATH = "src/main/resources/";
    private static final String FILE_NAME = "A08_IntegrityFailure.txt";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File(DIRECTORY_PATH + FILE_NAME))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Your security-sensitive operations here. For example, check if the line is null or empty
                if (line != null && !line.isEmpty()) {
                    System.out.println("Found non-empty line: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}