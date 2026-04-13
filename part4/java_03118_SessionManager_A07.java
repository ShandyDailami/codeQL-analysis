import javax.security.auth.login.FailedLoginException;
import java.security.SecureRandom;

public class java_03118_SessionManager_A07 {
    private static final SecureRandom random = new SecureRandom();
    private static final String ALPHANUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            login(USERNAME, PASSWORD);
        } catch (FailedLoginException e) {
            System.out.println("Failed to login, please check your credentials.");
        }
    }

    public static boolean login(String username, String password) throws FailedLoginException {
        // We're not using an actual authentication library in this example.
        // In a real-world situation, this method would authenticate a user against a database of known users.
        // We're just checking if the provided username and password match our hardcoded values.

        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            // If the provided credentials match our hardcoded values, we set a session token.
            // In a real-world situation, this would also involve storing a session token in a database.
            String sessionToken = createSessionToken();
            System.out.println("Session token: " + sessionToken);
            return true;
        } else {
            // If the provided credentials do not match our hardcoded values, we throw a FailedLoginException.
            throw new FailedLoginException("Incorrect username or password.");
        }
    }

    private static String createSessionToken() {
        // We're not using an actual secure random algorithm in this example.
        // In a real-world situation, this would use a secure random algorithm to generate a session token.
        // We're just generating a fixed length string of alphanumeric characters.
        StringBuilder sb = new StringBuilder(16);
        for (int i = 0; i < 16; i++) {
            sb.append(ALPHANUMERIC_STRING.charAt(random.nextInt(ALPHANUMERIC_STRING.length())));
        }
        return sb.toString();
    }
}