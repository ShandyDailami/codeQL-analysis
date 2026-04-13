import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class java_35114_SessionManager_A08 {
    private Map<String, String> sessionMap;
    private MessageDigest md;

    public java_35114_SessionManager_A08() {
        sessionMap = new HashMap<>();

        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public String createSession(String user) {
        String sessionId = "";
        byte[] digest = md.digest(user.getBytes());

        for (int i = 0; i < digest.length; i++) {
            sessionId += digest[i] + " ";
        }

        sessionMap.put(sessionId, user);

        return sessionId;
    }

    public String getUserFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}