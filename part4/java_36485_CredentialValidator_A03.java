import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_36485_CredentialValidator_A03 {

    public static void main(String[] args) {
        CredentialValidator validator = new SecurePasswordValidator();

        // Testing the validator
        String testPassword = "securePassword";
        System.out.println("Is password secure? " + validator.isPasswordSecure(testPassword));
    }

    public boolean isPasswordSecure(String password) {
        // Hash the password using a stronger algorithm
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            String securePassword = Base64.getEncoder().encodeToString(hash);

            // Check if the secure password is the same as the test password
            return securePassword.equals(hashPassword(password));
        } catch (NoSuchAlgorithmException e) {
            // Handle exception
            e.printStackTrace();
        }
        return false;
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            // Handle exception
            e.printStackTrace();
        }
        return null;
    }
}