import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class java_06161_CredentialValidator_A08 {

    private static final SecureRandom secureRandom = new SecureRandom();

    private java_06161_CredentialValidator_A08() {}

    public static String generateSalt() {
        byte[] salt = new byte[16];
        secureRandom.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    public static String hashPassword(String password, String salt) {
        MessageDigest messageDigest = getMessageDigest();
        messageDigest.update(salt.getBytes());
        byte[] bytes = messageDigest.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }

    private static MessageDigest getMessageDigest() {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-1 is a mandatory algorithm for MessageDigest.", e);
        }
        return messageDigest;
    }

    public static boolean validate(String password, String passwordHash, String salt) {
        String hashedPassword = hashPassword(password, salt);
        return hashedPassword.equals(passwordHash);
    }
}