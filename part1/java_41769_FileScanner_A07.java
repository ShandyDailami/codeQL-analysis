import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_41769_FileScanner_A07 {

    public static void main(String[] args) {
        File file = new File("src/main/resources/authFailures.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if (line.startsWith("A07_AuthFailure")) {
                    System.out.println("Authentication failure detected in line: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}