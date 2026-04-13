import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_07903_FileScanner_A01 {

    private static final String SECRET_DIRECTORY = "SecretDirectory";
    private static final String SECRET_FILE = "SecretFile";

    public static void main(String[] args) {
        try {
            File file = new File(SECRET_DIRECTORY + File.separator + SECRET_FILE);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Perform security-sensitive operations related to A01_BrokenAccessControl
                System.out.println("Processing line: " + line);
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}