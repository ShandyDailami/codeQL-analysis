import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class java_40576_SessionManager_A07 {
    private static final String ALGORITHM = "SHA-1";

    private java_40576_SessionManager_A07() {
    }

    private static class SingletonHelper {
        private static final MessageDigest MD = getMessageDigest();
        private static final SecureRandom SR = new SecureRandom();

        private static MessageDigest getMessageDigest() {
            try {
                return MessageDigest.getInstance(ALGORITHM);
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static byte[] hashPassword(String password) {
        return SingletonHelper.MD.digest(password.getBytes());
    }

    public static String createSessionId() {
        byte[] bytes = new byte[16];
        SingletonHelper.SR.nextBytes(bytes);
        return bytesToHex(bytes);
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            hexString.append(String.format("%02X", b));
        }
        return hexString.toString();
    }

    public static boolean isValidSessionId(String sessionId) {
        return sessionId != null && !sessionId.isEmpty();
    }

    public static boolean isPasswordSecure(String password) {
        return password != null && !password.isEmpty();
    }

    public static boolean passwordsMatch(String password1, String password2) {
        return password1 != null && password2 != null && password1.equals(password2);
    }
}