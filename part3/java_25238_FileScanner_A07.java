import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_25238_FileScanner_A07 {

    private static final String AUTH_FAILURE_PATTERN = "%s auth failure for user %s";

    public static void main(String[] args) {
        File file = new File("src/main/resources/authFailures.txt");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] authFailures = line.split(" ");
                String username = authFailures[0];
                String password = authFailures[1];

                System.out.println(String.format(AUTH_FAILURE_PATTERN, "A07", username));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}