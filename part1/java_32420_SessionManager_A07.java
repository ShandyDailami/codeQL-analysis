import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class java_32420_SessionManager_A07 {

    private static final String ALGORITHM = "SHA-256";
    private static final int RANDOM_BYTES = 16;

    private java_32420_SessionManager_A07() {}

    public static String createSession(String userId) {
        return createSession(userId, false);
    }

    public static String createSession(String userId, boolean secure) {
        SecureRandom sr = new SecureRandom();
        byte[] salt = new byte[RANDOM_BYTES];
        sr.nextBytes(salt);

        if (secure) {
            return createSecureSession(userId, salt);
        } else {
            return createNotSecureSession(userId, salt);
        }
    }

    private static String createSecureSession(String userId, byte[] salt) {
        try {
            MessageDigest md = MessageDigest.getInstance(ALGORITHM);
            md.update(salt);
            byte[] hashedBytes = md.digest(userId.getBytes());
            return convertByteToHex(hashedBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-256 algorithm not available");
        }
    }

    private static String createNotSecureSession(String userId, byte[] salt) {
        try {
            MessageDigest md = MessageDigest.getInstance(ALGORITHM);
            md.update(salt);
            byte[] hashedBytes = md.digest(userId.getBytes());
            return new String(hashedBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-256 algorithm not available");
        }
    }

    private static String convertByteToHex(byte[] byteArray) {
        StringBuilder sb = new StringBuilder();
        for (byte b : byteArray) {
            sb.append(String.format("%02X", b));
        }
        return sb.toString();
    }
}