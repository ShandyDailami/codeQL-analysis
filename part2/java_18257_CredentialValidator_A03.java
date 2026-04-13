import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_18257_CredentialValidator_A03 {

    public static boolean validatePassword(String userInputPassword, String storedPassword) {
        try {
            // Hash the user input password
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(userInputPassword.getBytes());

            // Base64 encode the hash
            String encodedPassword = Base64.getEncoder().encodeToString(hash);

            // Compare the hashed user input password with the stored password
            return storedPassword.equals(encodedPassword);
        } catch (NoSuchAlgorithmException e) {
            // Handle the error
            System.out.println("Error while hashing the password");
            e.printStackTrace();
            return false;
        }
    }
}