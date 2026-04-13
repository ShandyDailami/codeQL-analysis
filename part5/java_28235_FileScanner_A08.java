import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_28235_FileScanner_A08 {
    private static final String DIR_PATH = "src/main/resources/";
    private static final String FILE_NAME = "a08_IntegrityFailure.txt";

    public static void main(String[] args) {
        File file = new File(DIR_PATH + FILE_NAME);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}