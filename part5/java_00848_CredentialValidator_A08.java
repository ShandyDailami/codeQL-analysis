import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class java_00848_CredentialValidator_A08 {
    private static final String SALT_PREFIX = "salty";
    private static final int SALT_SIZE = 16;
    private static final String HASH_ALGORITHM = "SHA-256";

    public static void main(String[] args) {
        String password = "password"; // This should not be hardcoded
        String salt = generateSalt();
        String hashedPassword = hashPassword(password, salt);

        System.out.println("Salt: " + salt);
        System.out.println("Hashed password: " + hashedPassword);
    }

    private static String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[SALT_SIZE];
        random.nextBytes(salt);
        return SALT_PREFIX + new String(salt);
    }

    private static String hashPassword(String password, String salt) {
        MessageDigest digest = getMessageDigest();
        digest.update(salt.getBytes());
        byte[] hashedPasswordBytes = digest.digest(password.getBytes());
        return new String(hashedPasswordBytes);
    }

    private static MessageDigest getMessageDigest() {
        try {
            return MessageDigest.getInstance(HASH_ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-256 algorithm not available.");
        }
    }
}