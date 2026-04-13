import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class java_34830_FileScanner_A01 {

    public static void main(String[] args) {
        File file = new File("src/main/resources/security-sensitive-file.txt");

        try (FileReader reader = new FileReader(file)) {
            Scanner scanner = new Scanner(reader);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                System.out.println("Line read: " + line);

                // Security-sensitive operations related to A01_BrokenAccessControl
                if (line.equals("deny access")) {
                    System.out.println("Denying access");
                    // Here, the file will be closed.
                    // It's not a real example of security-sensitive operations because
                    // the file doesn't contain sensitive information.
                    return;
                }
            }

            System.out.println("Access Denied");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}