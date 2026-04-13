import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.InvalidParameterException;

public class java_29634_CredentialValidator_A03 {

    private static final SecureRandom random = new SecureRandom();
    private static final String ALPHANUMERIC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public String createRandomPassword(int length) {
        if (length < 1) {
            throw new IllegalArgumentException("Length must be at least 1");
        }
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(ALPHANUMERIC.charAt(random.nextInt(ALPHANUMERIC.length())));
        }
        return sb.toString();
    }

    public String createRandomHashedPassword(int length) {
        String salt = createRandomPassword(length);
        String passwordToHash = salt + createRandomPassword(length);
        return getHashedPassword(passwordToHash, salt, length);
    }

    public String getHashedPassword(String passwordToHash, String salt, int length) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(salt.getBytes());
            byte[] bytes = md.digest(passwordToHash.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

    public boolean validatePassword(String passwordAttempt, String storedPassword, String salt) {
        String hashedAttempt = getHashedPassword(passwordAttempt, salt, storedPassword.length());
        return hashedAttempt.equals(storedPassword);
    }

    public static void main(String[] args) {
        SecureCredentialValidator validator = new SecureCredentialValidator();
        String password = validator.createRandomPassword(10);
        System.out.println("Password: " + password);
        String salt = validator.createRandomPassword(10);
        String hashedPassword = validator.getHashedPassword(password, salt, password.length());
        System.out.println("Hashed Password: " + hashedPassword);
        boolean isValid = validator.validatePassword(password, hashedPassword, salt);
        System.out.println("Is Valid: " + isValid);
    }
}