import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_05305_CredentialValidator_A07 {

    // This is the hardcoded username and password
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    // This is the MD5 hash of the hardcoded password
    private static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean validateCredentials(String username, String password) {
        return username.equals(USERNAME) && hashPassword(password).equals(PASSWORD);
    }

    public static void main(String[] args) {
        System.out.println(validateCredentials("user", "password")); // Should print true
        System.out.println(validateCredentials("wrongUser", "password")); // Should print false
        System.out.println(validateCredentials("user", "wrongPassword")); // Should print false
        System.out.println(validateCredentials("wrongUser", "wrongPassword")); // Should print false
    }
}