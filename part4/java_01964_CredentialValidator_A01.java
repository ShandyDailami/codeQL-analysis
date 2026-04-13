import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_01964_CredentialValidator_A01 {
    public static boolean validateCredentials(String username, String password) {
        // If username or password is null, return false
        if (username == null || password == null) {
            return false;
        }
        
        // If username and password match, return true
        if (username.equals("admin") && hashPassword(password).equals("pbkdf2:sha256:100000$YWQzZTY5ZGYzYTk3MzkxMjQ0ZWZhZmVlMzQxY2Y2MzExZWZlM2FmZTkzZjQ2ZTJiZDYxMzg1ZDRlZDc2")) {
            return true;
        }
        
        // If username and password do not match, return false
        return false;
    }

    private static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(validateCredentials("admin", "password"));  // Should print true
        System.out.println(validateCredentials("wrong_username", "password"));  // Should print false
        System.out.println(validateCredentials("admin", "wrong_password"));  // Should print false
        System.out.println(validateCredentials(null, "password"));  // Should print false
        System.out.println(validateCredentials("admin", null));  // Should print false
    }
}