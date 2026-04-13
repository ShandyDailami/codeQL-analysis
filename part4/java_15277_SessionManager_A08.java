import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class java_15277_SessionManager_A08 {

    private static final String ALGORITHM = "SHA-256";
    private static final int KEY_LENGTH = 16;

    private java_15277_SessionManager_A08() {
    }

    public static String createSession(String data) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(ALGORITHM);
        md.update(data.getBytes());
        byte[] digest = md.digest();

        return toHexString(digest);
    }

    public static boolean verifySession(String data, String expectedHash) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(ALGORITHM);
        md.update(data.getBytes());
        byte[] digest = md.digest();

        return toHexString(digest).equals(expectedHash);
    }

    private static String toHexString(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            hexString.append(String.format("%02X", b));
        }
        return hexString.toString();
    }
}