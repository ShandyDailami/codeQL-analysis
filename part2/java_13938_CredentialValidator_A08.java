import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class java_13938_CredentialValidator_A08 {

    // Hard-coded password
    private static final String hardCodedPassword = "password";

    // Method to hash the password
    private static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes("UTF-8"));
            return Arrays.toString(hash);
        } catch (NoSuchAlgorithmException | StringIndexOutOfBoundsException e) {
            throw new RuntimeException(e);
        }
    }

    // Method to validate the password
    public static boolean validatePassword(String password) {
        return hashPassword(password).equals(hashPassword(hardCodedPassword));
    }

    public static void main(String[] args) {
        // Testing with a valid password
        System.out.println(validatePassword("password")); // true

        // Testing with an invalid password
        System.out.println(validatePassword("wrongPassword")); // false
    }
}