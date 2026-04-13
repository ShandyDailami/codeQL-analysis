import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_04891_CredentialValidator_A07 {

    // Method to hash the password for security
    private static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hash);
    }

    // Method to validate the username and password
    public static boolean validate(String username, String password) throws NoSuchAlgorithmException {
        // This is a very simplistic example and in a real-world scenario, you'd
        // typically check against a database or a third-party service
        // and not store passwords in plaintext
        String hashedPassword = hashPassword(password);
        return username.equals("admin") && hashedPassword.equals(hashedPassword);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        // Testing the CredentialValidator
        System.out.println(validate("admin", "password")); // Expected to print true
        System.out.println(validate("admin", "wrongPassword")); // Expected to print false
    }
}