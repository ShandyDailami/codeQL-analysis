import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_25853_FileScanner_A03 {
    public static void main(String[] args) {
        File file = new File("src/main/resources/injection.txt"); // specify the file path

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Here we use String's built-in methods for security-sensitive operations.
                // Injection example: SQL Injection.
                dangerousMethod(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void dangerousMethod(String s) {
        // use of a dangerous method to execute SQL Injection
        // the following line of code is vulnerable to an SQL Injection attack
        System.out.println(s);
    }
}