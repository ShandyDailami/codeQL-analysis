import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_39060_FileScanner_A07 {
    public static void main(String[] args) {
        File file = new File("src/main/java/A07_AuthFailure.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Process the line here...
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}