import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_34820_SessionManager_A03 {
    private static final String SALT = "A03_Injection";

    public static String createSession(String userId) throws NoSuchAlgorithmException {
        String userInput = userId + SALT;
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digest = md.digest(userInput.getBytes());
        return Base64.getEncoder().encodeToString(digest);
    }

    public static boolean validateSession(String session, String userId) throws NoSuchAlgorithmException {
        String userInput = userId + SALT;
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digest = md.digest(userInput.getBytes());
        return Base64.getEncoder().encodeToString(digest).equals(session);
    }
}