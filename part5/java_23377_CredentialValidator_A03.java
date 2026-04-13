import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_23377_CredentialValidator_A03 {

    // Method to hash password
    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes("UTF-8"));
            return new String(hash, "UTF-8");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Method to validate password
    public static boolean validatePassword(String password, String hashedPassword) {
        return hashedPassword.equals(hashPassword(password));
    }

    // Main method to test the class
    public static void main(String[] args) {
        String password = "password";
        String hashedPassword = hashPassword(password);

        System.out.println("Hashed Password: " + hashedPassword);

        boolean isValid = validatePassword(password, hashedPassword);

        System.out.println("Is Valid: " + isValid);
    }
}