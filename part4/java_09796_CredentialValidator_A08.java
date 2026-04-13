import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class java_09796_CredentialValidator_A08 {
    private static final String SALT_PREFIX = "SALT_";

    public static String hashPassword(String password, String salt) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        digest.update(salt.getBytes());
        byte[] hashBytes = digest.digest(password.getBytes());
        String hash = Base64.getEncoder().encodeToString(hashBytes);
        return hash;
    }

    public static String createSalt() {
        SecureRandom random = new SecureRandom();
        String salt = SALT_PREFIX + Base64.getEncoder().encodeToString(random.generateSeed(16));
        return salt;
    }

    public static boolean validatePassword(String password, String salt, String hash) {
        String hashWithSalt = hashPassword(password, salt);
        return hashWithSalt.equals(hash);
    }

    public static void main(String[] args) {
        String password = "test";
        String salt = createSalt();
        String hash = hashPassword(password, salt);
        System.out.println("Salt: " + salt);
        System.out.println("Hash: " + hash);

        boolean valid = validatePassword(password, salt, hash);
        System.out.println("Valid: " + valid);
    }
}