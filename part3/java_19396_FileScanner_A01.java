import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_19396_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("path/to/file.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            // Perform security-sensitive operations related to A01_BrokenAccessControl
            // For simplicity, just print the line
            System.out.println(line);
        }

        scanner.close();
    }
}