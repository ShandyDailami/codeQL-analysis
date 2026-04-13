import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class java_09781_CredentialValidator_A03 {
    // Define a static hashed password for the example
    private static final String HASHED_PASSWORD = "5baa61e4c9b64286efa71f62992b3f6c4bed8fe1ad6cf4cc4df941437";

    public static boolean validatePassword(String password) {
        try {
            // Create a MessageDigest instance for SHA-256
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // Compute the hash of the password
            byte[] hash = md.digest(password.getBytes());

            // Convert the hash to a Base64 string
            String passwordHash = Base64.getEncoder().encodeToString(hash);

            // Compare the password hash with the stored hash
            return Arrays.equals(md5(password), passwordHash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static byte[] md5(String input) {
        byte[] bytesOfInput = input.getBytes();
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        byte[] theMD5Digest = md.digest(bytesOfInput);
        return theMD5Digest;
    }

    public static void main(String[] args) {
        String password = "password";
        System.out.println("Password is valid: " + validatePassword(password));
    }
}