import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_10657_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        // Instructions to create a secure file scanner
        File file = new File("src/main/resources/legacy_file.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            // Here you can perform your security-sensitive operations related to A03_Injection
            // e.g., use of SQL injection or XSS attacks
            System.out.println("Line from file: " + line);
        }
        scanner.close();
    }
}