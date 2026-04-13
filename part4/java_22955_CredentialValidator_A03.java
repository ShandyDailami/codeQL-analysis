import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PasswordAuthentication;
import java.security.SecureRandom;
import java.util.Base64;

public class java_22955_CredentialValidator_A03 {

    private static final SecureRandom secureRandom = new SecureRandom();

    public PasswordAuthentication generateSalt() {
        byte[] salt = new byte[16];
        secureRandom.nextBytes(salt);
        return new PasswordAuthentication(salt, salt);
    }

    public String hashPassword(String password, PasswordAuthentication salt) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        byte[] hashedPassword = md.digest(salt.getPassword() + password);
        return Base64.getEncoder().encodeToString(hashedPassword);
    }

    public boolean isValidPassword(String password, String hashedPassword, PasswordAuthentication salt) {
        String hashedAttempt;
        try {
            hashedAttempt = hashPassword(password, salt);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return hashedAttempt.equals(hashedPassword);
    }
}