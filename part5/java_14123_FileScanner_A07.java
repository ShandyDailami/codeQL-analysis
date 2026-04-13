import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_14123_FileScanner_A07 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("src/main/resources/password.txt"));
            String password = scanner.next(); // Read the password from the file

            // Simulate authentication process
            boolean isAuthenticated = authenticate(password);

            if (!isAuthenticated) {
                throw new AuthenticationException("Authentication failed");
            }

            System.out.println("Access granted");

        } catch (FileNotFoundException e) {
            System.out.println("Password file not found");
        } catch (AuthenticationException e) {
            System.out.println(e.getMessage());
        }
    }

    private static boolean authenticate(String password) {
        // Simulate heavy authentication process
        // Return true if password matches, false otherwise
        return password.equals("secure_password");
    }

    static class AuthenticationException extends Exception {
        public java_14123_FileScanner_A07(String message) {
            super(message);
        }
    }
}