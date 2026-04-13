import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_13962_FileScanner_A08 {

    public static void main(String[] args) {
        File file = new File("src/main/resources/legacy.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Perform security-sensitive operations related to A08_IntegrityFailure
                // ...
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}