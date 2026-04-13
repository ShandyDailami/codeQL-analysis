import java.security.SecureRandom;
import java.util.Base64;

public class java_18031_SessionManager_A08 {
    private static final SecureRandom RANDOM = new SecureRandom();
    private static final Base64.Encoder ENCODER = Base64.getEncoder();

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    private java_18031_SessionManager_A08() {}

    public static String generateSessionId() {
        return ENCODER.encodeToString(generateRandomByte(24));
    }

    public static byte[] generateRandomByte(int length) {
        byte[] bytes = new byte[length];
        RANDOM.nextBytes(bytes);
        return bytes;
    }

    public static String generateCsrfToken() {
        return ENCODER.encodeToString(generateRandomByte(32));
    }

    public static byte[] generateRandomByteForCsrfToken(int length) {
        byte[] bytes = new byte[length];
        RANDOM.nextBytes(bytes);
        return bytes;
    }

    public static String generatePasswordHash(String password) {
        return ENCODER.encodeToString(generateRandomByteForPasswordHash(password));
    }

    public static byte[] generateRandomByteForPasswordHash(String password) {
        return RANDOM.drandomBytes(password.getBytes());
    }

    public static String generateRandomCode(int length) {
        StringBuilder builder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            builder.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
        }
        return builder.toString();
    }
}