import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_30038_FileScanner_A07 {
    public static void main(String[] args) {
        File file = new File("src/main/resources/auth.txt");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("A07_AuthFailure")) {
                    System.out.println("Authentication failure detected in the following line: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Authentication failure: " + e.getMessage());
        }
    }
}