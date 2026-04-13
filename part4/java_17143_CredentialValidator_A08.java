import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class java_17143_CredentialValidator_A08 {

    private static final String SALT_ALGORITHM = "SHA-1";
    private static final int SALT_SIZE = 16;
    private static final String PASSWORD_ALGORITHM = "MD5";
    private static final int PASSWORD_SIZE = 16;

    private static String digest(String password, String salt) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance(SALT_ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
        digest.update(salt.getBytes());
        byte[] hashedPassword = digest.digest(password.getBytes());
        return bytesToHex(hashedPassword);
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    }

    public static boolean authenticate(String userPassword, String userSalt, String storedPassword, String storedSalt) {
        String hashedPassword = digest(userPassword, userSalt);
        return hashedPassword.equals(storedPassword);
    }

    public static String createSalt() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] salt = new byte[SALT_SIZE];
        secureRandom.nextBytes(salt);
        return bytesToHex(salt);
    }

    public static String encryptPassword(String password) {
        String salt = createSalt();
        return salt + digest(password + salt, salt);
    }
}