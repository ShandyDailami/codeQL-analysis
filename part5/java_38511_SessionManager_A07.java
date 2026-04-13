import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_38511_SessionManager_A07 {
    private static final String SALT = "some_salt";

    public static void main(String[] args) {
        String sessionData = "session data";
        String hashedData = hashSessionData(sessionData);
        String encodedSessionData = encodeSessionData(hashedData);

        System.out.println("Encoded Session Data: " + encodedSessionData);
    }

    private static String hashSessionData(String data) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(data.getBytes());
            byte[] bytes = md.digest();

            return Base64.getEncoder().encodeToString(bytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private static String encodeSessionData(String data) {
        return Base64.getEncoder().encodeToString(data.getBytes());
    }
}