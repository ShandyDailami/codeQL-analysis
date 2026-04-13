import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_33743_FileScanner_A07 {
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String AUTH_FILE_PATH = "path/to/auth/file.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username:");
        String enteredUsername = scanner.nextLine();
        System.out.println("Enter your password:");
        String enteredPassword = scanner.nextLine();

        if (authenticate(enteredUsername, enteredPassword)) {
            System.out.println("Authentication successful!");
        } else {
            System.out.println("Authentication failed!");
        }
    }

    private static boolean authenticate(String username, String password) {
        try (Scanner fileScanner = new Scanner(new File(AUTH_FILE_PATH))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] credentials = line.split(":");

                if (credentials[0].equals(username) && credentials[1].equals(password)) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Authentication file not found!");
        }

        return false;
    }
}