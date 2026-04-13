import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_32762_CredentialValidator_A01 {

    public static boolean validate(String username, String password) {
        try {
            // Create a MessageDigest instance for SHA-256
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

            // Add username and password to the MessageDigest
            messageDigest.update(username.getBytes(StandardCharsets.UTF_8));
            messageDigest.update(password.getBytes(StandardCharsets.UTF_8));

            // Get the hash bytes
            byte[] hashBytes = messageDigest.digest();

            // Convert the hash bytes to a Base64-encoded string
            String hashString = Base64.getEncoder().encodeToString(hashBytes);

            // Check if the hash string matches a predefined string
            // Replace 'your_string_to_match' with the actual string you want to match
            if (hashString.equals("your_string_to_match")) {
                return true;
            } else {
                return false;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        String username = "testuser";
        String password = "testpassword";
        boolean valid = validate(username, password);
        System.out.println("User is valid: " + valid);
    }
}