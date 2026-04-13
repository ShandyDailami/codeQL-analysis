import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.InvalidParameterException;

public class java_41935_CredentialValidator_A08 {
    private byte[] salt;
    private byte[] hashedPassword;

    public java_41935_CredentialValidator_A08(String password) {
        if (password == null) {
            throw new InvalidParameterException("Password cannot be null");
        }

        // Generate a random salt
        SecureRandom sr = new SecureRandom();
        salt = new byte[16];
        sr.nextBytes(salt);

        // Hash the password
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            md.update(password.getBytes());
            hashedPassword = md.digest();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean check(String password) {
        if (password == null) {
            throw new InvalidParameterException("Password cannot be null");
        }

        // Hash the input password
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            md.update(password.getBytes());
            byte[] inputPasswordHash = md.digest();

            // Compare the stored password hash with the input password hash
            return MessageDigest.isEqual(hashedPassword, inputPasswordHash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}