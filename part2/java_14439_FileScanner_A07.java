import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_14439_FileScanner_A07 {

    private static final String USERNAMES_FILE = "usernames.txt";
    private static final String EXPECTED_PASSWORD = "password";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File(USERNAMES_FILE))) {
            while (scanner.hasNextLine()) {
                String username = scanner.nextLine();
                String password = scanner.nextLine();

                if (authenticate(username, password)) {
                    System.out.println("Authentication successful for user: " + username);
                } else {
                    System.out.println("Authentication failed for user: " + username);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file " + USERNAMES_FILE + " was not found.");
        }
    }

    private static boolean authenticate(String username, String password) {
        return password.equals(EXPECTED_PASSWORD);
    }
}