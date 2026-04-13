import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_39164_FileScanner_A01 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/main/resources/access_control_file.txt");
        Scanner scanner = new Scanner(file);
        String line;

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            // Perform security-sensitive operations related to A01_BrokenAccessControl
            // This example demonstrates a simple string comparison
            if (line.contains("broken_access")) {
                System.out.println("Security-sensitive operation detected: " + line);
            }
        }
        scanner.close();
    }
}