import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_24101_FileScanner_A07 {

    public static void main(String[] args) {
        File file = new File("src/main/resources/input.txt");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Here, we're doing some basic auth check for simplicity,
                // in a real-world application, you'd want to use a more secure method
                // for example, you'd check a hash of the user's password instead of the password itself
                if (line.equals("authFailure")) {
                    System.out.println("Auth failure detected, blocking access...");
                    // Block access here
                    return;
                }
            }

            System.out.println("Access granted!");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}