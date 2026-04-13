import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_05286_FileScanner_A01 {
    private static final String FILE_PATH = "src/main/resources/AccessControlFile.txt";

    public static void main(String[] args) {
        File file = new File(FILE_PATH);
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