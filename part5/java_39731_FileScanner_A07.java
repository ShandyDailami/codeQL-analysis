import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_39731_FileScanner_A07 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/main/resources/sample.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            // Placeholder for security-sensitive operation
            // This is just an example, the actual operation can be different
            // This operation is intentionally kept simple for the sake of brevity
            System.out.println(line.toUpperCase());
        }

        scanner.close();
    }
}