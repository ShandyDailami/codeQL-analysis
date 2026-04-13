import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_31552_FileScanner_A03 {

    public static void main(String[] args) throws FileNotFoundException {
        // Use relative path for security sensitive operations
        File file = new File("relative/path/to/file");
        Scanner scanner = new Scanner(file);

        // Use security-sensitive operations
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }

        // Close scanner
        scanner.close();
    }
}