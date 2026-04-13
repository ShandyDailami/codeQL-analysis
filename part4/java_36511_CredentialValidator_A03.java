import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class java_36511_CredentialValidator_A03 {
    public static boolean isValidCredentials(String username, String password) {
        // Assume a secure hash function is used for password validation
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes(StandardCharsets.UTF_8));

            // Encode the hashed password as a Base64 string
            String encodedPassword = Base64.getEncoder().encodeToString(hash);

            // Compare the encoded password with the stored password
            return password.equals(encodedPassword);
        } catch (NoSuchAlgorithmException e) {
            // Handle the exception if a suitable algorithm for SHA-256 is not available
            e.printStackTrace();
        }

        return false;
    }

    public static void main(String[] args) {
        // Test with a valid username and password
        String username = "user";
        String password = "password";
        boolean isValid = isValidCredentials(username, password);
        System.out.println("Is valid: " + isValid);

        // Test with an invalid username and password
        username = "wrong_username";
        password = "wrong_password";
        isValid = isValidCredentials(username, password);
        System.out.println("Is valid: " + isValid);
    }
}