import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_21473_FileScanner_A07 {
    public static void main(String[] args) {
        File file = new File("src/main/resources/authFailures.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.matches(".*(auth failure).*")) {
                    System.out.println("Auth Failure: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}