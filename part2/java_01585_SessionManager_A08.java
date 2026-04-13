import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class java_01585_SessionManager_A08 {
    private Map<String, String> sessions = new HashMap<>();

    public void startSession(String user) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        String sessionKey = new String(digest.digest(user.getBytes()));

        if (sessions.containsValue(sessionKey)) {
            throw new IntegrityFailure("Session integrity failure.");
        }

        sessions.put(user, sessionKey);
    }

    public void verifySession(String user, String sessionKey) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        String expectedSessionKey = new String(digest.digest(user.getBytes()));

        if (!sessions.containsKey(user)
                || !sessions.get(user).equals(expectedSessionKey)) {
            throw new IntegrityFailure("Session integrity failure.");
        }
    }
}