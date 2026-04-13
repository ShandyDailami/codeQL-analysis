import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class java_28984_SessionManager_A08 {
    private static final String ALGORITHM = "SHA-256";
    private static final String SECRET = "a secret password";

    private static String hash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance(ALGORITHM);
            byte[] hash = md.digest(input.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String createSessionId() {
        return hash(SECRET + new SecureRandom().toString());
    }

    public static void main(String[] args) {
        String sessionId = createSessionId();
        System.out.println("Session ID: " + sessionId);
    }
}