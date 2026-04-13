import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class java_37019_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_37019_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username, String password) {
        String encryptedPassword = hashPassword(password);
        String sessionId = generateSessionId(username, encryptedPassword);
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            return new String(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String generateSessionId(String username, String encryptedPassword) {
        return username + "_" + encryptedPassword;
    }
}