import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class java_39494_CredentialValidator_A01 {
    private String storedPassword;

    public java_39494_CredentialValidator_A01() throws NoSuchAlgorithmException {
        // generate a secure random password
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);

        MessageDigest md = MessageDigest.getInstance("SHA-1");
        md.update(salt);
        byte[] hashedPassword = md.digest(random.nextBytes(salt));

        // base64 encode the hashed password
        this.storedPassword = Base64.getEncoder().encodeToString(hashedPassword);
    }

    public boolean isValid(String passwordAttempt) {
        try {
            // hash the password attempt
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] hashedAttempt = md.digest(passwordAttempt.getBytes());

            // check if the hashed attempt matches the stored hashed password
            return Base64.getEncoder().encodeToString(hashedAttempt).equals(this.storedPassword);
        } catch (NoSuchAlgorithmException e) {
            return false;
        }
    }
}