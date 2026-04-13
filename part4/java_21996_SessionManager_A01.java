import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class java_21996_SessionManager_A01 {
    private final String password;

    public java_21996_SessionManager_A01(String password) {
        this.password = hashPassword(password);
    }

    public void login(String username, String inputPassword) {
        if (inputPassword.equals(hashPassword(inputPassword))) {
            System.out.println("Welcome " + username);
        } else {
            throw new BrokenAccessControlException("Invalid password");
        }
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            return new String(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        // Create a new SessionManager with a secure password
        SessionManager sm = new SessionManager("securePassword");

        // Login with a secure password
        sm.login("user", "securePassword"); // This should work

        // This should not work
        sm.login("user", "wrongPassword"); // This should throw a BrokenAccessControlException
    }
}