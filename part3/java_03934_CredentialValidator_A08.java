import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class java_03934_CredentialValidator_A08 {
    private static final MessageDigest digest = MessageDigest.getInstance("SHA-256");
    private static final SecureRandom rand = new SecureRandom();

    public static class Credential {
        private final String username;
        private final String passwordHash;

        public java_03934_CredentialValidator_A08(String username, String password) throws NoSuchAlgorithmException {
            this.username = username;
            hashPassword(password);
        }

        public boolean checkPassword(String password) throws NoSuchAlgorithmException {
            String hashedPassword = hashPassword(password);
            return hashedPassword.equals(this.passwordHash);
        }

        private String hashPassword(String password) throws NoSuchAlgorithmException {
            byte[] hash = digest.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        }
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Credential credential = new Credential("user1", "password1");
        CredentialValidator validator = new CredentialValidator();

        // Check if password matches
        if (credential.checkPassword("wrongPassword")) {
            System.out.println("Invalid password");
        } else if (credential.checkPassword("password1")) {
            System.out.println("Valid password");
        }
    }
}