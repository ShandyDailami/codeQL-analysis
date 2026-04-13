import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_12037_CredentialValidator_A03 {

    public boolean validatePassword(String password, String correctPassword) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            String passwordHash = sb.toString();

            if (passwordHash.equals(correctPassword)) {
                System.out.println("Login successful");
                return true;
            } else {
                System.out.println("Invalid password");
                return false;
            }
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.validatePassword("password", "a9c20d123......"); // This should be the hash of "password"
    }
}