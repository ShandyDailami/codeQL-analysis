import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_19030_CredentialValidator_A07 {

    // Hardcoded hash for demonstration purposes
    private static final String HARDCODED_HASH = "21232f297a21d83842f47fe66";

    public static boolean validate(String password) throws NoSuchAlgorithmException {
        // Generate hash of input password
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(password.getBytes());

        // Convert bytes to Base64 string and compare with hardcoded hash
        return Base64.getEncoder().encodeToString(hash).equals(HARDCODED_HASH);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        // Test with valid password
        System.out.println(validate("correct horse battery staple")); // Should print true

        // Test with invalid password
        System.out.println(validate("wrong password")); // Should print false
    }
}