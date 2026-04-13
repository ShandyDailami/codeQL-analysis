import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class java_23716_SessionManager_A07 {

    private Map<String, String> userMap;
    private Map<String, String> sessionMap;

    public java_23716_SessionManager_A07() {
        userMap = new HashMap<>();
        sessionMap = new HashMap<>();
    }

    public String authenticate(String username, String password) {
        String hashedPassword = hashPassword(password);
        if (userMap.containsKey(username) && userMap.get(username).equals(hashedPassword)) {
            String sessionId = generateSessionId();
            sessionMap.put(sessionId, username);
            return sessionId;
        }
        return null;
    }

    public String getUser(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        }
        return null;
    }

    public void logout(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            return new String(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String generateSessionId() {
        return java.util.UUID.randomUUID().toString();
    }
}