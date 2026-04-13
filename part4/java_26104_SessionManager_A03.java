import java.util.HashMap;

public class java_26104_SessionManager_A03 {
    private HashMap<String, String> sessionMap;
    private HashMap<String, String> userMap;

    public java_26104_SessionManager_A03() {
        sessionMap = new HashMap<>();
        userMap = new HashMap<>();
    }

    public String createSession(String userId) {
        if (userMap.containsKey(userId)) {
            throw new RuntimeException("User already exists.");
        }

        String sessionId = String.valueOf(System.currentTimeMillis());
        sessionMap.put(sessionId, userId);

        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String userId = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            userMap.remove(userId);
        }
    }
}